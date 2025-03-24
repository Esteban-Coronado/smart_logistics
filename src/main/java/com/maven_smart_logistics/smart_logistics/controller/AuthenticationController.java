package com.maven_smart_logistics.smart_logistics.controller;



import com.maven_smart_logistics.smart_logistics.model.User;
import com.maven_smart_logistics.smart_logistics.model.dto.JWTAndLoginAuthenticatedDTO;
import com.maven_smart_logistics.smart_logistics.model.dto.UserAuthenticationDTO;
import com.maven_smart_logistics.smart_logistics.service.TokenService;
import com.maven_smart_logistics.smart_logistics.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")

public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;



    @PostMapping
    @Transactional
    public ResponseEntity<JWTAndLoginAuthenticatedDTO> authenticateLogin(@RequestBody @Valid UserAuthenticationDTO userAuthenticationData) {

        var user = userService.getUserByEmail(userAuthenticationData.email());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        if(!user.getStatus()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        try {
            Authentication authToken = new UsernamePasswordAuthenticationToken(userAuthenticationData.email(),
                    userAuthenticationData.password());
            var authenticatedUser = authenticationManager.authenticate(authToken);
            String JWTToken = tokenService.generateToken((User) authenticatedUser.getPrincipal(), (User) user);
            return ResponseEntity.ok(new JWTAndLoginAuthenticatedDTO((User) user, JWTToken));

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }





}
