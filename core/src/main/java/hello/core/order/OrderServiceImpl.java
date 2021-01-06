package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

/**
 * 설계 잘되어있음
 * OrderService 입장에서는 할인에 대해서 잘 모름
 * 그냥 discountPolicy에게 맡김 -> "단일책임원칙" 잘 지켰다 볼 수 있음
 * 할인에 대한 변경일어나면, 할인부분만 고치면됨. 주문쪽까지 고칠필요 없음!!
 */
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;// = new MemoryMemberRepository();
    /**
     * 문제점 : OrderServiceImple은 주문 서비스에 관련된 책임만 가져야하는데
     * 구체적인 할인 정책 정하는 책임까지 맡고있음 - 다양한 책임을 가짐 (단일책임원칙 위배)
     * 마치 공연에서 배우가 직접 상대배역을 맡을 배우 초빙하는 것과 같은꼴
     */
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy;// = new RateDiscountPolicy();

    // 생성자를 통한 의존성 주입 -> 더이상 구체 클래스에 의존하지 않음
    // 오로지 추상(인터페이스)에만 의존 -> DIP 준수
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
