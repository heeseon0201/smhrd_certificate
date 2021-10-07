<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main</title>
    <style>
  
    </style>
    
    <link rel="stylesheet" href="1cha.css">
</head>
<body>
    <header>
        <h3></h3>
        <nav>
          <span><a href="#">회원가입</a></span>
          <span><a href="login.jsp">로그인</a></span>
        </nav>
    </header>
      
    <main>
        <div class="title">
            <h1>STUDYNET</h1>
        </div>
        <!--인강정보를 나타내는 테이블-->
        <!-- table 두개를 서로 나란히 위치시키기 위해 
            div태그(style="width:50%;float:left;")를 만들고(왼쪽 div는 float left, 오른쪽-right)
            그 안에 table태그를 넣음
        -->
        <!--왼쪽 테이블을 옆으로 살짝 옮기고 싶어서 margin--->
        <div style="width:50%;float:left;">
            <table>
                <tr>
                    <td>
                        <!--버튼으로 할 것인가 아니면 a태그로 할 것인가-->
                        <a href="#">
                            인강정보1
                        </a>
                    </td>
                    <td>
                        인강정보2
                    </td>
                </tr>
                <tr>
                    <td>
                        인강정보3
                    </td>
                    <td>
                        인강정보4
                    </td>
                </tr>
            </table>
        </div>
        <div style="width:50%;float:right;">
            <table>
                <tr>
                    <td>
                        스터디정보1
                    </td>
                    <td>
                        스터디정보2
                    </td>
                </tr>
                <tr>
                    <td>
                        스터디정보3
                    </td>
                    <td>
                        스터디정보4
                    </td>
                </tr>
            </table>
        </div>
    </main>   
</body>
</html>