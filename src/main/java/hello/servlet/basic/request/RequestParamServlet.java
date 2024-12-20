package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getParameterNames().asIterator()
            .forEachRemaining(
                    paramName -> System.out.println(paramName + " = " + request.getParameter(paramName)));

    String username = request.getParameter("username");
    String[] usernames = request.getParameterValues("username");
    String age = request.getParameter("age");

    for (String name : usernames) {
      System.out.println("name = " + name);
    }

    response.getWriter().write("ok");
  }
}
