package com.temisone.imgboard2.service;

import com.temisone.imgboard2.entity.CommunityEntity;
import com.temisone.imgboard2.entity.MemberEntity;
import com.temisone.imgboard2.repository.CommunityRepository;
import com.temisone.imgboard2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommunityService {

    private final CommunityRepository communityRepository;
    private final MemberRepository memberRepository;

    public List<CommunityEntity> findAll(){
        return communityRepository.findAll();
    }

    public void write (CommunityEntity communityEntity, MultipartFile file) throws IOException{

        if(file.isEmpty()){
            communityRepository.save(communityEntity);
        }else {
            String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\community";
            UUID uuid1 = UUID.randomUUID();
            String imgname = uuid1 + "_" + file.getOriginalFilename();
            File saveFile = new File(projectPath, imgname);
            file.transferTo(saveFile);

            communityEntity.setImgname(imgname);
            communityEntity.setImgpath("/community/" + imgname);

            communityRepository.save(communityEntity);
        }
    }

    public Optional<CommunityEntity> view(int communityId){
        return communityRepository.findById(communityId);
    }


    public void update(CommunityEntity communityEntity){
        communityRepository.save(communityEntity);
    }

    public void update2(CommunityEntity communityEntity, MultipartFile file) throws IOException{
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\community";
        UUID uuid1 = UUID.randomUUID();
        String imgname = uuid1 + "_" + file.getOriginalFilename();
        File saveFile = new File(projectPath, imgname);
        file.transferTo(saveFile);

        communityEntity.setImgname(imgname);
        communityEntity.setImgpath("/community/" + imgname);

        communityRepository.save(communityEntity);
    }


}
