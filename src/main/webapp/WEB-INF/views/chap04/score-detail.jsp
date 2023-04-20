<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        /* .box {
            display: flex;
            align-items: center;
            justify-content: center;
            border: 2px solid yellow;
        } */
    </style>
</head>

<body>
    <form action="/score/detail" method="GET">
        <div class="box">
            
            <h1>${a.name}님 성적 정보</h1>
            <ul>
                <li># 국어: ${a.kor}점</li>
                <li># 영어: ${a.eng}점</li>
                <li># 수학: ${a.math}점</li>
                <li># 총점: ${a.total}점</li>
                <li># 평균: ${a.average}점</li>
                <li># 학점: ${a.grade}</li>
            </ul>
        
            <a class="del-btn" href="/score/list">목록</a>
        </div>
    </form>
</body>
<script>

</script>
</html>