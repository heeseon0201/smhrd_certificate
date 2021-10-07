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
    /*타이틀의 폰트 변동*/
    @import url('https://fonts.googleapis.com/css2?family=Sansita+Swashed:wght@800&display=swap');
    header {  
    height: 30px;
    padding: 1rem;
    color: white;
    font-weight: bold;
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin: 0;
    border-bottom: 1px solid black;
}
h1, p {
  margin: 0;
}
main {
  padding: 1rem;
  height: 100%;  
}
body {
  background: #EEE;
}
a { 
text-decoration:none;
color: black; 
} 
body, html {
  height: 200%;
}
.green_window {
	display: inline-block;
	width: 366px;
	border: 3px solid rgb(2, 0, 128);
    position: center;
}
.input_text {
	width: calc( 100% - 14px );
	margin: 6px 7px;
	border: 0;
	font-weight: bold;
	font-size: 16px;
	outline: none;
}
.sch_smit {
	width: 30px; height: 40px;
	margin: 0; border: 0;
	vertical-align: top;
	background: rgb(2, 0, 128);
	color: white;
	font-weight: bold;
	border-radius: 1px;
	cursor: pointer;
}
.sch_smit:hover {
	background: rgb(2, 0, 128);
}
*{
    box-sizing: border-box;
}
.parent{
    text-align: center;
}
.menu{
    float:left;
    width: 43%;
    height: 20%;
    background-color: blue;
    flex-direction : row ;
    flex-wrap : wrap ;
}
h1{
    font-family: Sansita Swashed;
    font-size: 100px;
    /*폰트 그라데이션->이거 하고 싶음*/
    font-color: linear-gradient(to left, rgb(255, 77, 46), rgb(255, 155, 47));
}
.title{
    width: 100%;
    height: 400px; 
    line-height: 170px;
    /*study를 중앙으로 보내기위한 뻘짓*/
    vertical-align: middle;
    text-align: center;
    display:table-col;
}
table{
    width: 90%;
    height: 400px;
    border: 1px solid black;
    max-width:100%;
}
    </style>
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