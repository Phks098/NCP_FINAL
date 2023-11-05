<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="data.dao.*"%>
<%@ page import="data.vo.*"%>
<%@ page import="java.util.ArrayList"%>

<%
MyPage_DAO dao = new MyPage_DAO();
Student_VO student = (Student_VO) request.getAttribute("student");
%>

<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>서원대학교</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="css/Main.css" />
<link rel="stylesheet" type="text/css" href="css/Prototype_CSS.css" />
<link rel="stylesheet" type="text/css" href="css/LoginPopup.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
	integrity="sha512-rqQltXRuHxtPWhktpAZxLHUVJ3Eombn3hvk9PHjV/N5DMUYnzKPC1i3ub0mEXgFzsaZNeJcoE0YHq0j/GFsdGg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://kit.fontawesome.com/46fda0e82e.js"
	crossorigin="anonymous"></script>
</head>
<%
String content1 = "contents-setting1 show";
String content2 = "contents-setting2";

if (student.getMajor().equals("수학교육과") || student.getMajor().equals("국어교육과") || student.getMajor().equals("영어전공")) {

	content1 = "contents-setting1 show";
	content2 = "contents-setting2";
} else {
	content1 = "contents-setting1";
	content2 = "contents-setting show";
}

Education_Result_Get_DAO education = new Education_Result_Get_DAO();

Education_Result_VO data = new Education_Result_VO();
data = education.getCheckEducation(student.getUniversity_number());

int chekc = 0;

if (data == null) {
	chekc = -1;
} else {

	if (data.isResult().equals("비교직")) {
		chekc = 0;
	} else if (data.isResult().equals("교직")) {
		chekc = 1;
	}

}
%>

