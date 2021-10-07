<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Profileport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>회원정보</title>
</head>
<style>

</style>
<body>
    <div id= "total">
        <div id = "header" class="Profile_membership" role = "banner">
            <h1>
                <a href = "main.html" class = "h_logo">
                    <span> 사이트 이름 </span>
                </a>
            </h1>

            <form id = "Profile_form" method="post" action="">
                <div id= "container" role="main">
                    <div id = "content"> 
                        <div class="c_header"> 
                            <h2>회원정보보기</h2>
                            <p class="contxt">회원정보를 표시합니다.</p>
                        </div>
                        <div class="Profile_content"> 
                            <div class="row_group">
                                <div class="Profile_row">
                                    <table>
                                        <tbody>
                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Profile_title">
                                                        <label for="id">아이디</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_id">
                                                        <!-- value를 회원정보테이블에서 받아와야함, 현재는 틀잡는단계라 임의의 값을 집어놓음 -->
                                                        <div type="text" id="id" name="id" class="int" title="ID" maxlength="20" style="height:20px; width:200px; font-size: 16px;">
                                                            아이디1
                                                        </div>
                                                            <!-- <span class="step_url"></span> -->
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Profile_title">
                                                        <label for="name">이름</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_name">
                                                        <div type="text" id="name" name="name" class="int" title="NAME" maxlength="20" style="height:20px; width:200px; font-size: 16px;" readonly>
                                                            이름1
                                                        </div>
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Profile_title">
                                                        <label for="pswd">비밀번호</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_pass" id="pswd1Img">
                                                        <input type="password" id="password" name="pswd" class="int" title="PASSWORD" maxlength="20" value="333" style="height:20px; width:200px; font-size: 16px;" " readonly>
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Profile_title">
                                                        <label for="tel">전화번호</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_tel" id="telImg">
                                                        <input type="text" id="tel" name="tel" class="int" title="TEL" maxlength="20" value="111-2222-3333" style="height:20px; width:200px; font-size: 16px;" " readonly>
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Profile_title">
                                                        <label for="address">주소</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_addr" id="addrImg">
                                                        <input type="text" id="address" name="address" class="int" title="ADDRESS" maxlength="20" value="333" style="height:20px; width:200px; font-size: 16px;" " readonly>
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Profile_title">
                                                        <label for="field">관심분야</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_field" id="fieldImg">
                                                        <input type="text" id="field" name="field" class="int" title="FEILD" maxlength="20" value="IT" style="height:20px; width:200px; font-size: 16px;" " readonly>
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Profile_title">
                                                        <label for="job">직업</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_job" id="jobImg">
                                                        <input type="text" id="job" name="job" class="int" title="JOB" maxlength="20" value="무직" style="height:20px; width:200px; font-size: 16px;" " readonly>
                                                    </span>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>     
                                </div>

                                <div>&nbsp;</div>

                                <!-- 현재 기능 미구현 -->
                                <button>수정</button>
                                <button>돌아가기</button>
                            </div>
                        </div>
                    </div>
                </div>


            </form>
        </div>


    </div>
</body>
</html>