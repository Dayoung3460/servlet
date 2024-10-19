package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {
  // json으로 요청 받아도 그냥 문자열임
  // 스프링 부트 프로젝트엔 기본적으로 json을 객체로 파싱해주는 jackson이라는 라이브러리가 기본으로 깔려있음
  // ObjectMapper: jackson에서 갖다쓰는 객체
  private ObjectMapper objectMapper = new ObjectMapper();

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ServletInputStream inputStream = request.getInputStream();
    String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

    System.out.println("messageBody = " + messageBody);

    // json 형식의 문자열을 객체로 변환
    HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);

    System.out.println("helloData.getUsername() = " + helloData.getUsername());
    System.out.println("helloData.getAge() = " + helloData.getAge());

    response.getWriter().write("ok");
  }
}
