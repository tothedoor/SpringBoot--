package com.hello.hellospring.domain;

import javax.persistence.*;

@Entity // jpa가 관리하는 entity로 설정
public class Member {

    @Id /*PK로 지정*/ @GeneratedValue(strategy = GenerationType.IDENTITY) /*자동으로 생성되는 튜플값임*/
    private  Long id; // 시스템이 저장하는 id

    // @Column(name="username") -> table column의 해당하는 이름에 mapping 되도록함
    // 현재는 column 명과 변수 명이 같으므로 사용 X
    private  String  name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
