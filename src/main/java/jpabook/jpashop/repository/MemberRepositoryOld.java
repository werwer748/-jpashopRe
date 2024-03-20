package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryOld {

//    @PersistenceContext // @RequiredArgsConstructor -> 생성자 생략, @PersistenceContext 생략(스프링 데이터 JPA의 지원)
//    private EntityManager em;
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
//        return em.createQuery("SELECT m FROM Member m WHERE m.name LIKE CONCAT('%', :name, '%') ", Member.class)
        return em.createQuery("SELECT m FROM Member m WHERE m.name =:name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
