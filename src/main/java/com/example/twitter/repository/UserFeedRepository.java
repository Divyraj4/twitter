package com.example.twitter.repository;

import com.example.twitter.entity.UserFeed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFeedRepository extends JpaRepository<UserFeed,Long>
{
}
