package hello2.core2.order;

import hello2.core2.discount.DiscountPolicy;
import hello2.core2.discount.FixDiscountPolicy;
import hello2.core2.discount.RateDiscountPolicy;
import hello2.core2.member.Member;
import hello2.core2.member.MemberRepository;
import hello2.core2.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


//@RequiredArgsConstructor
@Component
public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    //이는 추상에도 의존하고 구현에도 의존한다, 즉 DIP원칙을 위반하고, 이를 수정하려고 하면 OCP 원칙도 위반하게 된다.
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    //인터페이스에만 의존함 - DIP원칙 지킴
    //final을 쓰면 반드시 값을 넣어야 되기 때문에 생성자에서 누락했을때 빠르게 파악가
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    @Autowired private MemberRepository memberRepository;
//    @Autowired private DiscountPolicy discountPolicy;
//
//    private MemberRepository memberRepository;
//    private DiscountPolicy discountPolicy;

//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("OrderServiceImpl.setMemberRepository3");
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("OrderServiceImpl.setDiscountPolicy2");
//        this.discountPolicy = discountPolicy;
//    }

    //롬복이 이거 그대로 만들어
    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
    //테스트 용도

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
