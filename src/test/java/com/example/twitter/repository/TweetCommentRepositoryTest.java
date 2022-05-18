package com.example.twitter.repository;

import com.example.twitter.entity.Tweet;
import com.example.twitter.entity.TweetComment;
import com.example.twitter.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TweetCommentRepositoryTest
{
    @Autowired
    UserRepository userRepository;
    @Autowired
    TweetRepository tweetRepository;
    @Autowired
    TweetCommentRepository tweetCommentRepository;
    @Test
    public void save()
    {
       User u=userRepository.findByUserid(1L);
       Tweet t=tweetRepository.findTweetByTweetid(2L);
       TweetComment t1=TweetComment.builder().comment("yeah thats really nice").tweet(t).user(u).build();
       tweetCommentRepository.save(t1);
    }

}