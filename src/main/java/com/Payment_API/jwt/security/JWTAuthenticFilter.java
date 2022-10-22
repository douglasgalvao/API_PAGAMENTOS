package com.Payment_API.jwt.security;

import com.Payment_API.entities.response.Token;
import com.Payment_API.entities.user.UserBank;
import com.Payment_API.jwt.data.UserDataDetails;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthenticFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    public static final int TOKEN_EXPIRED = 600_000;
    public static final String TOKEN_SENHA = "2e63d3ea-ae15-47ef-87e4-a67da043105e";

    public JWTAuthenticFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
            UserBank userbank = new ObjectMapper().readValue(request.getInputStream(), UserBank.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userbank.getLogin(), userbank.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException("Fail to authenticate the user", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        UserDataDetails userDataDetails = (UserDataDetails) authResult.getPrincipal();

        if (userDataDetails.getUserBank().isPresent()) {
            String token = JWT.create().
                    withSubject(userDataDetails.getUserBank().get().toStringDTO())
                    .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRED))
                    .sign(Algorithm.HMAC512(TOKEN_SENHA));
            response.getWriter().write(token);
            response.getWriter().flush();
        }
    }
}


