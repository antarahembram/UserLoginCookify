package com.stackroute.userloginservice.userloginservice.controller;

import com.stackroute.userloginservice.userloginservice.config.JwtTokenUtil;
import com.stackroute.userloginservice.userloginservice.exception.EmailIdAlreadyTakenException;
import com.stackroute.userloginservice.userloginservice.exception.UserNameAlreadyTakenException;
import com.stackroute.userloginservice.userloginservice.model.*;
import com.stackroute.userloginservice.userloginservice.repository.UserDao;
import com.stackroute.userloginservice.userloginservice.service.JwtUserDetailsService;
import com.stackroute.userloginservice.userloginservice.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class JwtAuthenticationController {

    private AuthenticationManager authenticationManager;

    private JwtTokenUtil jwtTokenUtil;

    private JwtUserDetailsService userDetailsService;

    RabbitMQSender rabbitMQSender;

    private UserDao userDao;

    @Autowired
    public JwtAuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, JwtUserDetailsService userDetailsService, RabbitMQSender rabbitMQSender, UserDao userDao) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.rabbitMQSender = rabbitMQSender;
        this.userDao = userDao;
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);


        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws RuntimeException {
        DAOUser daoUser1 = userDao.findByUsername(user.getUsername());
        DAOUser daoUser2 = userDao.findByEmailId(user.getEmailId());
        if (daoUser1 != null) {
            throw new UserNameAlreadyTakenException("Username Not Available" );
        }
        else if (daoUser2 != null) {
            throw new EmailIdAlreadyTakenException("There is an account linked with this email id");
        }
        else {
            MessageUser messageUser = new MessageUser(user.getUsername(), user.getName(), user.getGender(), user.getEmailId(),user.getCountry(), user.getState(), user.getCity());
            rabbitMQSender.sendUser(messageUser);
            return ResponseEntity.ok(userDetailsService.save(user));
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
