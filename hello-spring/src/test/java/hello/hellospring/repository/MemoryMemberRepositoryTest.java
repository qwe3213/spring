package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository =new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
        //test가 시작되고 끝날때마다 지워져서 순서에 상관없이 오류가 나지않게 작동이 된다. 테스트를 할때 서로 의존서이 없어야 함
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member); //member 저장하기

        Member result = repository.findById(member.getId()).get();
        //member id 찾기  optional이라 뒤에 get을 사용해야함.
        System.out.println("result = " + (result == member));
       // Assertions.assertEquals(member, null); //기대한건 result인데 null이나와서 오류뜸
        assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName(){
        Member member1 =new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
       Member result= repository.findByName("spring2").get();
        assertThat(result).isEqualTo(member2);
        //있는지 없는지 확인하기
    }
    @Test
    public void findAll(){
        Member member1 =new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
        // 개수 맞는지 확이하기
    }
}
