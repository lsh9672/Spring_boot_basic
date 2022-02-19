package hello2.core2.autowired;

import hello2.core2.AutoAppConfig;
import hello2.core2.discount.DiscountPolicy;
import hello2.core2.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    public void AutowiredOption() throws Exception{
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{

        //Member는 스프링이 관리하는 빈이 아님 - 의존관계가 없으면 메서드 자체가 호출이 안됨
        @Autowired(required=false)
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }
        //호출이 되는데 객체에 null이 들어감
        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }

        //자바8 Optional 공부 필요
        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }
    }

    @Test
    public void tempTest() throws Exception{
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        DiscountPolicy discountPolicy = ac.getBean(DiscountPolicy.class);
    }
}
