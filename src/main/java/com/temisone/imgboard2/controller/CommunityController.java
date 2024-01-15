package com.temisone.imgboard2.controller;

import com.temisone.imgboard2.entity.CommunityEntity;
import com.temisone.imgboard2.entity.CommunityReviewEntity;
import com.temisone.imgboard2.entity.MemberEntity;
import com.temisone.imgboard2.service.CommunityReviewService;
import com.temisone.imgboard2.service.CommunityService;
import com.temisone.imgboard2.service.MypageService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    private final CommunityReviewService communityReviewService;

    private final MypageService mypageService;

    @GetMapping("/community/board")
    public String board(Model model){

        List<CommunityEntity> list = communityService.findAll();

        model.addAttribute("list", list);

        return "/community/board";
    }


    @GetMapping("/community/write")
    public String writeForm(Model model, HttpSession session){

        String loginId = (String) session.getAttribute("signinmemberId");

        MemberEntity member = mypageService.loginfo(loginId);

        model.addAttribute("nike", member);

        return "/community/write";
    }


    @PostMapping("/community/write")
    public String write(@ModelAttribute CommunityEntity communityEntity, MultipartFile file) throws IOException {

        communityService.write(communityEntity, file);

        return "redirect:/community/board";
    }


    @GetMapping("/community/view/{communityId}")
    public String view(@PathVariable int communityId, Model model){

        Optional<CommunityEntity> communityEntity = communityService.view(communityId);

        model.addAttribute("view", communityEntity.get());

        List<CommunityReviewEntity> review = communityReviewService.review(communityId);

        model.addAttribute("review", review);

        return "/community/view";
    }



    @GetMapping("/community/update/{communityId}")
    public String updateForm(@PathVariable int communityId, Model model){

        Optional<CommunityEntity> communityEntity = communityService.view(communityId);

        model.addAttribute("view", communityEntity.get());

        return "/community/update";
    }

    @PostMapping("/community/update/{communityId}")
    public String update(@PathVariable int communityId, @ModelAttribute CommunityEntity communityEntity,
                         @RequestParam("file") MultipartFile file) throws IOException{

        if(file.isEmpty()){
            Optional<CommunityEntity> communityEntity1 = communityService.view(communityId);

            communityEntity.setImgname(communityEntity1.get().getImgname());
            communityEntity.setImgpath(communityEntity1.get().getImgpath());

            communityService.update(communityEntity);
        } else {

            communityService.update2(communityEntity, file);
        }

        return "redirect:/community/board";
    }


    @GetMapping("/community/delete/{communityId}")
    public String delete(@PathVariable int communityId){
        communityService.delete(communityId);

        return "redirect:/community/board";
    }



}
