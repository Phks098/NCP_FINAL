<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="data.dao.*"%>
<%@ page import="data.vo.*"%>
<%@ page import="java.util.ArrayList"%>

<%
MyPage_DAO2 dao = new MyPage_DAO2();
Student_VO stu = new Student_VO();

ArrayList<Education_Reasult_VO> educationList = new ArrayList<Education_Reasult_VO>();
educationList = (ArrayList<Education_Reasult_VO>) request.getAttribute("educationList");
Student_VO student = (Student_VO) request.getAttribute("student");
ArrayList<Mypage_VO> data = (ArrayList<Mypage_VO>) request.getAttribute("level");


ArrayList<Integer> graph_line = new ArrayList<Integer>();


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

<body>
	<jsp:include page="TopArea.jsp" />
	<main class="main_contents">
		<div class="contents">

			<section class="nav-contents">
				<div class="nav-inner">
					<ul class="nav-list">
						<li class="l-info select-list"><a class="btnInfo">정보</a></li>
					</ul>
				</div>

				<div class="contents-info show">
					<section class="section_marea">
						<div class="info_text_area">
							<img
								src="https://semsplus.seowon.ac.kr/contents/images/client/sub/icon_tit_lg.png" />
							<h3 class="info_text">기본 정보</h3>
						</div>


						<!-- 학생 기본 정보 출력 -->
						<div class="base_info_table">
							<table>
								<tbody>
									<tr>
										<th>단과대학</th>
										<td>사범대학</td>
										<th>소속</th>
										<td><%=student.getMajor()%></td>
									</tr>
									<tr>
										<th>부/복수/연계/융합전공</th>
										<td></td>
										<th>학년</th>
										<td><%=student.getGrade()%></td>
									</tr>
									<tr>
										<th>학번</th>
										<td><%=student.getUniversity_number()%></td>
										<th>이름</th>
										<td><%=student.getName()%>(<%=student.getSex()%>)</td>
									</tr>
								</tbody>
							</table>


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
								if (!data.isEmpty()) {
									for (int i = 0; i < 8; i++) {
										graph_line.add(data.get(i).getPreparation_degree());
								%>
								<tr>
									<th><%=data.get(i).getCategory_name()%></th>
									<td><%=data.get(i).getCategory_score()%></td>
									<td><%=data.get(i).getPreparation_degree()%>%</td>
									<td><%=data.get(i).getPrearation_level()%></td>
									<td><%=data.get(i).getPreparation_rank()%></td>
								</tr>
								<%
								}
								} else {

								for (int i = 0; i < 8; i++) {
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
						</div>
						<br>

						<!-- 학생 기본정보 및 역량 결과 (끝) -->


						




						<!-- 역량 그래프 요소 -->
						<div class="canvas_graph">
							<canvas id="myCanvas" style="background-color: aliceblue"
								width="600px" height="600px">			
						</canvas>

						</div>
						<!-- 역량 그래프 요소 (끝) -->







					</section>
				</div>
				<!-- contents-info show/학생 기본 정보 및 역량 평가 출력 div-->




			</section>
		</div>
	</main>


	<script type="text/javascript">


var canvas = document.getElementById("myCanvas");
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



var self_understanding_line   = 1 - (<%=graph_line.get(0)%>/100) ;  //자기이해 기준선
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


	<jsp:include page="SitemapPopup.jsp" />
	<jsp:include page="LoginPopup.jsp" />
	<script src="js/SitemapPopup.js"></script>
	<script src="js/LoginPopup.js"></script>
	<script src="js/Prototype_Js.js"></script>
	<script src="js/Scholar_Evaluation.js"></script>
	<!-- 	<script src="js/Canvas_graph.js"></script> -->


</body>
</html>
