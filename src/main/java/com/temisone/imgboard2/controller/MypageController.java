package com.temisone.imgboard2.controller;

import com.temisone.imgboard2.entity.MemberEntity;
import com.temisone.imgboard2.service.MemberService;
import com.temisone.imgboard2.service.MypageService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Member;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MypageController {

    private final MypageService mypageService;

    @GetMapping("/mypage/loginfochange")
    public String loginfochangeForm(HttpSession session, Model model){

        String loginId = (String) session.getAttribute("signinmemberId");

        MemberEntity member = mypageService.loginfo(loginId);

        model.addAttribute("memberinfo", member);

        return "/mypage/loginfochange";
    }

    @PostMapping("/mypage/loginfochange")
    public String loginfochange(@ModelAttribute MemberEntity memberEntity){

        mypageService.update(memberEntity);

        return "redirect:/mypage/loginfochange";
    }


}
