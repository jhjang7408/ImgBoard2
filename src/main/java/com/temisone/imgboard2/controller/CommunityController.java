package com.temisone.imgboard2.controller;

import com.temisone.imgboard2.entity.CommunityEntity;
import com.temisone.imgboard2.entity.MemberEntity;
import com.temisone.imgboard2.service.CommunityService;
import com.temisone.imgboard2.service.MypageService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

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





}
