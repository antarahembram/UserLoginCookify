package com.stackroute.userloginservice.userloginservice.service;

import java.util.ArrayList;

import com.stackroute.userloginservice.userloginservice.repository.UserDao;
import com.stackroute.userloginservice.userloginservice.model.DAOUser;
import com.stackroute.userloginservice.userloginservice.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DAOUser user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public DAOUser save(UserDTO user) {
        DAOUser newUser = new DAOUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setName(user.getName());
        newUser.setGender(user.getGender());
        newUser.setEmailId(user.getEmailId());
        newUser.setCountry(user.getCountry());
        newUser.setState(user.getState());
        newUser.setCity(user.getCity());
        return userDao.save(newUser);
    }
}
