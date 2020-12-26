package com.capgemini.api.jwtserver.controller;

import com.capgemini.api.jwtserver.controller.dto.JwksResponse;
import com.capgemini.api.jwtserver.controller.dto.TokenRequest;
import com.capgemini.api.jwtserver.service.JwtService;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
public class JwtController {

    @Autowired
    private JwtService jwtService;


    @PostMapping(value = "/token", produces = TEXT_PLAIN_VALUE)
    public String generateToken(@RequestBody TokenRequest request) throws JoseException {
       return jwtService.generateToken(request.getUsername());
    }

    @GetMapping (value = "/jwks.json", produces = APPLICATION_JSON_VALUE)
    public JwksResponse getJwks(TokenRequest request) throws IOException {
        return jwtService.getJwks();
    }
}
