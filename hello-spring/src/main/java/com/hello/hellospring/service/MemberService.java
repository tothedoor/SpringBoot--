package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     * @param member
     * @return member's id
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원X
        validateDuplicatedMember(member); // 중복회원 검증
        // Optional이 아니라 그냥 꺼내고 싶으면 get()으로 꺼내면 된다. -> 권장되지는 않음
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicatedMember(Member member) {
        memberRepository.findByName(member.getName()) // 변수에 할당하지 않고 반환된 것으로 바로 처리 가능
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     * @return 전체 회원 정보
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원ID로 회원 조회
     * @param memberId
     * @return 해당 회원 정보
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
