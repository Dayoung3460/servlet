package hello.servlet.Domain.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 동시성 문제는 고려하지 않음
// 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
// ConcurrentHashMap을 사용하더라도 Long 타입을 저장하는 경우,
// **AtomicLong**을 사용하는 것이 좋습니다.
// 그 이유는 ConcurrentHashMap이 자체적으로 맵의 구조적 동기화는 제공하지만,
// 맵에 저장된 **개별 값(Long 타입)**의 변경이 원자적으로 보장되지는 않기 때문입니다.
public class MemberRepository {
  private static Map<Long, Member> store = new HashMap<>();
  private static long sequence = 0L;

  private static final MemberRepository instance = new MemberRepository();

  public static MemberRepository getInstance() {
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
