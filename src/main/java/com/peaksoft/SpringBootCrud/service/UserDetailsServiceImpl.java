package com.peaksoft.SpringBootCrud.service;

import com.peaksoft.SpringBootCrud.model.MyUser;
import com.peaksoft.SpringBootCrud.model.User;
import com.peaksoft.SpringBootCrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= repository.getUserByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("could not find user");
        }

        return new MyUser(user);
    }
}

