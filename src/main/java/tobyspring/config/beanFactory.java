package tobyspring.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class beanFactory{
//    @Bean
//    public ServletWebServerFactory servletContainer() {
//        return new TomcatServletWebServerFactory();
//    }
//
//    @Bean
//    public DispatcherServlet dispatcherServlet() {
//        return new DispatcherServlet();
//    }
    // 위 두 팩토리 메서드들을 autoConfig패키지에서 관리하도록 설정
}

