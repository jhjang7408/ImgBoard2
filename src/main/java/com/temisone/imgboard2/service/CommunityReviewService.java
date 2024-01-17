package com.temisone.imgboard2.service;

import com.temisone.imgboard2.entity.CommunityEntity;
import com.temisone.imgboard2.entity.CommunityReviewEntity;
import com.temisone.imgboard2.repository.CommunityReviewRepository;
import jakarta.transaction.Transactional;
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

    public void delete(int communityreviewId){
        communityReviewRepository.deleteById(communityreviewId);
    }

    @Transactional
    public void delete2(int communityId){
        communityReviewRepository.deleteByCommunityId(communityId);
    }

    public CommunityReviewEntity info(int communityreviewId){
        return communityReviewRepository.findByCommunityreviewId(communityreviewId);
    }

}
