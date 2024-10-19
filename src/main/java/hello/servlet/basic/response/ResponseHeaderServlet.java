package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // http 응답
    // [status-line]
    response.setStatus(HttpServletResponse.SC_OK);

    // [response-headers]
//    response.setHeader("Content-Type", "text/plain;charset=utf-8");
//    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
//    response.setHeader("Pragma", "no-cache");
//    response.setHeader("my-header", "hello");

    content(response);
    cookie(response);
    redirect(response);

    PrintWriter writer = response.getWriter();
    writer.println("안녕");
  }

  private void content(HttpServletResponse response) {
    //Content-Type: text/plain;charset=utf-8
    //Content-Length: 2
//        response.setHeader("Content-Type", "text/plain;charset=utf-8");
    response.setContentType("text/plain");
    response.setCharacterEncoding("utf-8");
//        response.setContentLength(2); //(생략시 자동 생성)
  }

  private void cookie(HttpServletResponse response) {
    //Set-Cookie: myCookie=good; Max-Age=600;
    //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
    Cookie cookie = new Cookie("myCookie", "good");
    cookie.setMaxAge(600); //600초 gmt기준
    response.addCookie(cookie);

    // 서버에서 쿠키 세팅하고 응답으로 쿠키 보내주면 다음 요청 헤더에 Cookie: myCookie=good 있음
    // request.getCookies() 로 받아올 수 있음
  }

  private void redirect(HttpServletResponse response) throws IOException {
    //Status Code 302
    //Location: /basic/hello-form.html

//        response.setStatus(HttpServletResponse.SC_FOUND); //302
//        response.setHeader("Location", "/basic/hello-form.html");

    // 응답 헤더에
    // location: http://localhost:8080/basic/hello-form.html
    // 라고 브라우저에 알려줌.
    // sendRedirect 하면 알아서 자동으로 302코드 보내주네.
    // 리다이렉트되면 스택이 쌓이지 않음. 그냥 replace됨
    response.sendRedirect("/basic/hello-form.html");
  }
}
