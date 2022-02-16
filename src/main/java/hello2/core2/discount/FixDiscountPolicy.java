package hello2.core2.discount;

import hello2.core2.member.Grade;
import hello2.core2.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    /*정률할인*/
    private int discountFixAmount = 1000; // 천원 할인 해줌

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }

    }
}
