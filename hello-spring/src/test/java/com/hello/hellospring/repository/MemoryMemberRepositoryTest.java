package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();


    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Minkyu");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("2");
        repository.save(member2);

        Member result = repository.findByName("1").get();
        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        List<Member> list = new ArrayList<>();

        Member member1 = new Member();
        member1.setName("1");
        repository.save(member1);
        list.add(member1);

        Member member2 = new Member();
        member2.setName("2");
        repository.save(member2);
        list.add(member2);

        Member member3 = new Member();
        member3.setName("3");
        repository.save(member3);
        list.add(member3);

        list.add(member3);

        List<Member> result = repository.findAll();
        Assertions.assertThat(list).isEqualTo(result);
    }

}
