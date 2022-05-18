package com.example.twitter.repository;

import com.example.twitter.entity.Tweet;
import com.example.twitter.entity.TweetLike;
import com.example.twitter.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TweetLikeRepositoryTest
{   @Autowired
     TweetLikeRepository tweetLikeRepository;
    @Autowired
     TweetRepository tweetRepository;
    @Autowired
    UserRepository userRepository;
    @Test
    public void save()
    {

        Tweet t=tweetRepository.findTweetByTweetid(2l);
        User u=userRepository.findByUserid(1L);
        System.out.println(t);
        TweetLike tw=TweetLike.builder().tweet(t).user(u).build();
        tweetLikeRepository.save(tw);
    }
}