<body>
	<jsp:include page="TopArea.jsp" />
	<main class="main_contents">
		<div class="contents">
			<section class="nav-contents">
				<div class="nav-inner">
					<ul class="nav-list">
						<%
						if (student.getMajor().equals("수학교육과") || student.getMajor().equals("국어교육과") || student.getMajor().equals("영어전공")) {
						%>
						<li class="l-setting select-list"><a class="btnSetting1">진로정체감검사</a></li>
						<%
						}
						%>
						<li class="l-setting2"><a class="btnSetting2">진로개발준비도검사</a></li>
					</ul>
				</div>

				<!-- 사범대학생 전용 검사 페이지 -->
				<div class="<%=content1%>">
					<%
					String action2 = "Mypage2?action=Education_Test_Set&student=" + student.getUniversity_number();
					String exit = "Mypage2?student" + student.getUniversity_number();
					%>

					<form action=<%=action2%> method="post">
						<div class="tbl tbl_fixed tbl_row">


							<div class="match tbl_fixed match_row">


								<table>
									<colgroup>
										<col style="width: 10%;">
										<col style="width: 40%;">
										<col style="width: 10%;">
										<col style="width: 10%;">
										<col style="width: 10%;">
										<col style="width: 10%;">
										<col style="width: 10%;">
									</colgroup>

									<tr>
										<td colspan="7">[사범대 전용 진로정체감 검사]</td>
									</tr>
									<tr>
										<th rowspan="2">하위 영역</th>
										<th rowspan="2">문항내용</th>
										<th colspan="5">자가진단 진단 척도(실행 수준)</th>

									</tr>

									<tr>
										<th>매우 그렇지 않다</th>
										<th>그렇지 않다</th>
										<th>보통</th>
										<th>그렇다</th>
										<th>매우 그렇다</th>


									</tr>
									<tr>
										<th rowspan="7">인지</th>
										<td>나는 나의 적성을 탐색하고 교사라는 진로와 연결해 보고 싶다.</td>
										<%
										for (int i = 1; i < 6; i++) {
										%>
										<td><label><input class="Scolar_Evauation"
												name="check_1" value=<%=i%> type="radio"
												onclick="checkOnly(this,this.name)"></label></td>
										<%
										}
										%>
									</tr>
									<tr>
										<th>진로와 관련된 사항을 스스로 결정하기 위해 내가 무엇을 원하는지 나 자신에 대해 이해하는 시간을
											갖고 싶다.</th>
										<%
										for (int i = 1; i < 6; i++) {
										%>
										<td><label><input class="Scolar_Evauation"
												name="check_2" value=<%=i%> type="radio"></label></td>
										<%
										}
										%>
									</tr>
									<tr>
										<td>나는 교사가 된 후 나아갈 수 있는 방향에 대해 알고 교사로서의 나의 모습을 고민해 보고 싶다.
										</td>
										<%
										for (int i = 1; i < 6; i++) {
										%>
										<td><label><input class="Scolar_Evauation"
												name="check_3" value=<%=i%> type="radio"></label></td>
										<%
										}
										%>
									</tr>
									<tr>
										<th>진로와 관련된 나의 가치관을 탐색하고 싶다.</th>
										<%
										for (int i = 1; i < 6; i++) {
										%>
										<td><label><input class="Scolar_Evauation"
												name="check_4" value=<%=i%> type="radio"></label></td>
										<%
										}
										%>
									</tr>
									<tr>
										<td>내가 좋아하고 관심 있는 일이 무엇인지 고민하고 교사라는 진로에 포함되는지 생각해 보고 싶다.</td>
										<%
										for (int i = 1; i < 6; i++) {
										%>
										<td><label><input class="Scolar_Evauation"
												name="check_5" value=<%=i%> type="radio"></label></td>
										<%
										}
										%>
									</tr>
									<tr>
										<th>내가 원치 않는 진로를 부모님께 강요받았을 때 나의 뜻을 분명히 전달하고 나의 의지로 진로를
											선택하고 싶다.</th>
										<%
										for (int i = 1; i < 6; i++) {
										%>
										<td><label><input class="Scolar_Evauation"
												name="check_6" value=<%=i%> type="radio"></label></td>
										<%
										}
										%>
									</tr>
									<tr>
										<td>나는 앞으로 진로와 관련하여 해야 할 일을 결정하고 그것을 잘 처리할 수 있을 것이라는 확신을
											갖고 싶다.</td>
										<%
										for (int i = 1; i < 6; i++) {
										%>
										<td><label><input class="Scolar_Evauation"
												name="check_7" value=<%=i%> type="radio"></label></td>
										<%
										}
										%>
									</tr>

									<tr>
										<th rowspan="7">정서</th>
										<th>나는 교사로서의 나의 능력이 무엇인지 몰라 생기는 막막함을 해소하고 싶다.</th>
										<%
										for (int i = 1; i < 6; i++) {
										%>
										<td><label><input class="Scolar_Evauation"
												name="check_8" value=<%=i%> type="radio"></label></td>
										<%
										}
										%>
									</tr>
									<tr>
										<td>나는 진로와 관련하여 생기는 지나친 불안을 줄이고 싶다.</td>
										<%
										for (int i = 1; i < 6; i++) {
										%>
										<td><label><input class="Scolar_Evauation"
												name="check_9" value=<%=i%> type="radio"></label></td>
										<%
										}
										%>
									</tr>
									<tr>
										<th>나는 교사라는 진로에 대해 잘 모르는 것 같아 생기는 막연한 걱정을 덜고 싶다.</th>
										<%
										for (int i = 1; i < 6; i++) {
										%>
										<td><label><input class="Scolar_Evauation"
												name="check_10" value=<%=i%> type="radio"></label></td>
										<%
										}
										%>
									</tr>
									<tr>
										<td>나는 교사라는 진로에 대한 구체적 목표가 없어서 발생하는 고민을 줄이고 싶다.</td>
										<%
										for (int i = 1; i < 6; i++) {
										%>
										<td><label><input class="Scolar_Evauation"
												name="check_11" value=<%=i%> type="radio"></label></td>
										<%
										}
										%>
									</tr>
									<tr>
										<th>나의 전공이나 앞으로의 진로에 대해 친구들과 비교하지 않고 진로와 관련된 나의 정서를 수용하고
											싶다.</th>
										<%
										for (int i = 1; i < 6; i++) {
										%>
										<td><label><input class="Scolar_Evauation"
												name="check_12" value=<%=i%> type="radio"></label></td>
										<%
										}
										%>
									</tr>
									<tr>
										<td>나의 흥미가 교사라는 진로와 맞지 않을까 봐 생기는 두려움에 대해 표현하고 그 두려움을 덜고
											싶다.</td>
										<%
										for (int i = 1; i < 6; i++) {
										%>
										<td><label><input class="Scolar_Evauation"
												name="check_13" value=<%=i%> type="radio"></label></td>
										<%
										}
										%>
									</tr>
									<tr>
										<th>나는 강점 탐색을 통해 나의 전공을 살려 취업하는데 필요한 자신감을 갖고 싶다.</th>
										<%
										for (int i = 1; i < 6; i++) {
										%>
										<td><label><input class="Scolar_Evauation"
												name="check_14" value=<%=i%> type="radio"></label></td>
										<%
										}
										%>
									</tr>


									<tr>
										<th rowspan="5">행동</th>
										<td>나는 교사에 대해 알아보기 위해 책, 교재, 참고서적, 기타 필요한것 등 여러 가지 정보를
											수집하고 공유하고 싶다.</td>
										<%
										for (int i = 1; i < 6; i++) {
										%>
										<td><label><input class="Scolar_Evauation"
												name="check_15" value=<%=i%> type="radio"></label></td>
										<%
										}
										%>
									</tr>
									<tr>
										<th>나는 교사 이외의 여러 가지 종류의 직업을 탐색해 보고 싶다.</th>
										<%
										for (int i = 1; i < 6; i++) {
										%>
										<td><label><input class="Scolar_Evauation"
												name="check_16" value=<%=i%> type="radio"></label></td>
										<%
										}
										%>
									</tr>
									<tr>
										<td>나는 교사가 되기 위해 실제로 어떻게 해야 하는지 알고 계획을 세워 보고 싶다.</td>
										<%
										for (int i = 1; i < 6; i++) {
										%>
										<td><label><input class="Scolar_Evauation"
												name="check_17" value=<%=i%> type="radio"></label></td>
										<%
										}
										%>
									</tr>
									<tr>
										<th>나는 관심 있는 진로분야에 대한 나의 생각과 고민을 주변의 사람들에게 표현하고 싶다.</th>
										<%
										for (int i = 1; i < 6; i++) {
										%>
										<td><label><input class="Scolar_Evauation"
												name="check_18" value=<%=i%> type="radio"></label></td>
										<%
										}
										%>
									</tr>

									<tr>
										<td>나에게 적합한 진로를 탐색하기 위해 상담이나 심리검사 등을 활용하고 싶다.</td>
										<%
										for (int i = 1; i < 6; i++) {
										%>
										<td><label><input class="Scolar_Evauation"
												name="check_19" value=<%=i%> type="radio"></label></td>
										<%
										}
										%>
									</tr>
								</table>


							</div>

							<input type="submit" class="level_saveBtn" value="저장">
					</form>
					<form action=<%=exit%>>
						<input type="submit" class="level_saveBtn" value="취소">
					</form>

				</div>
		</div>
		<!-- contents-setting1/진로이해검사 -->

		<div class="<%=content2%>">
			<%
			String action = "Mypage2?action=reTest&student=" + student.getUniversity_number();

			System.out.println(action);
			%>
			<form action=<%=action%> method="post">
				<div class="match tbl_fixed match_row">
					<table>
						<colgroup>
							<col style="width: 10%;">
							<col style="width: 40%;">
							<col style="width: 10%;">
							<col style="width: 10%;">
							<col style="width: 10%;">
							<col style="width: 10%;">
							<col style="width: 10%;">
						</colgroup>
						<tr>
							<td colspan="7">[커리어넷 진로개발 준비도 검사]</td>
						</tr>
						<tr>
							<th rowspan="2">하위 영역</th>
							<th rowspan="2">문항내용</th>
							<th colspan="5">자가진단 진단 척도(실행 수준)</th>
						</tr>

						<tr>
							<th>매우 그렇지 않다</th>
							<th>그렇지 않다</th>
							<th>보통</th>
							<th>그렇다</th>
							<th>매우 그렇다</th>
						</tr>
						<tr>
							<th rowspan="5">1.자기이해</th>
							<td>나는 내가 어떤 일을 좋아하는지 안다.</td>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_1"
								value=<%=i%> type="radio"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<th>나는 내 자신에 대해 잘 알고 있다.</th>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_2"
								value=<%=i%> type="radio"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<td>나는 내가 무엇을 잘 하는지 안다.</td>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_3"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<th>나는 내가 소중하게 생각하는 가치가 무엇인지 안다.</th>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_4"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<td>나는 내가 즐겁게 할 수 있는 일이 무엇인지 안다.</td>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_5"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<th rowspan="6">2.전공직업지식</th>
							<th>나는 내가 관심 있는 직업에서 하는 일과 필요한 능력에 대해 안다.</th>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_6"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<td>나는 내가 선택한 전공(학과)에 대해 잘 알고 있다.</td>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_7"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<th>나는 내가 관심 있는 직업의 향후 전망에 대해 안다.</th>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_8"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>

						</tr>
						<tr>
							<td>나는 내가 관심 있는 직업에 대해 잘 알고 있다.</td>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_9"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<th>나는 나의 전공에 관련된 직업에 대하여 상세히 설명해 줄 수 있다</th>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_10"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<td>나는 내가 관심 있는 직업의 임금수준과 근무환경에 대해 안다.</td>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_11"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>






						<tr>
							<th rowspan="5">3.진로결정</th>
							<td>나는 나의 진로를 결정했다.</td>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_12"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<th>나는 내가 결정한 진로에 대하여 당분간은 바꿀 생각이 없다.</th>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_13"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<td>나는 내가 결정한 진로에 대해 만족한다.</td>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_14"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<th>나는 타인들에게 내가 결정한 진로에 대해 말할 수 있다.</th>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_15"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>

						<tr>
							<td>나는 내가 결정한 진로와 관련하여 구체적인 계획을 갖고 있다.</td>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_16"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>

						<tr>
							<th rowspan="6">4.의사결정</th>
							<td>나는 나의 진로를 결정했다.</td>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_17"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<th>나는 내가 결정한 진로에 대하여 당분간은 바꿀 생각이 없다.</th>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_18"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<td>나는 내가 결정한 진로에 대해 만족한다.</td>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_19"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<th>나는 타인들에게 내가 결정한 진로에 대해 말할 수 있다.</th>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_20"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>

						<tr>
							<td>나는 내가 결정한 진로와 관련하여 구체적인 계획을 갖고 있다.</td>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_21"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<th>나는 내가 결정한 진로에 대하여 당분간은 바꿀 생각이 없다.</th>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_22"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>




						<tr>
							<th rowspan="6">5.관계활용</th>
							<td>나는 진로를 결정하는 과정에서 주변 사람들에게 도움을 달라고 요청할 수 있다.</td>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_23"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<th>나는 관심 갖고 있는 기업에 대한 정보를 대학의 취업관련 기관에 방문하여 알아 볼 수 있다.</th>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_24"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<td>나는 취업 기회에 대한 정보를 주변 사람들에게 요청하여 얻을 수 있다.</td>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_25"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<th>나는 채용과 관련된 의문이 있을 때 인사담당자에게 직접 문의할 수 있다.</th>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_26"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>

						<tr>
							<td>나는 내가 어려움에 처했을 때 도와줄 수 있는 사람을 찾아 도움을 요청할 수 있다.</td>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_27"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<td>나는 취업을 위해 주변 사람들에게 도움을 요청할 수 있다.</td>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_28"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>


						<tr>
							<th rowspan="7">6.구직준비도</th>
							<td>나는 진로를 결정하는 과정에서 주변 사람들에게 도움을 달라고 요청할 수 있다.</td>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_29"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<th>나는 관심 갖고 있는 기업에 대한 정보를 대학의 취업관련 기관에 방문하여 알아 볼 수 있다.</th>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_30"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<td>나는 취업 기회에 대한 정보를 주변 사람들에게 요청하여 얻을 수 있다.</td>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_31"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<th>나는 채용과 관련된 의문이 있을 때 인사담당자에게 직접 문의할 수 있다.</th>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_32"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>

						<tr>
							<td>나는 내가 어려움에 처했을 때 도와줄 수 있는 사람을 찾아 도움을 요청할 수 있다.</td>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_33"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<td>나는 취업을 위해 주변 사람들에게 도움을 요청할 수 있다.</td>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><input class="Scolar_Evauation" name="check_34"
								value=<%=i%> type="radio" onclick="checkOnly(this,this.name)"></td>
							<%
							}
							%>
						</tr>
						<tr>
							<td>나는 나의 이력서를 잘 작성할 수 있다.</td>
							<%
							for (int i = 1; i < 6; i++) {
							%>
							<td><label><input class="Scolar_Evauation"
									name="check_35" value=<%=i%> type="radio"
									onclick="checkOnly(this,this.name)"></label></td>
							<%
							}
							%>
						</tr>
					</table>
				</div>

				<input type="submit" class="level_saveBtn" value="저장">
			</form>
			<form action=<%=exit%>>
				<input type="submit" class="level_saveBtn" value="취소">
			</form>

			</section>
		</div>
		<!-- contents--setting/진로개발준비도 검사 출력 div -->


		<!--contents(End)-->

	</main>
	<jsp:include page="SitemapPopup.jsp" />
	<jsp:include page="LoginPopup.jsp" />
	<script src="js/SitemapPopup.js"></script>
	<script src="js/LoginPopup.js"></script>
	<script type="text/javascript">
	
	const btnSetting1= document.querySelector(".btnSetting1");
	const btnSetting2 = document.querySelector(".btnSetting2");
	const contentsSetting1 = document.querySelector(".contents-setting1");
	const contentsSetting2 = document.querySelector(".contents-setting2");
	const label1 = document.querySelector(".l-setting");
	const label2 = document.querySelector(".l-setting2");
	var con = <%=chekc%>;




	btnSetting1.addEventListener("click", () => {
	
		contentsSetting2.classList.remove("show");
		label2.classList.remove("select-list")
		
		if (!contentsSetting1.classList.contains("show")) {
			label1.classList.add("select-list")
			contentsSetting1.classList.add("show");
			
		}
		
		
	});


	btnSetting2.addEventListener("click", () => {
		
		
		if(con == -1){
			alert("진로정체감검사를 진행해주세요!")
		}else if(con == 1){
			alert("진로개발준비도검사 대상이 아닙니다!")
		}else{
		
		contentsSetting1.classList.remove("show");
		label1.classList.remove("select-list")

		if (!contentsSetting2.classList.contains("show")) {
			label2.classList.add("select-list")
			contentsSetting2.classList.add("show");
		}
		}
	});
	</script>
	<script src="js/Scholar_Evaluation.js"></script>
</body>
</html>