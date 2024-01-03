package com.temisone.imgboard2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "member")
@Getter
@Setter
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noId;

    @Column
    private String memberId;

    @Column
    private String memberPassword;

    @Column
    private String nickName;

    @Column
    private String memberName;

    @Column
    private String memberTel;

    @Column
    private String memberEmail;




}
