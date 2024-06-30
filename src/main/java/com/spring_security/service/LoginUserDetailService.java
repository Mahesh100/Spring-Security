package com.spring_security.service;

import com.spring_security.entity.User;
import com.spring_security.repository.LoginUser;
import com.spring_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

public class LoginUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username){
        Optional<User> user=repo.findByUsername(username);
        System.out.println("User is: "+user);
     //   user = Optional.ofNullable(user.orElseThrow(() -> new UsernameNotFoundException("User Not Found")));
        User u = user.orElseThrow(()->new UsernameNotFoundException("User name not found !"));
        return new LoginUser(u);
    }
}
