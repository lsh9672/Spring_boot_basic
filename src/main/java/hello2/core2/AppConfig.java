package hello2.core2;

import hello2.core2.discount.DiscountPolicy;
import hello2.core2.discount.FixDiscountPolicy;
import hello2.core2.discount.RateDiscountPolicy;
import hello2.core2.member.MemberService;
import hello2.core2.member.MemberServiceImpl;
import hello2.core2.member.MemoryMemberRepository;
import hello2.core2.order.OrderService;
import hello2.core2.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//생성자 주입 - 생성자를 통해서 객체가 들어감
//역할(추상)과 구현이 한눈에 보여야됨
@Configuration //설정정보를 적는다는 의미
public class AppConfig {

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    //레파지토리 역할이 보임
    @Bean
    public MemoryMemberRepository memberRepository() {

        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
//        return null;
    }
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
