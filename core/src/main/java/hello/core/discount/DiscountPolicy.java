package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액 : 얼마 할인 됐는지 리턴
     */
    int discount(Member member, int price);
}
