package tobyspring.helloboot;

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.METHOD)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Test // 이게 없으면 Test의 메타 애너테이션인지 모름 -> 없어도 테스트 에러는 안뜨지만, 해당 애너테이션 테스트 메서드는 작동 안됨
@interface UnitTest{} // 기능확장은 없음, 단순 단위 테스트임을 나타내기 위해 만든거