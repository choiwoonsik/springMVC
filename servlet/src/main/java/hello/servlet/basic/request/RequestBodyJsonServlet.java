package hello.servlet.basic.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSON형식_출력(request);
        response.getWriter().write("ok");
    }

    private void JSON형식_출력(HttpServletRequest request) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("--- JSON 단순 문자열 출력 START");
        System.out.println("messageBody = " + messageBody);
        System.out.println("--- JSON 단순 문자열 출력 END\n");

        System.out.println("--- JSON 객체 변환 후 출력 START");
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        System.out.println("helloData.getUsername() = " + helloData.getUsername());
        System.out.println("helloData.getAge() = " + helloData.getAge());
        System.out.println("helloData.getSex() = " + helloData.getSex());
        System.out.println("helloData.getJob() = " + helloData.getJob());
        System.out.println("--- JSON 객체 변환 후 출력 END\n");
    }
}
