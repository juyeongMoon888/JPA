package com.ohgiraffers.module01servlet.chap01;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @WebServlet
 * 해당 클래스가 서블릿 클래스임을 명시하는 어노테이션으로 동적이고
 * http 요청을 처리하는 웹 컴포턴트를 만들 수 있게 해쭌다.
 *
 * value 속성은 서블릿이 매핑될 때 url 패턴을 지정하며, 여기서는 "/life-cycle" url로 들어오는 요청을 처리한다.
 * localOnSartUp 속성은 웹 애플리케이션이 시잗될 때 서블릿을 미리 로드할지 여부르르 설정한다.
 * 값이 1이면 에플리케이션 시작 시 서블릿이 로ㄷ되어 첫 요청에 ㅔ대단 ㅇ응답 시간을 줄일 ㅜㅅ 이싿.
 */
@WebServlet(value = "/life-cycle", loadOnStartup = 1)
public class ServletLifeCycle extends HttpServlet {

    /**
     * init메서드: 서블릿의 초기화 단계
     * - 서블릿이 처음 생성될 때 한 번 호출된다.
     * - 주로 서블릿이 사용할 자원(예: 데이터베이스 연결, 설정 파일 로드 등)을 준비하는데 사용
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("1. servlet이 생성되었습ㄴ니다.");
        super.init(config);
    }

    /**
     * service 메서드: 요청 처리 단계
     * 클라이언트로부터 요청이 올 때마다 호출됨
     * - 요청의 종류(Get, Post 등)에 따라 적절한 doGet, doPost 메서드를 라우팅하는 역할
     * - 서블릿의 핵심 동작이 이 단계에서 이루어진다.
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        /**
         * 두 클래스의 타입은 모두 인터페이스이다.
         * 이는 다형성을 지워하기 위한 설계로, 구체적인 구현체에 의존하지 않고
         * 다양한 서블릿 환경이나 요구사항에 따라 구현체가 변경되더라도
         * 동일한 인터페이스를 통해 일관되게 요청과 응답을 처리할 수 있도록 유연성을 제공한다.
         * 예를 들어, http 요청을 처리하는 구현체(HttpServletRequestImpl)에서
         * 다른 프로토콜(예: WebSocket)을 지원하는 구현체로 변경되더라도
         * 이 메서드는 인터페이스에 의존하기 때문에 코드 수정 없이 동작이 가능하다.
         *
         * ServletRequest:
         * 클라이언트로부터 서버로 전송된 요청(request)를 표현하며,
         * 요청 데이터(예: 파라미터, 헤더, 입력 스트림 등)을 캡슐화한다.
         * 이를 통해 서블릿은 클라이언트의 의도를 파악하고 필요한 데이터를 추출할 수 있다.
         *
         * ServletResponse:
         * 서버가 클라이언트에게 보낼 응답(response)를 나타내며,
         * 응답 데이터(예: 출력 스트림, 상태 코드, 헤더 등)을 설정하는 역할을 한다.
         * 이를 통해 서블릿은 처리 결과를 클라이언트에게 전달할 수 있다.
         *
         *
         */
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String method = request.getMethod(); //get, post, fetch, delete

        if (method.equals("GET")) {
            doGet(request, response);
        } else if (method.equals("POST")) {
            doPost(request, response);
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<h1>지원하지 않는 http 메서드입니다. " + method + "</h1>");
        }
        //super.service(req, res); 내 요청을 다시 가공하기 때문에 지워줘야함.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //resp.sendRedirect(req.getContextPath() + "/chap01");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title> post 응답 </title></head>");
        out.println("<body>");
        out.println("<h1>POST 요청을 처리했습니다.</h1>");
        out.println("<p>이 내용은 서블릿에서 직접 생성된 응답입니다.</p>");
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * 서블릿 종료 단계
     * - 서블릿이 메모리에서 제거될 때 호출됨(예: 서버 종료 또는 서블릿 갱신)
     * - 자원을 정리하거나 마무리 작업
     */

    @Override
    public void destroy() {
        super.destroy();
    }
}
