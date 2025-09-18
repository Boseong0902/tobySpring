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
		WebServer webServer = factory.getWebServer(new ServletContextInitializer() {
			@Override
			public void onStartup(ServletContext servletContext) throws ServletException {
				servletContext.addServlet("frontController", new HttpServlet() { // frontController를 만들어보자
					@Override
					protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
						// 각 서블릿의 중복 기능들 정의했다고 치고, 기존 컨트롤러가 했던 매핑을 여기서 구현해야함
						// 요청을 가지고 매핑 - 메서드, 패스, 헤더, 바디 활용
						if(req.getRequestURI().equals("/hello") && req.getMethod().equals("GET")) { // 즉, hello 패스로 get 요청을 보내면 처리하도록 설정
						String name = req.getParameter("name");

						resp.setStatus(HttpStatus.OK.value());
						resp.setHeader("Content-Type", "text/plain");
						resp.getWriter().println("Hello " + name);
						}
						else if(req.getRequestURI().equals("/users")){
							//정의
						}
						else{
							resp.setStatus(HttpStatus.NOT_FOUND.value()); // 요청 못찾음 404
						}
					}
				}).addMapping("/*"); // 모든 요청이 다 frontController를 거치도록
			}
		});
		webServer.start();
	}

}
