package ru.Hackaton.configurations;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final JwtConfiguration jwtConfiguration;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String path = request.getServletPath();

        if (!path.startsWith("/catalog") && (!(path.startsWith("/auth") && !path.equals("/auth/logout")) && (!path.startsWith("/image"))) && (!path.startsWith("/avatar"))) {
            checkAccessToken(request, response);
        }

        filterChain.doFilter(request, response);
    }

    private void checkAccessToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && !authHeader.isBlank() && authHeader.startsWith("Bearer ")) {
            String JWTToken = authHeader.substring(7);
            if (JWTToken.isBlank()) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            } else {
                try {
                    String email = jwtConfiguration.getUsernameFromAccessToken(JWTToken);

                    UserDetails personDetails = userDetailsService.loadUserByUsername(email);

                    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(personDetails, personDetails.getPassword(), personDetails.getAuthorities());

                    if (SecurityContextHolder.getContext().getAuthentication() == null) {
                        SecurityContextHolder.getContext().setAuthentication(token);
                    }
                } catch (Exception e) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                }
            }
        }
    }
}
