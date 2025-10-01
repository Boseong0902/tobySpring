package tobyspring.config.autoConfig;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatWebserverConfig {
    @Bean
    public ServletWebServerFactory servletContainer() {
        return new TomcatServletWebServerFactory();
    }
}