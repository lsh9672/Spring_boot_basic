package hello2.core2.discount;

import hello2.core2.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);

}
