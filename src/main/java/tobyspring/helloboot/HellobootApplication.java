package tobyspring.helloboot;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.http.HttpStatus;

import java.io.IOException;

//@SpringBootApplication
public class HellobootApplication {
	public static void main(String[] args) {
//		SpringApplication.run(HellobootApplication.class, args);
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		WebServer webServer = factory.getWebServer(new ServletContextInitializer() { // 서블릿 등록 익명 클래스
			@Override
			public void onStartup(ServletContext servletContext) throws ServletException {
				servletContext.addServlet("hello", new HttpServlet() { // 서블릿 이름, 서블릿 객체를 인자로 전달
					@Override
					protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
						// 요청 제작
						String name = req.getParameter("name");

						// 응답 제작
						// 상태 코드
						resp.setStatus(HttpStatus.OK.value());
						// 헤더(컨텐츠 타입 헤더)
						resp.setHeader("Content-Type", "text/plain");
						// 바디
						resp.getWriter().println("Hello " + name);
					}
				}).addMapping("/Hello"); // 매핑 패스 지정
			}
		});
		webServer.start();
	}

}
