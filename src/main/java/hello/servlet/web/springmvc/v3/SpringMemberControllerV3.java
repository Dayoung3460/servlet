package hello.servlet.web.springmvc.v3;

import hello.servlet.Domain.Member.Member;
import hello.servlet.Domain.Member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
  private MemberRepository memberRepository = MemberRepository.getInstance();

//  @RequestMapping(value = "/new-form", method = RequestMethod.GET)
  // 위와 같음
  @GetMapping( "/new-form")
  // 어노테이션 기반 컨트롤러는 ModelAndView 또는 String 반환하면 됨
  // 알아서 String이 뷰 이름으로 앎
  public String newForm() {
    return "new-form";
  }

  @PostMapping( "/save")
  //@RequestParam: 요청 파라미터 처리하는 어노테이션
  public String save(@RequestParam("username") String username, @RequestParam("age") int age, Model model) {
    Member member = new Member(username, age);
    memberRepository.save(member);

    model.addAttribute("member", member);
    return "save-result";
  }

  @GetMapping
  public String members(Model model) {
    List<Member> members = memberRepository.findAll();
    model.addAttribute("members", members);

    return "members";
  }
}
