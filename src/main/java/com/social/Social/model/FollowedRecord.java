//package com.social.Social.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Builder
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "followed_record")
//public class FollowedRecord {
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    int id;
//
//    @OneToOne
//    @JoinColumn(name = "id")
//    FollowerRecord follower;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    User user;
//
//}
