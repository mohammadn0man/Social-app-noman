package com.social.Social.service;

import com.social.Social.dto.PostDto;
import com.social.Social.model.Post;
import com.social.Social.repository.PostRepository;
import com.social.Social.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public boolean addPost(PostDto postDto) {
        var postModel = MapperUtil
                .getModelMapper()
                .map(postDto, Post.class);
        try {
            postRepository.save(postModel);
        } catch (Exception e) {
            log.error("Post not saved");
            return false;
        }
        return true;
    }




}
