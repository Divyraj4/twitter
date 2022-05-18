package com.example.twitter.Controller;


import com.example.twitter.entity.*;
import com.example.twitter.model.jwtRequest;
import com.example.twitter.model.jwtResponse;
import com.example.twitter.repository.*;
import com.example.twitter.service.UserService;
import com.example.twitter.utility.JWTUtility;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HomeController
{
    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;
    //this object will be required to check from the database wheter the username and password are valid or not
    //if they are valid then the jwt utility class will generate a token for it

    @Autowired
    private UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TweetRepository tweetRepository;
    @Autowired
    UserFeedRepository userFeedRepository;
    @Autowired
    TweetLikeRepository tweetLikeRepository;
    @Autowired
    TweetCommentRepository tweetComment;
    @Autowired
    UserFolloweRepository userFolloweRepository;
    @GetMapping("/all")
    public List<User> findAllUser()
    {
        List<User> a=userRepository.findAll();
        return a;
    }
    @PostMapping("/signup")
    public User save(@RequestBody User u)
    {
       userRepository.save(u);
       return u;
    }

    @GetMapping("/alltweets")
    public List<Tweet> getalltweet()
    {
        List<Tweet> a = tweetRepository.findAll();
        return a;
    }
    @GetMapping("/allfollwer/{fid}")
   public List<UserFollower> getalltweett(@PathVariable("fid") long fid)
  {
      System.out.println("Hello");
       List<UserFollower> a = userFolloweRepository.findUserFollowersByUser_Userid(1);
        return a;
  }
  @PostMapping("/addlike/{tweetid}/{userid}")
  public void add(@PathVariable("tweetid")Long tweetid,@PathVariable("userid")Long userid)
  {

     Tweet t=tweetRepository.findTweetByTweetid(tweetid);
      User u=userRepository.findByUserid(userid);
     // System.out.println(t+""+u);
      TweetLike tw=TweetLike.builder().tweet(t).user(u).build();
      tweetLikeRepository.save(tw);
  }
  @PostMapping("/follow/{userid1}/{userid2}")
  public void follow(@PathVariable("userid1")Long userid1,@PathVariable("userid2")Long userid2)
  {
      User user1=(User) userRepository.findByUserid(userid1);
      User user2=(User) userRepository.findByUserid(userid2);
      //System.out.println(user1);
      //System.out.println(user2);
      UserFollower u=UserFollower.builder().user(user1).userr(user2).build();
      userFolloweRepository.save(u);
  }
  @GetMapping("/follower/{uid}")
  public List<UserFollower>follower(@PathVariable("uid")Long uid)
  {
     List<UserFollower>f=userFolloweRepository.findUserFollowersByUser_Userid(uid);
      return f;
  }
    @PostMapping("/authenticate")
    public jwtResponse authenticate(@RequestBody jwtRequest jwtRequest) throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getName(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = userService.loadUserByUsername(jwtRequest.getName());
          System.out.println("Hello");
        final String token =
                jwtUtility.generateToken(userDetails);

        return  new jwtResponse(token);
    }

}
