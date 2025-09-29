package tobyspring.helloboot;

//import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
// 클래스 import대신, static import가져오기 -> 여러 번의 동일한 static method 호출

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;



public class HelloApiTest {
    @Test
    void helloApi(){
        TestRestTemplate rest = new TestRestTemplate();
        ResponseEntity<String> res =
                rest.getForEntity(
                        "http://localhost:8080/myapp/hello?name={name}",
                        String.class,
                        "spring");

        // 응답 검증
        // status code - 200
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);

        // header(content-type) - text/plain
//        Assertions.assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).isEqualTo(MediaType.TEXT_PLAIN_VALUE);
        // 헤더 전체 내용 -> 실패
        assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        // text/plain으로 시작하기만 하면 ok

        //body - 우리가 설정한 내용대로 잘 왔는지
        assertThat(res.getBody()).isEqualTo("Hello spring");
    }
}