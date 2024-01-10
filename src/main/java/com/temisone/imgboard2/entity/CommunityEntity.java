package com.temisone.imgboard2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "community")
@Getter
@Setter
public class CommunityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int communityId;

    @Column
    private String memberId;

    @Column
    private String nickName;

    @Column
    private String communityTitle;

    @Column
    private String communityContent;

    @Column
    private String imgname;

    @Column
    private String imgpath;

    @Column
    private LocalDateTime regdate;


    public CommunityEntity(){
        this.regdate=LocalDateTime.now();
    }

}
