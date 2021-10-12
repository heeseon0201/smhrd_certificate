<%@ page language="java" contentType="text/html; charset=UTF-8"
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
                    <span> Studynet </span>
                </a>
            </h1>

            <form id = "Profile_form" method="post" action="">
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
                                                        <input type="text" id="address" name="address" class="int" title="ADDRESS" maxlength="20" style="height:20px; width:200px; font-size: 16px;">
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
                                                            <option value="01">관심분야1</option>
                                                            <option value="02">관심분야2</option>
                                                            <option value="03">관심분야3</option>
                                                            <option value="04">관심분야4</option>
                                                            <option value="05">관심분야5</option>
                                                            <option value="06">관심분야6</option>
                                                            <option value="07">관심분야7</option>
                                                            <option value="08">관심분야8</option>
                                                            <option value="09">관심분야9</option>
                                                            <option value="10">관심분야10</option>
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
                                                            <option value="01">직업1</option>
                                                            <option value="02">직업2</option>
                                                            <option value="03">직업3</option>
                                                            <option value="04">직업4</option>
                                                            <option value="05">직업5</option>
                                                            <option value="06">직업6</option>
                                                            <option value="07">직업7</option>
                                                            <option value="08">직업8</option>
                                                            <option value="09">직업9</option>
                                                            <option value="10">직업10</option>
                                                        </select>
                                                    </span>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>

                                <div>&nbsp;</div>

                                <!-- 현재 기능 미구현 -->
                                <button style="height:50px; width:300px; font-size: 24px;">가입하기</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
           
        </div>
        </div>
  
</body>
</html>