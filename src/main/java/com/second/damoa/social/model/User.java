package com.second.damoa.social.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    private String profile;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

//    @ManyToOne
//    @JoinColumn(name= "group_no")
//    private GroupInfo groupInfo;
//
//    public void setGroupInfo(GroupInfo groupInfo) {
//        this.groupInfo = groupInfo;
//    }
//
//    @OneToMany(mappedBy = "user")
//    private List<UserJoinGroup> userJoinGroups = new ArrayList<UserJoinGroup>();

}
