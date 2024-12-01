package hello.servlet.web.springmvc.v1;

import hello.servlet.Domain.Member.Member;
import hello.servlet.Domain.Member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SpringMemberListControllerV1 {
  private MemberRepository memberRepository = MemberRepository.getInstance();


  @RequestMapping("/springmvc/v1/members")
  public ModelAndView process() {
    List<Member> members = memberRepository.findAll();
    ModelAndView mv = new ModelAndView("members");
    mv.addObject("members", members);
    mv.getModel().put("members", members);

    return mv;
  }
}
