package com.example.twitter.repository;

import com.example.twitter.entity.TweetComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetCommentRepository extends JpaRepository<TweetComment,Long>
{
}
