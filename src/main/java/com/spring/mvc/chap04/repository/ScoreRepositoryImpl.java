package com.spring.mvc.chap04.repository;

import com.spring.mvc.chap04.entity.Grade;
import com.spring.mvc.chap04.entity.Score;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.spring.mvc.chap04.entity.Grade.A;

public class ScoreRepositoryImpl implements ScoreRepository {
    
    // key: 학번, value: 성적정보
    private static final Map<Integer, Score> scoreMap;   
    // 학번에 사용할 일련번호
    private static int sequence;
    
    static {
        scoreMap = new HashMap<>();
        Score stu1 = new Score("뽀로로", 100, 50, 70, ++sequence, 0, 0, A);
        Score stu2 = new Score("춘식이", 33, 56, 12, ++sequence, 0, 0, A);
        Score stu3 = new Score("대길이", 88, 12, 0, ++sequence, 0, 0, A);
    }
    @Override
    public List<Score> findAll() {
        return null;
    }

    @Override
    public boolean save(Score score) {
        return false;
    }

    @Override
    public boolean deleteByStuNum(int stuNum) {
        return false;
    }

    @Override
    public Score findByStuNum(int stuNum) {
        return null;
    }
}