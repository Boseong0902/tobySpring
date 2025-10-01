package tobyspring.config;

import org.springframework.context.annotation.Import;
import tobyspring.config.autoConfig.DispatcherServletConfig;
import tobyspring.config.autoConfig.TomcatWebserverConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({DispatcherServletConfig.class, TomcatWebserverConfig.class})
public @interface EnableMyAutoConfiguration {}