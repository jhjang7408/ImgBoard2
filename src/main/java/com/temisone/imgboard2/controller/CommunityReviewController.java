package com.temisone.imgboard2.controller;

import com.temisone.imgboard2.service.CommunityReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CommunityReviewController {

    private final CommunityReviewService communityReviewService;

}
