package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //memberRepository를 직접 넣어주는것이 아닌 외부에서 넣어주도록 설정함.

    // command +shift + t -> test 자동완성


    public Long join(Member member){
//        Optional<Member> result = memberRepository.findByName(member.getName()); //멤버에 이름을 찾기.
//        result.ifPresent(m-> {
//            throw new IllegalStateException("이미 존재하는 회원입니다."); //만약 있을경우에 이미 존재하는 회원이다를 나오게 설정 위의 Optional이 있기에 가능
//        }); 더줄이기 밑에  -> comman+t -> extract method or command+option+m
        validateDuplicateMember(member); //회원 중복 확인해줌
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
//    private void vaildateDuplicateMember(Member member) {
//        memberRepository.findByName(member.getName())
//                    .ifPresent(m -> {
//          throw new IllegalStateException("이미존재하는 회원입니다.");
//        });
    public List<Member> findMember(){

        return memberRepository.findAll();
    }
    //전체 회원 조회
    public Optional<Member> findbyId(Long memberId){
        return memberRepository.findById(memberId);
    }
}
