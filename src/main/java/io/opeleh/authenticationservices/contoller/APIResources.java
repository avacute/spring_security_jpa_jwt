package io.opeleh.authenticationservices.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.opeleh.authenticationservices.dto.AuthenticationBasicRequest;
import io.opeleh.authenticationservices.dto.AuthenticationResponse;
import io.opeleh.authenticationservices.service.AuthUserDetailsService;
import io.opeleh.authenticationservices.util.GenerateJWT;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class APIResources {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AuthUserDetailsService userDetailService;

    @Autowired
    GenerateJWT generatJWT;


    @RequestMapping("/")
    public String test(){
        return "hmmm";
    }

   @PostMapping(value="/api/auth/token")
   public ResponseEntity <?> postMethodName(@RequestBody AuthenticationBasicRequest auth_request) throws Exception {
       try{

            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(auth_request.getUsername(), auth_request.getPassword())
            );

       }catch(BadCredentialsException e){
            throw new Exception("Username or Password invalid ", e);
       }

      final UserDetails usersDetails = userDetailService.loadUserByUsername(auth_request.getUsername());
      final String jwt = generatJWT.generateToken(usersDetails);
      final Date JwtExpiry = generatJWT.getExpirationDateFromToken(jwt);
    
      return ResponseEntity.ok(new AuthenticationResponse(jwt,JwtExpiry));
       
   }
    
}