package com.social.Social.service;

import com.social.Social.dto.FollowRecordDto;
import com.social.Social.model.FollowRecord;
import com.social.Social.repository.FollowRecordRepository;
import com.social.Social.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

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

    public boolean follow(FollowRecordDto followRecordDto) {
        if (followRecordRepository.existsByFollowedByUserIdAndFollowedToUserId(followRecordDto.getFollowedByUserId(), followRecordDto.getFollowedToUserId())) {
            return true;
        }
        var followModel = MapperUtil
                .getModelMapper()
                .map(followRecordDto, FollowRecord.class);
        try {
            followRecordRepository.save(followModel);
        } catch (Exception e) {
            log.error("follower not saved");
            return false;
        }
        return true;
    }

//    public boolean unfollow(FollowRecordDto followRecordDto) {
//        if (!followRecordRepository.existsByFollowedByUserIdAndFollowedToUserId(followRecordDto.getFollowedByUserId(), followRecordDto.getFollowedToUserId())) {
//            return true;
//        }
//        var followModel = MapperUtil
//                .getModelMapper()
//                .map(followRecordDto, FollowRecord.class);
//        try {
//            followRecordRepository.delete(followModel);
//        } catch (Exception e) {
//            log.error("changes to unfollow not saved");
//            return false;
//        }
//        return true;
//    }
}
