package com.temisone.imgboard2.service;

import com.temisone.imgboard2.entity.MemberEntity;
import com.temisone.imgboard2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MypageService {

    private final MemberRepository memberRepository;

    public MemberEntity loginfo(String memberId){
        Optional<MemberEntity> memberEntity = memberRepository.findByMemberId(memberId);

        return memberEntity.get();
    }


   public void update(MemberEntity memberEntity){
        memberRepository.save(memberEntity);
   }

}
