package com.spring.mvc.chap02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


// 응답 데이터 처리
@RequestMapping("/model/*")
@Controller
public class ControllerV2 {

    // /model/hobbies : GET
    // hobbies.jsp파일로 이름정보와
    // 취미목록 정보를 보내주고 싶을 때

    // == 1. Model객체를 활용
    @GetMapping("/hobbies")
    public String hobbies(Model model) {

        String name = "멍멍이";
        List<String> hobbies = List.of("산책", "밥먹기", "낮잠자기");
        // jsp로 보낼 데이터를 모델에 담는다.
        model.addAttribute("n", name);
        model.addAttribute("hList", hobbies);
//        /WEB-INF/views/chap2/hobbies.jsp
        return "chap2/hobbies";
    }
    
    // == 2. ModelAndView 사용하기
    // /model/hobbies2 : GET
    // hobbies.jsp를 포워딩

    // ModelAndView는 리턴 타입을 ModelAndView로 설정
    public ModelAndView hobbies2() {


    }

}
