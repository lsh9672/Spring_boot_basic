package hello2.core2.order;

import hello2.core2.discount.FixDiscountPolicy;
import hello2.core2.member.Grade;
import hello2.core2.member.Member;
import hello2.core2.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {
    //이처럼 생성자 주입을 사용하면 필요한 의존관계를 넣지 않으면 컴파일시에 에러가 나서 빠르게 찾을수 있음
    @Test
    public void createOrder() throws Exception{
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L,"name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository,new FixDiscountPolicy());
        Order itemA = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(itemA.getDiscountPrice()).isEqualTo(1000);
    }
}
