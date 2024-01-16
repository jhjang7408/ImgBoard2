package com.temisone.imgboard2.service;

import com.temisone.imgboard2.entity.CommunityEntity;
import com.temisone.imgboard2.entity.CommunityReviewEntity;
import com.temisone.imgboard2.repository.CommunityReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommunityReviewService {

    private final CommunityReviewRepository communityReviewRepository;

    public List<CommunityReviewEntity> review(int communityId){
        return communityReviewRepository.findByCommunityId(communityId);
    }

    public void write(CommunityReviewEntity communityReviewEntity){
        communityReviewRepository.save(communityReviewEntity);
    }

}
