package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest // 없으면 @Autowired 사용 불가
@Transactional // 테스트 롤백
public class MemberServiceTest {

    @Autowired MemberService memberService; // 테스트니까 간단하게 필드 주입
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    // @Rollback(false) // 데이터 확인 해보기~
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("kang");

        // when
        Long savedId = memberService.join(member);

        // then
//        em.flush(); // 쿼리 확인
        assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("hugo");

        Member member2 = new Member();
        member2.setName("hugo");

        // when
        memberService.join(member1);
        memberService.join(member2);
        // (expected = IllegalStateException.class) 작성으로 생략 가능
//        try {
//            memberService.join(member2);
//        } catch (IllegalStateException e) {
//            return;
//        }

        // then
        fail("예외가 발생해야 한다.");
    }
}