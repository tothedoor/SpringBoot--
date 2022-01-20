package com.hello.hellospring;

import com.hello.hellospring.repository.MemberReopository;
import com.hello.hellospring.repository.MemoryMemberRepository;
import com.hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberReopository());
    }

    @Bean
    public MemberReopository memberReopository() {
        return new MemoryMemberRepository();
    }
}
