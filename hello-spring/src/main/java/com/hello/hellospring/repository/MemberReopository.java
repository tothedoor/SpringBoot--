package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberReopository {
    Member save(Member member);
    Optional<Member> findById(Long id); // optional은 null 반환시에 이를 처리할 때 선호하는 방법이라고 한다.
    Optional<Member> findByName(String Name); // 이름으로 회원찾아 반환
    List<Member> findAll(); // 저장된 모든 회원 리스트 반환
}
