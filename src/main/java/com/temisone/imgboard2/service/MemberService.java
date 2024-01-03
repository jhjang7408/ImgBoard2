package com.temisone.imgboard2.service;

import com.temisone.imgboard2.entity.MemberEntity;
import com.temisone.imgboard2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(MemberEntity memberEntity){
        memberRepository.save(memberEntity);
    }


    public MemberEntity signin(MemberEntity memberEntity){

        Optional<MemberEntity> signinResult = memberRepository.findByMemberId(memberEntity.getMemberId());

        if(signinResult.isPresent()){

            MemberEntity signinInfo = signinResult.get();

            if(signinInfo.getMemberPassword().equals(memberEntity.getMemberPassword())){

                return memberEntity;
            } else {
                return null;
            }

        } else {
            return null;
        }

    }


}
