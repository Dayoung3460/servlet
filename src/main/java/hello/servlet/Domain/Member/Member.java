package hello.servlet.Domain.Member;

import lombok.Data;

@Data
public class Member {
  private Long id;
  private String username;
  private int age;

  public Member() {
  }

  public Member(String username, int age) {
    this.username = username;
    this.age = age;
  }
}
