package jpabook.jpashop.repository;


import jpabook.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // select m from Member m where m.name = ?
    // ByName이 Member 엔티티의 name필드와 일치하기 때문에 자동으로 JPQL이 생성된다.
    List<Member> findByName(String name);
}
