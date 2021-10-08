<%@page import="com.model.memberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main</title>
    <link rel="stylesheet" href="main.css">
</head>
<body>
    <div style="text-align : left;" class="title">
    <header>
        <h3>Studynet</h3>
        <nav>
          <span><a href="#">회원가입</a></span>
          <span><a href="#">로그인</a></span>
        </nav>
    </header>
    <main>
        <p>인터넷 강의 사이트입니다.<br>안녕하세요. 지금 인터넷 강의를 뭐 긁어올지 모르겠네여 하하</p>
        <!--왼쪽 테이블을 옆으로 살짝 옮기고 싶어서 margin--->
        <!--인강정보와 스터디를 보여주는 div-->

    </div>
        <div class="info" style="margin-left: 100px;">
            <div style="width:50%;float:left;">
            <!-- table 두개를 서로 나란히 위치시키기 위해 
            div태그(style="width:50%;float:left;")를 만들고(왼쪽 div는 float left, 오른쪽-right)
            그 안에 table태그를 넣음
            -->
                <table>
                    <tr>
                        <th colspan="2">Lecture
                        </th>
                    </tr>
                    <tr>
                        <td>
                            <!--버튼으로 할 것인가 아니면 a태그로 할 것인가-->
                            <a href="#">
                                인강정보1
                            </a>
                        </td>
                        <td>
                            <a href="#">
                                인강정보2
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="#">
                                인강정보3
                            </a>
                        </td>
                        <td>
                            <a href="#">
                                인강정보4
                            </a>
                        </td>
                    </tr>
                </table>
            </div>
            <div style="width:50%;float:right;">
                <table>
                    <tr>
                        <th colspan="2">GroupStudy
                        </th>
                    </tr>
                    <tr>
                        <td>
                            <a href="#">
                                스터디정보1
                            </a>
                        </td>
                        <td>
                            <a href="#">
                                스터디정보2
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="#">
                                스터디정보3
                            </a>
                        </td>
                        <td>
                            <a href="#">
                                스터디정보4
                            </a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </main>   
</body>
</html>