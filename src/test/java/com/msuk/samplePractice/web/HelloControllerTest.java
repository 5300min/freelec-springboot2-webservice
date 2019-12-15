package com.msuk.samplePractice.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) /* SpringRunner 실행자 사용 / Springboot 테스트와 JUnit 연결자 */
@WebMvcTest /* Spring Web MVC 집중할수 있는 어노테이션 / @Controller 등 사용 가능 */
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc; /* 웹 API 테스트시 사용 / Http의 GET, POST 등에 대한 API 테스트*/

    @Test
    public void hello_return() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) /* /hello 로 http GET 요청 */
                .andExpect(status().isOk()) /* http Header의 status를 검증 / isOk => status가 200인 상태 확인 */
                .andExpect(content().string(hello)); /* 기존 작성된 HelloController에서 hello를 리턴하므로 이 값이 맞는지 검증한다. */
    }

}
