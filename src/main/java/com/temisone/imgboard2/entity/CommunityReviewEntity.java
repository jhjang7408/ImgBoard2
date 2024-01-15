package com.temisone.imgboard2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "communityreview")
@Getter
@Setter
public class CommunityReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int communityreviewId;

    @Column
    private int communityId;

    @Column
    private String communityreviewcontent;

    @Column
    private String nickName;

    @Column
    private LocalDateTime regdate;

    public CommunityReviewEntity(){
        this.regdate=LocalDateTime.now();
    }



}
