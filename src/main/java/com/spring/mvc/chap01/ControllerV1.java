package com.spring.mvc.chap01;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 어떤 요청들을 처리할지 공통 URL을 설계
@RequestMapping("/spring/*") // spring으로 시작하는것은 내가 받을거야!
// 이 클래스의 객체를 스프링이 관리하도록 빈을 등록
@Controller // @Component와 같은 개념
public class ControllerV1 {

    // 세부요청들은 메서드를 통해 처리
    @RequestMapping("/hello") // http://localhost:8181/spring/hello
    public String hello() {
        System.out.println("\n====== 헬로 요청이 들어옴! ======\n");
        // 어떤 JSP를 열어줄지 경로를 적습니다.
        return "hello.jsp";
    }

}
