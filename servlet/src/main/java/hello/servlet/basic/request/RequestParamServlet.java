package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        전체_파라미터_조회(request);
        단일_파라미터_조회(request);
        이름이같은_복수_파라미터_조희(request);

        response.getWriter().write("ok");
    }

    private void 전체_파라미터_조회(HttpServletRequest request) {
        System.out.println("[전체 파라미터 조회] -- START");

        request.getParameterNames().asIterator()
                .forEachRemaining(param ->
                        System.out.println("param : " + param + " - " + request.getParameter(param))
                );

        System.out.println("[전체 파라미터 조회] -- END");
        System.out.println();
    }

    private void 단일_파라미터_조회(HttpServletRequest request) {
        System.out.println("[단일 파라미터 조회] -- START");

        String username = request.getParameter("username");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String job = request.getParameter("job");
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("sex = " + sex);
        System.out.println("job = " + job);

        System.out.println("[단일 파라미터 조회] -- END");
        System.out.println();
    }

    private void 이름이같은_복수_파라미터_조희(HttpServletRequest request) {
        System.out.println("[이름이 같은 복수 파라미터 조회] -- START");
        String[] usernames = request.getParameterValues("username");
        for (String username : usernames) {
            System.out.println("username = " + username);
        }
        System.out.println("[이름이 같은 복수 파라미터 조회] -- END");
        System.out.println();
    }
}
