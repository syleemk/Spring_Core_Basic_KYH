package hello.core.member;

public class MemberServiceImpl implements MemberService {

    //가입하고 회원조회하려면 respository 필요함
    //실제 구현체 선택해줘야함 -> 단일 책임 원칙 위배 -> AppConfig가 구현체 선택하는 책임을 갖는다
    private final MemberRepository memberRepository;// = new MemoryMemberRepository();

    //MemberRepository에 무엇이 들어갈지를 생성자를 통해서 결정할 것
    //더이상 구현체에대한 의존이 없음, 오로지 인터페이스(추상화)에만 의존 -> DIP 잘 지켜짐
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        // 다형성에 의해서 인터페이스의 메소드가 아닌
        // 구현체에의해 오버라이딩 된 메소드가 호출된다
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
    
    //Test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
