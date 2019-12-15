package com.msuk.samplePractice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /* Json을 반환하는 컨트롤러 / 이전 @ResponseBody를 메소드마다 선언했던것에 대해 한번에 사용할수 있도록 개선 */
public class HelloController {

    @GetMapping("/hello") /* @RequestMapping(method = RequestMethod.GET) 동일 */
    public String hello() {
        return "hello";
    }
}
