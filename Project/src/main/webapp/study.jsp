<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="table.css">
</head>
<body>
    <h1><b>Study</b></h1>
    <table class="certificate" style="margin-top: 10px; margin-bottom: 30px;">
        <tr>
            <%for(int i =0, k = 0 ; i<4;i++){ %>
            
            	<td>
            		<%for(int j = 0; j<3; j++){ %>
            			<input type="radio" value="" name="certificate">자격증<%=k+1 %><br>
            			<%k++; %>
            		<%} %>
            	</td>
            <%} %>
           
        </tr>
    </table>
    <div>
        <table>
            <tr>
                <th>순번</th>
                <th>스터디명</th>
                <th>시작일자</th>
                <th>종료일자</th>
                <th>스터디 과목</th>
                <th>장소</th>
                <th>요일(월화수목금)</th>
                <th>시간(공부시간 시간단위)</th>
            </tr>
        <%for(int i = 0; i<12;i++){ %><!-- 반복문을 이용하여 테이블을 정의 하였습니다. 나중에 데이터베이스에서 컬럼명을 변수로 가져와서 붙여넣을 것. -->
            <tr>
                <td>순번<%=i+1 %></td>
                <td>스터디명</td>
                <td>시작일자</td>
                <td>종료일자</td>
                <td>스터디 과목</td>
                <td>장소</td>
                <td>요일(월화수목금)</td>
                <td>시간(공부시간 시간단위)</td>
            </tr>
            <%} %>
           
        </table>
    </div>
</body>
</html>