package id.perpus.core.controller;

import id.perpus.core.entity.User;
import id.perpus.core.entity.UserRequest;
import id.perpus.core.entity.UserResponse;
import id.perpus.core.service.JwtTokenService;
import id.perpus.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService tokenService;

    @Autowired
    private UserService service;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuth(@RequestBody UserRequest user)throws Exception{
        authenticate(user.getUsername(), user.getPassword());

        final UserDetails userDetails = service.loadUserByUsername(user.getUsername());

        final String token = tokenService.generateToken(userDetails);

        return ResponseEntity.ok(new UserResponse(token));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody User dto)throws Exception{
        return ResponseEntity.ok(service.save(dto));
    }

    private void authenticate(String username, String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (DisabledException e){
            throw new Exception("USER_DISABLED", e);
        }catch (BadCredentialsException e){
            throw new Exception("INVALID_CREDENTIAL", e);
        }
    }
}
