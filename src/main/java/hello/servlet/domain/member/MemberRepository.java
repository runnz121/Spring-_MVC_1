package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); //static 사용 -> MemberRepository가 만아도 딱 하나만 생성됨
    private static long sequence = 0L; //static 사용

    private static final MemberRepository instance = new MemberRepository(); //싱글톤으로 생성
    //싱글톤 : 클래스의 인스턴스가 딱 1개만 생성되는 것을 보장하는 디자인 패턴
   public static MemberRepository getInstance() { //무조건 getInstance로 조회를 해야한다 -> 이 메서드를 호출하면 항상 같은 인스턴스 반환
        return instance;
    }


    private MemberRepository() {
    }
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
