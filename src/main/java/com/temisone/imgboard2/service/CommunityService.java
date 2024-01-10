package com.temisone.imgboard2.service;

import com.temisone.imgboard2.entity.CommunityEntity;
import com.temisone.imgboard2.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommunityService {

    private final CommunityRepository communityRepository;

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
            communityEntity.setImgpath("/" + imgname);

            communityRepository.save(communityEntity);
        }
    }

}
