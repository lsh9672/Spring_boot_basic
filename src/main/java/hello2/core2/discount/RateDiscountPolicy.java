package hello2.core2.discount;

import hello2.core2.annotation.MainDiscountPolicy;
import hello2.core2.member.Grade;
import hello2.core2.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


//@Primary
//@Qualifier("mainDiscountPolicy")

//@Primary
@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }
        else{
            return 0;
        }
    }
}
