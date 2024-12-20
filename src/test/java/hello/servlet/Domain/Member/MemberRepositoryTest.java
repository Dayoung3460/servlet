package hello.servlet.Domain.Member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// public 없어도 괜춘
class MemberRepositoryTest {
  MemberRepository memberRepository = MemberRepository.getInstance();

  // test 끝날 때마다 초기화할려고.
  @AfterEach
  void afterEach() {
    memberRepository.clearStore();
  }

  @Test
  void save() {
    // given
    Member member = new Member("hello", 20);

    // when
    Member savedMember = memberRepository.save(member);

    // then
    Member findMember = memberRepository.findById(savedMember.getId());
    assertThat(findMember).isEqualTo(savedMember);
  }

  @Test
  void findAll() {
    // given
    Member member1 = new Member("member1", 20);
    Member member2 = new Member("member2", 30);

    memberRepository.save(member1);
    memberRepository.save(member2);
    // when
    List<Member> all = memberRepository.findAll();

    // when
    assertThat(all.size()).isEqualTo(2);
    assertThat(all).contains(member1, member2);
  }
}