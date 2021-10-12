<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Profileport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>스터디 만들기</title>
    <link rel="stylesheet" href="join.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>
    <div id= "total">
        
        <div id = "header" class="Profile_membership" role = "banner">
            <h1>
                <a href = "main.jsp" class = "h_logo">
                    <span> Studynet </span>
                </a>
            </h1>

            <form id = "Profile_form" method="post" action="">
                <div id= "container" role="main">
                    <div id = "content"> 
                        <div class="c_header"> 
                            <h2>스터디 만들기</h2>
                            <p class="contxt">아래의 기재사항을 입력해주세요.</p>
                        </div>

                        <div class="Study_content"> 
                            <div class="row_group">
                                <div class="Study_row">
                                    <table>
                                        <tbody>
                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Study_name">
                                                        <label for="id">스터디명</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_id">
                                                        <input type="text" id="id" name="id" class="int" title="ID" maxlength="20" style="height:20px; width:200px; font-size: 16px;">
                                                    </span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="2">
                                                    <!-- 제대로 입력시 글자색과 내용바뀌게 설계해보자 -->
                                                    <span class="step_url" style="color: red;">스터디명을 정하세요</span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_pwd">
                                                        <label for="pwd">시작일자</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_pwd" id="pwd1Img">
                                                        <input type="date" class="int" maxlength="20" value="" style="height:20px; width:200px; font-size: 16px;">
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td colspan="2">
                                                    <!-- 제대로 입력시 글자색과 내용바뀌게 설계해보자 -->
                                                    <span class="step_url" style="color: red;">시작일자</span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_pwd">
                                                        <label for="pwd">종료일자</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_pwd" id="pwd1Img">
                                                        <input type="date" class="int" maxlength="20" value="" style="height:20px; width:200px; font-size: 16px;">
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td colspan="2">
                                                    <!-- 제대로 입력시 글자색과 내용바뀌게 설계해보자 -->
                                                    <span class="step_url" style="color: red;">종료일자</span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_name">
                                                        <label for="name">스터디과목</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_name">
                                                        <input type="text" class="int" title="NAME" maxlength="20" style="height:20px; width:200px; font-size: 16px;">
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_YMD">
                                                        <label for="YMD">온오프라인 선택</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_mm">
                                                        <input type="radio" name="radio" id="r1" value="0" checked><label for="r1">오프라인</label>
                                                        <input type="radio" name="radio" id="r2" value="1"><label for="r2" >온라인</label>
                                                    </span>
                                                </td>
                                            </tr>
                                            <div id="offplace">
                                                <tr>
                                                    <td width="100px">
                                                        <h3 id="mmm" class = "Join_YMD">
                                                            <label for="YMD">장소</label>
                                                        </h3>
                                                    </td>
                                                    <td>
                                                        <span class="ps_box int_mm">
                                                            <select id="mm" class="sel" aria-label="월" style="height:25px; width:50px; font-size: 16px;">
                                                                <option value="">장소</option>
                                                                <option value="01">서울</option>
                                                                <option value="02">경기</option>
                                                                <option value="03">강원</option>
                                                                <option value="04">충청</option>
                                                                <option value="05">전라</option>
                                                                <option value="06">경상</option>
                                                                <option value="07">제주</option>
                                                            </select>
                                                        </span>
                                                    </td>
                                                </tr>
                                            </div>
                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_sex">
                                                        <label for="sex">요일</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_sex">
                                                        <select id="sex" class="sel" aria-label="성별" style="height:30px; width:200px; font-size: 16px;">
                                                            <option value="">요일</option>
                                                            <option value="월">월</option>
                                                            <option value="화">화</option>
                                                            <option value="수">수</option>
                                                            <option value="목">목</option>
                                                            <option value="금">금</option>
                                                            <option value="토">토</option>
                                                            <option value="일">일</option>
                                                        </select>
                                                    </span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_sex">
                                                        <label for="sex">시간</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_sex">
                                                        <select id="sex" class="sel" aria-label="성별" style="height:30px; width:200px; font-size: 16px;">
                                                            <option value="">요일</option>
                                                            <option value="월">월</option>
                                                            <option value="화">화</option>
                                                            <option value="수">수</option>
                                                            <option value="목">목</option>
                                                            <option value="금">금</option>
                                                            <option value="토">토</option>
                                                            <option value="일">일</option>
                                                        </select>
                                                    </span>
                                                </td>
                                            </tr>

                                        </tbody>
                                    </table>
                                </div>

                                <div>&nbsp;</div>

                                <!-- 현재 기능 미구현 -->
                                <button style="height:50px; width:300px; font-size: 24px;">만들기</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
           
        </div>
        </div>
<script>
$(document).ready(function(){
 
 // 라디오버튼 클릭시 이벤트 발생
 $("input:radio[name=radio]").click(function(){

     if($("input[name=radio]:checked").val() == "1"){

         // radio 버튼의 value 값이 1이라면 활성화
        $("#mm").hide();
        $("#mmm").hide();

     }else if($("input[name=radio]:checked").val() == "0"){
        $("#mm").show();
        $("#mmm").show();
         // radio 버튼의 value 값이 0이라면 비활성화
     }
 });
});


</script>
</body>
</html>