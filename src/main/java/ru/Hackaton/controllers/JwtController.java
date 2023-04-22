package ru.Hackaton.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class JwtController {
    private final JwtConfiguration jwtConfiguration;
    private final CreditAgentService creditAgentService;
    private final RefreshTokenService refreshTokenService;
    private final AuthenticationManager authenticationManager;
    private final CreditAgentMapper creditAgentMapper;
    private final int COOKIE_MAX_AGE = 259200;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody CreditAgentAuthDto creditAgentAuthDto, HttpServletResponse response) {
        CreditAgent creditAgent = creditAgentMapper.mapToCreditAgent(creditAgentAuthDto);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(creditAgent.getUsername(), creditAgent.getPassword());

        Authentication auth = authenticationManager.authenticate(token);

        CreditAgent creditAgentAuthenticated = ((CreditAgentDetails) auth.getPrincipal()).getUser();

        RefreshToken refreshToken = new RefreshToken(creditAgentAuthenticated);

        refreshTokenService.updateRefreshToken(creditAgentAuthenticated, refreshToken);

        return returnRefreshAndAccessTokens(response, refreshToken, creditAgentAuthenticated.getUsername());
    }

    private ResponseEntity<Map<String, String>> returnRefreshAndAccessTokens(HttpServletResponse response, RefreshToken refreshToken, String username) {
        String refreshTokenGenerated = jwtConfiguration.generateRefreshToken(username);

        Cookie cookieWithRefreshToken = new Cookie("refresh_token", refreshTokenGenerated);

        cookieWithRefreshToken.setMaxAge(COOKIE_MAX_AGE);
        cookieWithRefreshToken.setHttpOnly(true);
        cookieWithRefreshToken.setSecure(true);

        response.addCookie(cookieWithRefreshToken);

        String accessTokenGenerated = jwtConfiguration.generateAccessToken(username);

        return new ResponseEntity<>(Map.of("access_token", accessTokenGenerated), HttpStatus.OK);
    }
}
