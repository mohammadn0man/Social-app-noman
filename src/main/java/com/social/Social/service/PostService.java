package com.social.Social.service;

import com.social.Social.dto.PostDto;
import com.social.Social.model.FollowRecord;
import com.social.Social.model.Post;
import com.social.Social.repository.PostRepository;
import com.social.Social.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private FollowRecordService followRecordService;

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


    public List<PostDto> getPost(String userName) {
        var customUserDetails = userService.loadUserByUsername(userName);
        var user = followRecordService.getFollowers(customUserDetails.getUserId());
        var res = new ArrayList<Post>();
        for (int i : user) {
            res.addAll(postRepository.findAllByUser(userService.getUserById(i).orElseGet(null)));
        }
        List<PostDto> ret = new ArrayList<>();
        for (var x : res) {
            ret.add(MapperUtil.getModelMapper().map(x, PostDto.class));
        }
        return ret;
    }
}
