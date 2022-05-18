package com.example.twitter.repository;

import com.example.twitter.entity.UserFollower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFolloweRepository extends JpaRepository<UserFollower,Long>
{
     List<UserFollower>findUserFollowersByUser_Userid(long a);
}
