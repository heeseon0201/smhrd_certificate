<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Profileport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>회원가입</title>
    <link rel="stylesheet" href="join.css">
</head>

<body>
    <div id= "total">
        <div id = "header" class="Profile_membership" role = "banner">
            <h1>
                <a href = "main.jsp" class = "h_logo">
                    <span> I-Study </span>
                </a>
            </h1>

            <form id = "Profile_form" method="post" action="JoinService" accept-charset="euc-kr">
                <div id= "container" role="main">
                    <div id = "content"> 
                        <div class="c_header"> 
                            <h2>회원가입</h2>
                            <p class="contxt">아래의 기재사항을 입력해주세요.</p>
                        </div>

                        <div class="Profile_content"> 
                            <div class="row_group">
                                <div class="Profile_row">
                                    <table>
                                        <tbody>
                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_id">
                                                        <label for="id">*아이디</label>
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
                                                    <span class="step_url" style="color: red;">8자~12자의 영문, 숫자 조합으로 작성하세요.</span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_pwd">
                                                        <label for="pwd">*비밀번호</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_pwd" id="pwd1Img">
                                                        <input type="password" id="password" name="pwd" class="int" title="PASSWORD" maxlength="20" value="" style="height:20px; width:200px; font-size: 16px;">
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td colspan="2">
                                                    <!-- 제대로 입력시 글자색과 내용바뀌게 설계해보자 -->
                                                    <span class="step_url" style="color: red;">8자~15자의 영문, 숫자, 특수문자 조합으로 작성하세요.</span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_repwd">
                                                        <label for="repwd">*비밀번호 재확인</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_repwd" id="repwd1Img">
                                                        <input type="password" id="repassword" name="repwd" class="int" title="REPASSWORD" maxlength="20" value="" style="height:20px; width:200px; font-size: 16px;">
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td colspan="2">
                                                    <!-- 제대로 입력시 글자색과 내용바뀌게 설계해보자 -->
                                                    <span class="step_url" style="color: red;">비밀번호를 재입력해주세요.</span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_name">
                                                        <label for="name">*이름</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_name">
                                                        <input type="text" id="name" name="name" class="int" title="NAME" maxlength="20" style="height:20px; width:200px; font-size: 16px;">
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_YMD">
                                                        <label for="YMD">생년월일</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_yy">
                                                        <input type="text" id="yy" placeholder="년(4자)" aria-label="년" name="yy" class="int" title="YEAR" maxlength="4" style="height:20px; width:50px; font-size: 16px;">
                                                    </span>
                                                    <span class="ps_box int_mm">
                                                        <select id="mm" class="sel" aria-label="월" style="height:25px; width:50px; font-size: 16px;">
                                                            <option value="">월</option>
                                                            <option value="01">1</option>
                                                            <option value="02">2</option>
                                                            <option value="03">3</option>
                                                            <option value="04">4</option>
                                                            <option value="05">5</option>
                                                            <option value="06">6</option>
                                                            <option value="07">7</option>
                                                            <option value="08">8</option>
                                                            <option value="09">9</option>
                                                            <option value="10">10</option>
                                                            <option value="11">11</option>
                                                            <option value="12">12</option>
                                                        </select>
                                                    </span>
                                                    <span class="ps_box int_dd">
                                                        <input type="text" id="dd" placeholder="일" aria-label="일" name="dd" class="int" title="DAY" maxlength="2" style="height:20px; width:50px; font-size: 16px;">
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_sex">
                                                        <label for="sex">성별</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_sex">
                                                        <select id="sex" class="sel" aria-label="성별" style="height:30px; width:200px; font-size: 16px;">
                                                            <option value="">성별</option>
                                                            <option value="남">남</option>
                                                            <option value="여">여</option>
                                                        </select>
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_tel">
                                                        <label for="tel">전화번호</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_tel">
                                                        <input type="text" id="tel" name="tel" placeholder="000-0000-0000" class="int" title="TEL" maxlength="20" style="height:20px; width:200px; font-size: 16px;">
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_address">
                                                        <label for="address">주소</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_address">
                                                        <input type="text" id="address" placeholder="주소" name="address" class="int" title="ADDRESS" maxlength="20" style="height:20px; width:200px; font-size: 16px;">
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_interest">
                                                        <label for="interest">관심분야</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_interest">
                                                        <select id="interest" name="interest" class="sel" aria-label="관심분야" style="height:30px; width:200px; font-size: 16px;">
                                                            <option value="">관심분야를 선택하세요</option>
                                                            <option value="01">IT</option>
                                                            <option value="02">경영, 경제</option>
                                                            <option value="03">교육</option>
                                                            <option value="04">환경/에너지</option>
                                                            <option value="05">법률</option>
                                                            <option value="06">복지</option>
                                                            <option value="07">심리</option>
                                                            <option value="08">사회안전/범죄</option>
                                                            <option value="09">의료</option>
                                                            <option value="10">공학</option>
                                                            <option value="11">기타</option>
                                                        </select>
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_job">
                                                        <label for="job">직업</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_job">
                                                        <select id="job" name="job" class="sel" aria-label="직업" style="height:30px; width:200px; font-size: 16px;">
                                                            <option value="">직업를 선택하세요</option>
                                                            <option value="01">고등학생</option>
                                                            <option value="02">대학생</option>
                                                            <option value="03">취업준비생</option>
                                                            <option value="04">회사원</option>
                                                            <option value="05">전문직</option>
                                                            <option value="06">주부</option>
                                                            <option value="07">사업가</option>
                                                            <option value="08">기타</option>
                                                            <option value="09">무직</option>
                                                        </select>
                                                    </span>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>

                                <div>&nbsp;</div>

                            
                                <button style="height:50px; width:300px; font-size: 24px;">가입하기</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <button class="gobackBtn" onclick="document.location.href='main.jsp'" style="width: 300px; height: 50px; font-size: 24px; display: block; margin: 15px auto;">뒤로가기</button>
        </div>
    </div>
</body>
</html>