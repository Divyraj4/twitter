package com.example.twitter.service;

import com.example.twitter.UserPrincipal;
import com.example.twitter.entity.User;
import com.example.twitter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {    // System.out.println("at user Service");
        //  System.out.println(username);
       // User user = userRepository.findByUsername(username);
        User user=userRepository.findByName(username);
       // System.out.println(u);
        System.out.println(user);
        if(user==null)
            throw new UsernameNotFoundException("User 404");

       System.out.println(user);
        return new UserPrincipal(user);
    }
}
