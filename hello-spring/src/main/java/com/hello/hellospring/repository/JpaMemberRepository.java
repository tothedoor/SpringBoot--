package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    // 의존성 주입을 통해 라이브러리 다운을 하게 되면 springboot가 자동으로 em을 생성해주므로 우리는
    // injection만 해주면 된다. --> 즉 jpa를 사용하려면 EM(Entity Manager)을 주입받아야 한다.
    private final EntityManager em; // jpa는 entity manager로 모든 동작을 수행

    public JpaMemberRepository(EntityManager em) {
        this.em = em; // injection
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);// param은 조회할 type과 식별자
        return Optional.ofNullable(member); // Optional로 반환해야 하므로(null handling을 위해)
    }

    @Override
    public Optional<Member> findByName(String Name) {
        // PK 기반 find가 아니므로 jpql 작성해야함
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", Name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // PK 기반 find가 아니므로 jpql 작성해야함
        // JPQL 이라는 query 언어를 사용해야 한다. -> 객체를 대상으로 qeury를 날리는 것이다.
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
