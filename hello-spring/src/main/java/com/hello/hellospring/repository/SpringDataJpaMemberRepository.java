package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*JpaRepository를 extends한 interface가 있다면 spring이 자동으로 그 interface에 대한
function들을 생성하고 instance를 생성해서 bean으로 등록해준다.*/
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String Name);

}
