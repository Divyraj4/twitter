package com.example.twitter.repository;

import com.example.twitter.entity.Tweet;
import com.example.twitter.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TweetRepositoryTest
{   @Autowired
    TweetRepository tweetRepository;
    @Autowired
    UserRepository userRepository;
    @Test
    public void save()
    {   //System.out.println("hello");
        User u=userRepository.findByUserid(1L);
        Tweet t=Tweet.builder().tweetmsg("Jay hind").user(u).build();
        tweetRepository.save(t);

    }
}