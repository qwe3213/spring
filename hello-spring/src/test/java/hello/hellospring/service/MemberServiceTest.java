package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService=new MemberService(memberRepository);
    }
    // 밑의 방법처럼 하면 memberService의 memberRepository와 테스트에서의 memberRepository가 다르기 때문에 같게 하려면 위의 방식처럼 해야함.
      //MemberService memberService = new MemberService();
     // MemoryMemberRepository memberRepository = new MemoryMemberRepository(); // MemverService에서 의MemoryMemberRepository와
     //테스트에서의 MemoryMemberRepository는 다른 것 이지만 private static Map<Long, Member> store = new HashMap<>(); 부분의 static 이없으면 다른 DB가되어 문제 발생.
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    } // 돌떄마다 DB의 값을 날려

    @Test
    void 회원가입() {
        //테스트 같은경우 한글로 써도 무방함.
        //given
        Member member = new Member();
        member.setName("spring");
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
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));// memberService.join(member2)로직을 사용하여
// IllegalStateException 예와가 나와야함
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        try {
//            memberService.join(member2);
//               fail();
//        } catch (IllegalStateException e){
//           assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");// MemberService에서 중복회원 일떄 나오는 값과 같아야함
//        }

        //then
    }

    @Test
    void findMember() {
    }

    @Test
    void findbyId() {
    }
}