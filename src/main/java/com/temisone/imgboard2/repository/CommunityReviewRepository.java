package com.temisone.imgboard2.repository;

import com.temisone.imgboard2.entity.CommunityReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityReviewRepository extends JpaRepository <CommunityReviewEntity, Integer> {

    List<CommunityReviewEntity> findByCommunityId(int communityId);

}
