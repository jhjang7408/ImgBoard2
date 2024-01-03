package com.temisone.imgboard2.controller;

import com.temisone.imgboard2.entity.MemberEntity;
import com.temisone.imgboard2.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Member;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;


    @GetMapping("/member/signin")
    public String signinForm(){
        return "/member/signin";
    }

    @PostMapping("/member/signin")
    public String signin(@ModelAttribute MemberEntity memberEntity, HttpSession session){

        MemberEntity signinResult = memberService.signin(memberEntity);

        if(signinResult != null){
            session.setAttribute("signinmemberId", signinResult.getMemberId());

            return "redirect:/";
        } else {
            return "/member/signin";
        }

    }





    @GetMapping("/member/signup")
    public String signupForm(){
        return "/member/signup";
    }

    @PostMapping("/member/signup")
    public String signup(@ModelAttribute MemberEntity memberEntity){
        memberService.save(memberEntity);
        return "redirect:/member/signin";
    }





    @GetMapping("/member/logout")
    public String logout(HttpSession session){

        session.invalidate();

        return "redirect:/";
    }


}
