package hello2.core2.member;

import hello2.core2.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;

public class MemberServiceTest {
//    MemberService memberService =new MemberServiceImpl();

    MemberService memberService;

    //테스트 전에 실행됨 - 각각의 테스트당 한번씩 실행
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    public void Join() throws Exception{
        //give
        Member member = new Member(1L,"memberA",Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
