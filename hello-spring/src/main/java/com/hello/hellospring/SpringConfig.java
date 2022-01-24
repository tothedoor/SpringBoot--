package com.hello.hellospring;

import com.hello.hellospring.repository.*;
import com.hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    //private DataSource  dataSource;
    //private EntityManager em;

    // Spring이 자동으로 bean에 등록한 SpringDataJpaMemberRepository를
    // 가져오게 된다!!
    private final MemberRepository memberRepository;

    @Autowired // 생성자가 하나인 경우에는 생략해도 되긴 한다.
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
    */

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository); // injection
    }

/*
    @Bean
    public MemberRepository memberRepository() {
        // return new JdbcTemplateMemberRepository(dataSource);
        // return new JpaMemberRepository(em);
    }
*/

}
