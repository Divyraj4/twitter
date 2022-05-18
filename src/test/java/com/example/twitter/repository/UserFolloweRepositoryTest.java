package com.example.twitter.repository;

import com.example.twitter.entity.User;
import com.example.twitter.entity.UserFollower;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserFolloweRepositoryTest
{   @Autowired
    UserRepository userRepository;
    @Autowired
    UserFolloweRepository userFolloweRepository;
    @Test
    public void save()
    {
        User user1=(User) userRepository.findByUserid(1L);
        User user2=(User) userRepository.findByUserid(4L);
        System.out.println(user1);
        System.out.println(user2);
        UserFollower u=UserFollower.builder().user(user1).userr(user2).build();
        userFolloweRepository.save(u);

    }
    @Test
    public void findAllFollower()
    {
        System.out.println(userFolloweRepository.findUserFollowersByUser_Userid(1));
    }

}
