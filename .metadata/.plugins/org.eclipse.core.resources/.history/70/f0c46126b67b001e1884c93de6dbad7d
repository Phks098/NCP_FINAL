<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="data.dao.*"%>
<%@ page import="data.vo.*"%>
<%@ page import="java.util.ArrayList"%>
<%

ArrayList<Student_VO> list = (ArrayList<Student_VO>) request.getAttribute("studentList");// 교수의 지도학생 정보
ArrayList<ArrayList<Mypage_VO>> levelList = (ArrayList<ArrayList<Mypage_VO>>) request.getAttribute("levelList");
ArrayList<Integer> graph_line = new ArrayList<Integer>();
String professor = request.getParameter("professor");
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

				<div class="contents-info show">
				
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
							String action = "/Project_NCP/Professor_Search_Student_Servlet?action=goEvelment&student="+list.get(i).getUniversity_number()+"&professor="+professor;
							String action2 = "/Project_NCP/Professor_Search_Student_Servlet?action=goEducaion&student="+list.get(i).getUniversity_number()+"&professor="+professor;
							String action3 = "http://211.59.155.146:8080/studentpage?university_number="+list.get(i).getUniversity_number();
							%>

							<div class="base_infermation_student">
								<div class="base_info_table">

									<table>
										<tbody>
											<tr>
												<th>단과대학</th>
												<td> </td>
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
												<td><%=list.get(i).getName()%>(<%=list.get(i).getSex() %>)</td>
											</tr>
										</tbody>
									</table>


								</div>
								<div class="base_info_table">
									<input type="button" id="toc-toggle" onclick=<%=openClose%>
										value="자세히보기">

								</div>
							</div>

							<div id=<%=toggle%> class="recommendation_result"
								style="display: none">
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
									<%
									
									String canv = "myCanvas_"+i;
									if(levelList.get(i).get(0).getPreparation_rank() != 0){
										
									
										graph_line = new ArrayList<Integer>();
									for (int j = 0; j < levelList.get(i).size(); j++) {
										graph_line.add(levelList.get(i).get(j).getPreparation_degree());
									%>
									<tr>
										<th><%=levelList.get(i).get(j).getCategory_name()%></th>
										<td><%=levelList.get(i).get(j).getCategory_score()%></td>
										<td><%=levelList.get(i).get(j).getPreparation_degree()%>%</td>
										<td><%=levelList.get(i).get(j).getPrearation_level()%></td>
										<td><%=levelList.get(i).get(j).getPreparation_rank()%></td>
									</tr>
									<%
									}
									
									}else{
										graph_line = new ArrayList<Integer>();
										for (int t = 0; t < 8; t++) {
											graph_line.add(0);
											}
										
									
									
						
									%>
									<tr>
									<th>자기이해</th>
									<td colspan="5" rowspan="8" style="font-size: 20px;">진로개발진비도
										검사를 진행해주세요
									</td>
								</tr>
								<tr>
									<th>진로탐색</th>
								</tr>
								<tr>
									<th>진로결정</th>
								</tr>
								<tr>
									<th>진로설계</th>
								</tr>
								<tr>
									<th>경력개발</th>
								</tr>
								<tr>
									<th>실무역량</th>
								</tr>
								<tr>
									<th>맞춤취업</th>
								</tr>
								<tr>
									<th>구직활동</th>
								</tr>
								<%
								}
								%>
								</table>
								<div class="canvas_graph">
									<canvas id=<%=canv%> style="background-color: aliceblue"
										width="600px" height="600px">
									</canvas>

								</div>


								<div>
									<form action=<%=action%> method="post">
										<input class="goCheckBtn" type="submit" id="toc-toggle"
											value="진로개발준비도 평가">
									</form>
									<%if(list.get(i).getMajor().equals("수학교육과") || list.get(i).getMajor().equals("국어교육과")
											|| list.get(i).getMajor().equals("영어전공")){
									%>
									<form action=<%=action2%> method="post">
										<input class="goCheckBtn" type="submit" id="toc-toggle"
											value="진로정체감 평가">
									</form>
									<%} %>
									
									<form action=<%=action3%> method="post">
										<input class="goCheckBtn" type="submit" id="toc-toggle"
											value="추천목록">
									</form>
								</div>
							
							</div>

						</div>
						<br> <br> <br>


					</section>


<script type="text/javascript">
var str = "<%=canv%>"
var canvas = document.getElementById(str);
var context = canvas.getContext("2d");

var center =300;





context.beginPath();
context.arc(center,center,180,0,2*Math.PI,false);
context.lineWidth = 2;
context.strokeStyle = "black";
context.stroke();

context.beginPath();
context.arc(center,center,150,0,2*Math.PI,false);
context.lineWidth = 0.5;
context.strokeStyle = "black";
context.stroke();


context.beginPath();
context.arc(center,center,120,0,2*Math.PI,false);
context.lineWidth = 0.5;
context.strokeStyle = "black";
context.stroke();

context.beginPath();
context.arc(center,center,90,0,2*Math.PI,false);
context.lineWidth = 0.5;
context.strokeStyle = "black";
context.stroke();


