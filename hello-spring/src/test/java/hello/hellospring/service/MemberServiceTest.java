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
    public void 중복_회원_예외(){
        //given
         Member member1 = new Member();
         member1.setName("spring");
         Member member2 = new Member();
         member2.setName("spring");
        //when
        memberService.join(member1);
        try {
            memberService.join(member2);
               fail();
        } catch (IllegalStateException e){
           assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");// MemberService에서 중복회원 일떄 나오는 값과 같아야함
        }

        //then
    }

    @Test
    void findMember() {
    }

    @Test
    void findbyId() {
    }
}