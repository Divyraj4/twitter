package com.example.twitter.repository;

import com.example.twitter.entity.TweetLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetLikeRepository extends JpaRepository<TweetLike,Long>
{
}
