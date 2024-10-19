package hello.servlet.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // WEB-INF 폴더 밑에 있는 애들은 직접적으로 호출될 수 없음.
        // 컨트롤러(내부) 거쳐서 뷰를 보여주고 싶기 때문에
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        // 서버 내부에서 다시 해당 경로를 호출함.
        // 클라이언트로 넘어갔다가 리다이텍트가 되는게 아님
        // url이 /WEB-INF/views/new-form.jsp 이렇게 변하지 않고
        // /servlet-mvc/members/new-form 그대로임
        dispatcher.forward(request, response);
    }
}
