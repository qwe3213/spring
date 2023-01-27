package hello.hellospring.controller;


import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
   private final MemberService memberService;
//   @Autowired private final MemberService memberService; //           필드주입식 방법
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    //   @Autowired는 스프링 컨테이너에서 memberService을 가져오는것이다. 생성자 주입식 , 대부분 생성자 주입식사용하고 권장함
}
