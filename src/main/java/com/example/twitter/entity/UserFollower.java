package com.example.twitter.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFollower
{

    @Id
    @SequenceGenerator(
            name = "Id_sequence",
            sequenceName = "Id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Id_sequence"
    )
    private Long followid;
    @ManyToOne(

            cascade = CascadeType.MERGE
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "userId"
    )
    private User user;

    @ManyToOne(

            cascade = CascadeType.MERGE
    )
    @JoinColumn(
            name = "follower_id",
            referencedColumnName = "userId"
    )
    private User userr;



}
