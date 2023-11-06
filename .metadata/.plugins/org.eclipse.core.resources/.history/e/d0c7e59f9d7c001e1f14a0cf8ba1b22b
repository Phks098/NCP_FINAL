<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="data.dao.*"%>
<%@ page import="data.vo.*"%>
<%@ page import="java.util.ArrayList"%>

<%

System.out.println("페이지 직접 전달함" + request.getParameter("student"));
String parmater = request.getParameter("student");
String professor = (String) request.getAttribute("professor");
MyPage_DAO dao = new MyPage_DAO();
Student_VO student = dao.getStudentInformation(parmater);

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
<link rel="stylesheet" type="text/css" href="css/MyPage2.css" />
<link rel="stylesheet" type="text/css" href="css/LoginPopup.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
	integrity="sha512-rqQltXRuHxtPWhktpAZxLHUVJ3Eombn3hvk9PHjV/N5DMUYnzKPC1i3ub0mEXgFzsaZNeJcoE0YHq0j/GFsdGg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://kit.fontawesome.com/46fda0e82e.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="TopArea.jsp" />
	<main class="main_contents">
		<div class="contents">
			<section class="nav-contents">
				<div div class="contents-info show">
					<div class="tbl tbl_fixed tbl_row">
						<table>
							<colgroup>
								<col style="width: 20%;">
								<col style="width: 30%;">
								<col style="width: 20%;">
								<col style="width: 30%;">
							</colgroup>

							<tbody>
								<tr>
									<th>소속</th>
									<td><%=student.getMajor()%></td>
									<th scope="row">지도교수</th>
									<td><%=student.getPossfer()%></td>

								</tr>

								<tr>
									<th scope="row">부/복수/연계/융합전공</th>
									<td></td>
									<th>학년</th>
									<td><%=student.getGrade()%></td>
								</tr>
								
								<tr>
									<th scope="row">학번</th>
									<td><%=student.getUniversity_number()%></td>
									<th>이름</th>
									<td><%=student.getName()%>(<%=student.getSex()%>)</td>
								</tr>
								<tr>
									<th scope="row">주소</th>
									<td colspan="3"></td>
								</tr>
								
								
								
							</tbody>
						</table>
					</div>
		
					<%
					String action = "Professor_Search_Student_Servlet?action=Evelment&student="+student.getUniversity_number()+"&professor="+professor;
					String exit = "/Project_NCP/Professor_Search_Student_Servlet?professor="+professor;
					System.out.println(action);
					%>

					<form action=<%=action%> method="post">
						<div class="match tbl_fixed match_row">
							<table>
								<colgroup>
									<col style="width: 15%;">
									<col style="width: 35%;">
									<col style="width: 10%;">
									<col style="width: 10%;">
									<col style="width: 10%;">
									<col style="width: 10%;">
									<col style="width: 10%;">
								</colgroup>
								<tr>
									<td colspan="7">[교수전용 진로개발준비도 평가지]</td>
								</tr>
								<tr>
									<th rowspan="2">진단 영역</th>
									<th rowspan="2">행동지표</th>
									<th colspan="5">지도교수 진단 척도</th>
								</tr>
								<tr>
									<th>매우 그렇지 않다</th>
									<th>그렇지 않다</th>
									<th>보통</th>
									<th>그렇다</th>
									<th>매우 그렇다</th>

								</tr>
								<tr>
									<th>자기이해</th>
									<td>학생이 무엇을 좋아하고, 잘 할 수 있으며, 또 중요시하는 것에 대해 비교적 잘 알고 있다.</td>
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
									<th>전공직업지식</th>
									<td>학생이 관심있는 직업과 전공에 대해 비교적 잘 알고 있다.</td>
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
									<th>진로결정확신도</th>
									<td>학생이 현재 자신이 결정한 진로에 대해 확신과 만족이 비교적 높은 편이다.</td>
									<%
									for (int i = 1; i < 6; i++) {
									%>
									<td><input class="Scolar_Evauation" name="check_3"
										value=<%=i%> type="radio"></td>
									<%
									}
									%>
								</tr>

								<tr>
									<th>의사결정자신감</th>
									<td>학생이 의사결정에 대한 자신감이 비교적 높은 편이다.</td>
									<%
									for (int i = 1; i < 6; i++) {
									%>
									<td><input class="Scolar_Evauation" name="check_4"
										value=<%=i%> type="radio"></td>
									<%
									}
									%>
								</tr>

								<tr>
									<th>관계활용자신감</th>
									<td>학생이 일상생활이나 취업과 관련된 정보나 사회적 지지를 얻기 위해 주위 사람들과 관계를 적극적을
										활용하는 편이다.</td>
									<%
									for (int i = 1; i < 6; i++) {
									%>
									<td><input class="Scolar_Evauation" name="check_5"
										value=<%=i%> type="radio"></td>
									<%
									}
									%>
								</tr>

								<tr>
									<th>구직준비도</th>
									<td>학생이 취업을 위해 구체적으로 요청되는 사항들에 대해 자신감이 있어 준비가 높은 편이다.</td>
									<%
									for (int i = 1; i < 6; i++) {
									%>
									<td><input class="Scolar_Evauation" name="check_6"
										value=<%=i%> type="radio"></td>
									<%
									}
									%>
								</tr>

							</table>

						</div>
						
							<input type="submit" class="level_saveBtn" value="저장"> 
						</form>
						<form action=<%=exit%> method="post">
								<input type="submit" class="level_saveBtn" value="취소">
						</form>
					
				</div>
			</section>
		</div>
	</main>

	<jsp:include page="SitemapPopup.jsp" />
	<jsp:include page="LoginPopup.jsp" />
	<script src="js/SitemapPopup.js"></script>
	<script src="js/LoginPopup.js"></script>
	<script src="js/MyPage.js"></script>
	<script src="js/Scholar_Evaluation.js"></script>
</body>
</html>