package com.temisone.imgboard2.controller;

import com.temisone.imgboard2.entity.CommunityReviewEntity;
import com.temisone.imgboard2.service.CommunityReviewService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CommunityReviewController {

    private final CommunityReviewService communityReviewService;

    @PostMapping("communityreview/write/{communityId}")
    public String write(@PathVariable int communityId, @ModelAttribute CommunityReviewEntity communityReviewEntity){

        communityReviewService.write(communityReviewEntity);

        return "redirect:/community/view/" + communityId;
    }

}
