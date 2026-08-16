package org.a1aska17.bookhub.service;

import lombok.RequiredArgsConstructor;
import org.a1aska17.bookhub.dto.auth.JwtResponse;
import org.a1aska17.bookhub.dto.auth.LoginRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public JwtResponse authUser(LoginRequest loginRequest) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(loginRequest.getUserEmail(), loginRequest.getUserPassword());
        Authentication authenticationReturnAuthenticationManager = authenticationManager.authenticate(authentication);
        return new JwtResponse(jwtService.generateToken(authenticationReturnAuthenticationManager));
    }
}
