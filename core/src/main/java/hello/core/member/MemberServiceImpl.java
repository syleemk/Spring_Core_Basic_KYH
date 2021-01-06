package hello.core.member;

public class MemberServiceImpl implements MemberService {

    //가입하고 회원조회하려면 respository 필요함
    //실제 구현체 선택해줘야함
    private final MemberRepository memberRepository = new MemoryMemberRepository();

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
}
