package com.spring.mvc.chap04.repository;

import com.spring.mvc.chap04.entity.Score;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreRepositoryImplTest {

    ScoreRepository repository = new ScoreRepositoryImpl();

    // 단위 테스트 (Unit test)
    // 테스트 시나리오
    // - 단언(Assertion) 기법
    @Test
    @DisplayName("저장소에서 findAll을 호출하면 그 반환된 리스트에는 성적정보가 3개 있어야 한다.")
    void findAllTest() {
        // given-when-then 패턴
        // given: 테스트를 위해 주어질 데이터 (ex: parameter)
        
        // when: 테스트 실제 상황
        List<Score> scoreList = repository.findAll();

        // then: 테스트 결과 확인
        System.out.println(scoreList.size() == 3);

        // 나는 스코어리스트의 사이즈가 3인 것이 참이라고 단언한다.
        Assertions.assertTrue(scoreList.size() == 3);
    }
}