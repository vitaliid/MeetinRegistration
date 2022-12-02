package com.sdarm.meetingregistration.config;

import com.sdarm.meetingregistration.service.AuthService;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final AuthService authService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {

        if (request.getRequestURI().contains("api/public")
                || request.getRequestURI().contains("api/auth")
                || request.getRequestURI().contains("swagger")
                || request.getRequestURI().contains("api-docs")
                || request.getRequestURI().contains("favicon.ico")) {
            log.info("Public endpoint access: {}", request.getRequestURI());
            chain.doFilter(request, response);
            return;
        }

        // Get authorization header and validate
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (isEmpty(header) || !header.startsWith("Bearer ")) {
            log.error("Not auth token in header");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // Get jwt token and validate
        final String token = header.split(" ")[1].trim();
        try {
            if (!authService.validateToken(token)) {
                log.error("Invalid token for simple auth");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        } catch (ExpiredJwtException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token is expired: " + e.getMessage());
            return;
        }

        chain.doFilter(request, response);
    }
}
