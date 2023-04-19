package com.spring.mvc.chap01;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 어떤 요청들을 처리할지 공통 URL을 설계
@RequestMapping("/spring/*") // spring으로 시작하는것은 내가 받을거야!
// 이 클래스의 객체를 스프링이 관리하도록 빈을 등록
@Controller // @Component와 같은 개념
public class ControllerV1 {


}
