package com.social.Social.service;

import com.social.Social.model.FollowRecord;
import com.social.Social.repository.FollowRecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class FollowRecordService {
    @Autowired
    private FollowRecordRepository followRecordRepository;

    public List<Integer> getFollowers(int id) {
        var followers = followRecordRepository
                .findAllByFollowedByUserId(id);
        List<Integer> result = new ArrayList<>();
        for (FollowRecord x :
                followers) {
            result.add(x.getFollowedToUserId());
        }
        return result;
    }
}
