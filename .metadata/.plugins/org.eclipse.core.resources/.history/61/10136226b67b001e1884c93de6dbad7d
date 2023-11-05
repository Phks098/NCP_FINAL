<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="data.dao.*"%>
<%@ page import="data.vo.*"%>
<%@ page import="java.util.ArrayList"%>
<%
MyPage_DAO dao = new MyPage_DAO();
/* ArrayList<student_VO>student = dao.getStudent_informaton(); */

Scholar_Evaluation_DAO test = new Scholar_Evaluation_DAO();

/* 김대욱 교수님 코드 10008 
   백지연 교수님 코드 1
   
   */
ArrayList<Student_VO> list = test.getStuduent_AllList("10008"); // 교수의 지도학생 정보

ArrayList<ArrayList<Mypage_VO>> levelList = new ArrayList();
ArrayList<Mypage_VO> leve = new ArrayList();

for (int i = 0; i < list.size(); i++) {
	leve = dao.getStudent_Level(list.get(i).getUniversity_number());
	levelList.add(leve);
}
%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="css/Main.css" />
<link rel="stylesheet" type="text/css" href="css/MyPage2.css" />
<link rel="stylesheet" type="text/css" href="css/LoginPopup.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
	integrity="sha512-rqQltXRuHxtPWhktpAZxLHUVJ3Eombn3hvk9PHjV/N5DMUYnzKPC1i3ub0mEXgFzsaZNeJcoE0YHq0j/GFsdGg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
	
<script src="https://kit.fontawesome.com/46fda0e82e.js"
	crossorigin="anonymous">
</script>
</head>
<body>

	<jsp:include page="TopArea.jsp" />
	<main class="main_contents">
		<div class="contents">
			<section class="nav-contents">
				<div class="nav-inner">
					<ul class="nav-list">
						<li class="l-info select-list"><a class="btnInfo">지도 학생
								정보</a></li>
				</div>

				<div  class="contents-info show">
					<%
					for (int i = 0; i < levelList.size(); i++) {
						String openClose = "openCloseToc('toc-content_" + i + "')"; /*자세히 보기 기능을 위한 함수*/
						String toggle = "toc-content_" + i;
						
					%>

					<section class="section_marea">
						<div class="info_text_area">
							<img
								src="https://semsplus.seowon.ac.kr/contents/images/client/sub/icon_tit_lg.png" />
							<h3 class="info_text">
								지도 학생 기본 정보_<%=(i + 1)%>
							</h3>
						</div>
						<div>
							<%
							String action = "/Project_NCP/Scholar_Evaluation.jsp?action=Evelment&student=" + list.get(i).getUniversity_number();
							String action2 = "/Project_NCP/Scholar_Evaluation.jsp?student=" + list.get(i).getUniversity_number();
							%>
				
								<div class="base_infermation_student">
									<div class="base_info_table">

										<table>
											<tbody>
												<tr>
													<th>단과대학</th>
													<td>사범대학</td>
													<th>소속</th>
													<td><%=list.get(i).getMajor()%></td>
												</tr>
												<tr>
													<th>지도 교수</th>
													<td><%=list.get(i).getPossfer()%></td>
													<th>학년</th>
													<td><%=list.get(i).getGrade()%></td>
												</tr>
												<tr>
													<th>학번</th>
													<td><%=list.get(i).getUniversity_number()%></td>
													<th>이름</th>
													<td><%=list.get(i).getName()%>(여성)</td>
												</tr>
											</tbody>
										</table>


									</div>
									<div class="base_info_table">
										<input type="button" id="toc-toggle" onclick= <%=openClose%> value="자세히보기" > 
										
									</div>
								</div>
							
							<div id=<%=toggle%> class="recommendation_result" style="display: none">
								<table>
									<tr>
										<th colspan="5">진단 결과</th>
									</tr>
									<tr>
										<th>진단역량</th>
										<th>역량별 진단 점수</th>
										<th>백분율</th>
										<th>준비수준</th>
										<th>순위</th>
									</tr>
									<%for(int j = 0; j<8; j++){ %>
									<tr>
										<th><%=levelList.get(i).get(j).getCategory_name()%></th>
										<td><%=levelList.get(i).get(j).getCategory_score()%></td>
										<td><%=levelList.get(i).get(j).getPreparation_degree()%>%</td>
										<td><%=levelList.get(i).get(j).getPrearation_level()%></td>
										<td><%=levelList.get(i).get(j).getPreparation_rank()%></td>
									</tr>
									<%} %>
									
								</table>
								<div><form action=<%=action%> method="post">
							<input class="goCheckBtn" type="submit" id="toc-toggle" value="진로개발준비도 평가">
							</form>
							<div><form action=<%=action%> method="post">
							<input class="goCheckBtn" type="submit" id="toc-toggle" value="진로정체감 평가">
							</form>
							</div>
							</div>
							
						</div>
						<br> <br> <br>


					</section>
					<%
					}
					%>
				</div>
	</main>
	<script>
	
	function openCloseToc(cost) {
		  if (document.getElementById(cost).style.display === 'block') {
					document.getElementById(cost).style.display = 'none';

				} else {
					document.getElementById(cost).style.display = 'block';
				}
			}
	
/* 	function openCloseToc(cost) {
			if (document.getElementById(cost).style.display === 'block') {
				document.getElementById(cost).style.display = 'none';
				document.getElementById('toc-toggle').textContent = '보이기';
			} else {
				document.getElementById(cost).style.display = 'block';
				document.getElementById('toc-toggle').textContent = '숨기기';
			}
		} */
	</script>
	<jsp:include page="SitemapPopup.jsp" />
	<jsp:include page="LoginPopup.jsp" />
	<script src="js/SitemapPopup.js"></script>
	<script src="js/LoginPopup.js"></script>
	<script src="js/MyPage.js"></script>
</body>
</html>