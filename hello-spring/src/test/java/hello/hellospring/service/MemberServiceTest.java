package hello.hellospring.service;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
class MemberServiceTest {

       MemberService memberService = new MemberService();

    @Test
    void 회원가입() {
        //테스트 같은경우 한글로 써도 무방함.
        //given
        Member member = new Member();
        member.setName("Hello");
       //when
        Long saveId = memberService.join(member);

        //then
        Member findMember =  memberService.findbyId(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName()); // member의 이름이 fidnMember의 이름과 같은지확인.

    }

    @Test
    void findMember() {
    }

    @Test
    void findbyId() {
    }
}