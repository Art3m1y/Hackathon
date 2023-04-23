package ru.Hackaton.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.Hackaton.configurations.JwtConfiguration;
import ru.Hackaton.dtos.CreditAgentAuthDto;
import ru.Hackaton.dtos.mappers.CreditAgentMapper;
import ru.Hackaton.models.CreditAgent;
import ru.Hackaton.models.RefreshToken;
import ru.Hackaton.services.CreditAgentService;
import ru.Hackaton.services.RefreshTokenService;
import ru.Hackaton.services.impl.CreditAgentDetails;

import java.util.Map;
import java.util.Optional;

import static ru.Hackaton.controllers.Validation.validateRequestBody;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final JwtConfiguration jwtConfiguration;
    private final CreditAgentService creditAgentService;
    private final RefreshTokenService refreshTokenService;
    private final AuthenticationManager authenticationManager;
    private final CreditAgentMapper creditAgentMapper;
    private final int COOKIE_MAX_AGE = 259200;

    @PostMapping("/login")
    public ResponseEntity<?> loginCreditAgent(@Valid @RequestBody CreditAgentAuthDto creditAgentAuthDto, BindingResult bindingResult, HttpServletResponse response) {
        validateRequestBody(bindingResult);

        CreditAgent creditAgent = creditAgentMapper.mapToCreditAgent(creditAgentAuthDto);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(creditAgent.getUsername(), creditAgent.getPassword());

        Authentication auth = authenticationManager.authenticate(token);

        CreditAgent creditAgentAuthenticated = ((CreditAgentDetails) auth.getPrincipal()).getCreditAgent();

        RefreshToken refreshToken = new RefreshToken(creditAgentAuthenticated);

        refreshTokenService.updateRefreshToken(creditAgentAuthenticated, refreshToken);

        return returnRefreshAndAccessTokens(response, refreshToken, creditAgentAuthenticated);
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logoutCreditAgent(@CookieValue("refresh_token") Optional<String> refreshTokenFromCookie, HttpServletResponse response) {
        if (refreshTokenFromCookie.isPresent()) {
            String refreshToken = refreshTokenFromCookie.get();
            if (jwtConfiguration.verifyRefreshToken(refreshToken) && refreshTokenService.existsById(jwtConfiguration.getIdFromRefreshToken(refreshToken))) {
                Cookie deleteRefreshTokenCookie = new Cookie("refreshToken", null);
                deleteRefreshTokenCookie.setMaxAge(0);
                response.addCookie(deleteRefreshTokenCookie);
                refreshTokenService.deleteById(jwtConfiguration.getIdFromRefreshToken(refreshToken));
                return ResponseEntity.ok().build();
            }
        }

        throw new RuntimeException("Токен обновления не смог пройти валидацию, либо он уже является не актуальным");
    }

    private ResponseEntity<Map<String, String>> returnRefreshAndAccessTokens(HttpServletResponse response, RefreshToken refreshToken, CreditAgent creditAgentAuthenticated) {
        String refreshTokenGenerated = jwtConfiguration.generateRefreshToken(refreshToken.getId());

        Cookie cookieWithRefreshToken = new Cookie("refresh_token", refreshTokenGenerated);

        cookieWithRefreshToken.setMaxAge(COOKIE_MAX_AGE);
        cookieWithRefreshToken.setHttpOnly(true);
        cookieWithRefreshToken.setSecure(true);

        response.addCookie(cookieWithRefreshToken);

        String accessTokenGenerated = jwtConfiguration.generateAccessToken(creditAgentAuthenticated.getUsername(), creditAgentAuthenticated.getName(), creditAgentAuthenticated.getSurname(), creditAgentAuthenticated.getPatronymic(), creditAgentAuthenticated.isAdmin());

        return new ResponseEntity<>(Map.of("access_token", accessTokenGenerated), HttpStatus.OK);
    }
}
