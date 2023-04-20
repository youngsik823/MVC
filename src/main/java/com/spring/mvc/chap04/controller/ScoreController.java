package com.spring.mvc.chap04.controller;

import com.spring.mvc.chap04.dto.ScoreRequestDTO;
import com.spring.mvc.chap04.entity.Score;
import com.spring.mvc.chap04.repository.ScoreRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*
    # 요청 URL
    1. 학생 성적정보 등록화면을 보여주고 및 성적정보 목록조회 처리
    - /score/list : GET

    2. 성적 정보 등록 처리 요청
    - /score/register : POST

    3. 성적정보 삭제 요청
    - /score/remove : POST

    4. 성적정보 상세 조회 요청
    - /score/detail : GET
 */
@Controller
@RequestMapping("/score")
//@AllArgsConstructor : 모든 필드를 초기화하는 생성자
@RequiredArgsConstructor // : final 필드만 초기화하는 생성자
//@Component를 하고 @AllArgsConstructor를 하면 자동주입

public class ScoreController {
    // 저장소에 의존해야 데이터를 받아서 클라이언트에게 응답할 수 있음
    private final ScoreRepository repository;

    // 만약에 클래스의 생성자가 단 1개라면
    // 자동으로 @Autowired를 써줌

//    @Autowired // 자동으로 결합해줘 스프링이 저장소 데이터를 주입 해준다.
//    public ScoreController(ScoreRepository repository) {
//        this.repository = repository;
//    }
    // 1. 성적등록화면 띄우기 + 정보목록조회
    @GetMapping("/list")
    public String list(Model model, String sort) {
        System.out.println("/score/list : GET!");
        System.out.println("장랼 요구사항: " + sort);

        List<Score> scoreList = repository.findAll(sort);
        model.addAttribute("sList", scoreList);

        return "chap04/score-list";
    }

    // 2. 성적 정보 등록 처리 요청
    @PostMapping("/register")
    public String register(ScoreRequestDTO dto) {
        // DTO는 스프링이 @NoArgsConstructor을 만든다음에 setter을 쓴다.


        // 입력데이터(쿼리스트링) 읽기
        
        System.out.println("/score/register : POST! - " + dto);

        // dto(ScoreDTO)를 entity(Score)로 변환해야 함.
        Score score = new Score(dto);

        // save 명령
        repository.save(score);
        /*
            등록요청에서 JSP 뷰 포워딩을 하면
            갱신된 목록을 다시한번 저장소에서 불러와
            모델에 담는 추가적인 코드가 필요하지만

            리다이렉트를 통해서 위에서 만든 /score/list : GET
            을 자동으로 다시 보낼 수 있다면 번거러운 코드가
            줄어들 수 있겠다.
         */
        // 리다이렉트로 다시 새로운 요청을 자동으로 들어가게?
        return "redirect:/score/list"; // jsp경로가 아니라 요청 URL을 써야한다
                                        // 그러면 두번째 요청이 자동으로 들어간다.
    }
    // 3. 성적정보 삭제 요청
    @GetMapping("/remove")  // @RequestParam 생략가능
    public String remove(@RequestParam int stuNum) {
        System.out.println("/score/remove : GET!");

        repository.deleteByStuNum(stuNum);
        return "redirect:/score/list";
    }
    // 4. 성적정보 상세 조회 요청
    @GetMapping("/detail")
    public String detail(int stuNum, Model model) {
        System.out.println("/score/detail : GET!");

        Score info = repository.findByStuNum(stuNum);
        model.addAttribute("a", info);
        return "chap04/score-detail";
    }

}