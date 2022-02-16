package hello2.core2.beanfind;

import hello2.core2.AppConfig;
import hello2.core2.member.MemberService;
import hello2.core2.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    public void findBeanByName() throws Exception{
        //give
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //when
        //then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    public void findBeanByType() throws Exception{
        //give
        MemberService memberService = ac.getBean(MemberService.class);
        //when
        //then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    public void findBeanByName2() throws Exception{
        //give
        MemberService memberService = ac.getBean("memberService",MemberServiceImpl.class);
        //when
        //then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    public void findBeanByNameX() throws Exception{

        //give
//        MemberService xxxxx = ac.getBean("xxxxx", MemberService.class);
        //이 예외가 터져야 성공
        assertThrows(NoSuchBeanDefinitionException.class,()->ac.getBean("xxxxx",MemberService.class));

        //when
        //then
    }
}
