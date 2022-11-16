package com.sdarm.meetingregistration.config;

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
public class JwtTokenFilter extends OncePerRequestFilter {

  /*  private final JwtTokenUtil jwtTokenUtil;
    private final UserRepo userRepo;

    public JwtTokenFilter(JwtTokenUtil jwtTokenUtil,
                          UserRepo userRepo) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepo = userRepo;
    }*/

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {

        if (request.getRequestURI().contains("api/public")
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
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            //chain.doFilter(request, response);
            return;
        }

        // Get jwt token and validate
        final String token = header.split(" ")[1].trim();
        if (!token.equals("MAXIM_KALININ")) {
            log.error("Invalid token for simple auth");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            //chain.doFilter(request, response);
            return;
        }
        /*if (!jwtTokenUtil.validate(token)) {
            chain.doFilter(request, response);
            return;
        }*/

        // Get user identity and set it on the spring security context
      /*  UserDetails userDetails = userRepo
                .findByUsername(jwtTokenUtil.getUsername(token))
                .orElse(null);

        UsernamePasswordAuthenticationToken
                authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null,
                userDetails == null ?
                        List.of() : userDetails.getAuthorities()
        );

        authentication.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);*/

        chain.doFilter(request, response);
    }
}
