package com.social.Social.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Posts")
public class Post {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "postContent", length = 6380)
    private String postContent;
}