context.beginPath();
context.arc(center,center,60,0,2*Math.PI,false);
context.lineWidth = 0.5;
context.strokeStyle = "black";
context.stroke();

context.beginPath();
context.arc(center,center,30,0,2*Math.PI,false);
context.lineWidth = 0.5;
context.strokeStyle = "black";
context.stroke();




// 자기이해 라인 or 경력개발
context.beginPath();
context.moveTo(300,120);
context.lineTo(300,480);
context.lineWidth = 1;
context.strokeStyle = "black";
context.stroke();


// 맞춤취업 라인 or 진로결정
context.beginPath();
context.moveTo(480,300);
context.lineTo(120,300);
context.lineWidth = 1;
context.strokeStyle = "black";
context.stroke();



//구직활동 라인
context.beginPath();
context.moveTo(172,172);
context.lineTo(300,300);
context.lineWidth = 1;
context.strokeStyle = "black";
context.stroke();

//진로설계
context.beginPath();
context.moveTo(428,428);
context.lineTo(300,300);
context.lineWidth = 1;
context.strokeStyle = "black";
context.stroke();

//진로탐색
context.beginPath();
context.moveTo(428,172);
context.lineTo(300,300);
context.lineWidth = 1;
context.strokeStyle = "black";
context.stroke();

//실무역량
context.beginPath();
context.moveTo(172,428);
context.lineTo(300,300);
context.lineWidth = 1;
context.strokeStyle = "black";
context.stroke();



context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "20px arial"
context.strokeText("자기이해",260,100);

context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "20px arial"
context.strokeText("진로탐색",440,170);

context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "20px arial"
context.strokeText("진로결정",490,300);


context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "20px arial"
context.strokeText("진로설계",440,440);


context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "20px arial"
context.strokeText("경력개발",260,510);


context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "20px arial"
context.strokeText("실무역량",80,440);


context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "20px arial"
context.strokeText("맞춤취업",30,300);

context.strokeStyle = "blue";
context.lineWidth = 0.5;
context.font = "20px arial"
context.strokeText("구직활동",80,170);



var self_understanding_line   = 1 - (<%=graph_line.get(0)%>/100) ;   //자기이해 기준선
var career_search             = 1 - (<%=graph_line.get(1)%>/100);				//진로탐색 기준선
var career_decision_line      = 1 - (<%=graph_line.get(2)%>/100);		//진로결정 기준선
var career_design_line	      = 1 - (<%=graph_line.get(3)%>/100);		//진로설계 기준선
var career_development_line   = 1 - (<%=graph_line.get(4)%>/100);			//진로개발 기준선
var practical_competency_line = 1 - (<%=graph_line.get(5)%>/100);		//실무역량 기준선
var custom_emzier_line	      = 1 - (<%=graph_line.get(6)%>/100);			//맞춤취업 기준선
var job_search_line           = 1 - (<%=graph_line.get(7)%>/100);	 //구직활동 기준선


// 역량별 선그리기

var diagonal = 128;
var Straight = 180;

var arr = [];


var stat_x = 300;
var start_y = 120 + (Straight*self_understanding_line);

// 진로 탐색 = 대각선.128 xy축 (+x,-y)
arr[0] = 428 - (diagonal*career_search);
arr[1] = 172 + (diagonal*career_search);


// 진로 결정 = 직선.180 x축 (+x)
arr[2] = 480 - (Straight*career_search);
arr[3] = 300;

//  진로설계 = 대각선.128 xy축(+x,+y)
arr[4] = 428 - (diagonal*career_design_line);
arr[5] = 428 - (diagonal*career_design_line);


// 경력개발 = 직선 180 y축 (+y)
arr[6] = 300;
arr[7] = 480 - (Straight*career_development_line);

//실무역량 = 대각선.128 xy축 (-x,+y)
arr[8] = 172 + (diagonal*practical_competency_line);
arr[9] = 428 - (diagonal*practical_competency_line);


//맞춤취업 = 직선.180 x축(-x)
arr[10] = 120 + (Straight*custom_emzier_line);
arr[11] = 300;

//구직활동 = 대각선.128 xy축(-x,-y)
arr[12] = 172 + (diagonal*job_search_line);
arr[13] = 172 + (diagonal*job_search_line);



context.beginPath();
context.moveTo(stat_x,start_y); // 자기이해 100% y    = 300 ~ 120(100%)
context.lineTo(arr[0],arr[1]); // 진로탐색 
context.lineTo(arr[2],arr[3]); // 진로결정
context.lineTo(arr[4],arr[5]); // 진로설계
context.lineTo(arr[6],arr[7]); // 경력개발
context.lineTo(arr[8],arr[9]); // 실무역량
context.lineTo(arr[10],arr[11]); // 맞춤취업
context.lineTo(arr[12],arr[13]); // 구직활동
context.lineTo(stat_x,start_y); // 자기이해 연결
context.globalAlpha = 0.2;
context.fillStyle="#87CEEB"
context.fill();

context.lineWidth = 4;
context.strokeStyle="red";

context.stroke();






</script>
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