package com.temisone.imgboard2.repository;

import com.temisone.imgboard2.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

    Optional<MemberEntity> findByMemberId(String memberId);
}
