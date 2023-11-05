<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="data.vo.*"%>
<%@ page import="java.util.ArrayList"%>

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
<link rel="stylesheet" type="text/css" href="css/MyPage.css" />
<link rel="stylesheet" type="text/css" href="css/LoginPopup.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
	integrity="sha512-rqQltXRuHxtPWhktpAZxLHUVJ3Eombn3hvk9PHjV/N5DMUYnzKPC1i3ub0mEXgFzsaZNeJcoE0YHq0j/GFsdGg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://kit.fontawesome.com/46fda0e82e.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<%
	ArrayList<Matching_criteria_VO> match = (ArrayList) request.getAttribute("match");
	ArrayList<Professor_weight_VO> weight = (ArrayList) request.getAttribute("weight");
	ArrayList<Diagnosis_criteria_VO> level = (ArrayList) request.getAttribute("level");
	%>

	<jsp:include page="TopArea.jsp" />

	<main class="main_contents">
		<div class="contents">
			<section class="nav-contents">
				<div class="nav-inner">
					<ul class="nav-list">
						<li class="l-setting"><a class="btnSetting">관리 설정</a></li>
				</div>
			</section>
			<div class="contents-info show">
				<section class="section_marea">
				
					<form action="/Project_NCP/AdminMode?action=weightSet"
						method="post">
						<div class="info_text_area">
							<img
								src="https://semsplus.seowon.ac.kr/contents/images/client/sub/icon_tit_lg.png" />
							<h3 class="info_text">가중치 설정</h3>
						</div>


						<div class="base_info_table">
							<table>

								<colgroup>
									<col style="width: 25%;">
									<col style="width: 25%;">
									<col style="width: 50%;">
								</colgroup>

								<tbody>
									<tr>
										<th colspan="3">지도 교수 진로개발준비도 평가를 통합점수에 반영하기 위한 가중치 설정</th>
									</tr>
									<tr>
										<th>영역별 평가 척도 (수준)</th>
										<th>기존 가중치</th>
										<th>신규 가중치</th>
									</tr>
									<tr>
										<td>매우 그렇다(5점)</td>
										<td><input readonly="readonly" type="text"
											value=<%=weight.get(4).getWeight()%>></td>
										<td><input type="number" step="0.01"
											placeholder="신규 가중치를 입력하세요" onfocus="this.placeholder=''"
											onblur="this.placeholder='신규 가중치를 입력하세요' " name="setweight"></td>
									</tr>

									<tr>
										<td>그렇다(4점)</td>
										<td><input readonly="readonly" name="default_weight"
											type="text" value=<%=weight.get(3).getWeight()%>></td>
										<td><input type="number" step="0.01"
											placeholder="신규 가중치를 입력하세요" onfocus="this.placeholder=''"
											onblur="this.placeholder='신규 가중치를 입력하세요' " name="setweight"></td>
									</tr>

									<tr>
										<td>보통(3점)</td>
										<td><input readonly="readonly" name="default_weight"
											type="text" value=<%=weight.get(2).getWeight()%>></td>
										<td><input type="number" step="0.01"
											placeholder="신규 가중치를 입력하세요" onfocus="this.placeholder=''"
											onblur="this.placeholder='신규 가중치를 입력하세요' " name="setweight"></td>
									</tr>

									<tr>
										<td>그렇지 않다(2점)</td>
										<td><input readonly="readonly" name="default_weight"
											type="text" value=<%=weight.get(1).getWeight()%>></td>
										<td><input type="number" step="0.01"
											placeholder="신규 가중치를 입력하세요" onfocus="this.placeholder=''"
											onblur="this.placeholder='신규 가중치를 입력하세요' " name="setweight"></td>
									</tr>

									<tr>
										<td>매우 그렇지 않다(1점)</td>
										<td><input readonly="readonly" name="default_weight"
											type="text" value=<%=weight.get(0).getWeight()%>></td>
										<td><input type="number" step="0.01"
											placeholder="신규 가중치를 입력하세요" onfocus="this.placeholder=''"
											onblur="this.placeholder='신규 가중치를 입력하세요' " name="setweight"></td>
									</tr>

								</tbody>
							</table>
						</div>
						<div class="setBtnDiv">
							<input type="submit" class="level_saveBtn" value="저장"> <input
								type="submit" class="level_exitBtn" value="취소">
						</div>
					</form>
				</section>

				<section class="section_marea">
					<form action="/Project_NCP/AdminMode?action=matchSet" method="post">
						<div class="info_text_area">
							<img
								src="https://semsplus.seowon.ac.kr/contents/images/client/sub/icon_tit_lg.png" />
							<h3 class="info_text">매칭 비율 설정</h3>
						</div>
						<div class="match tbl_fixed match_row">
							<table>
								<colgroup>
									<col style="width: 20%;">
									<col style="width: 10%;">
									<col style="width: 10%;">
									<col style="width: 10%;">
									<col style="width: 10%;">
									<col style="width: 10%;">
									<col style="width: 10%;">
									<col style="width: 20%;">
								</colgroup>
								<tbody>
									<tr>
										<th colspan="8">진단영역-우리대학 진로취업 역량 매칭 비율 설정</th>
									</tr>
									<tr>
										<th></th>
										<th>자기이해</th>
										<th>전공직업정보</th>
										<th>진로<br>결정 확신도
										</th>
										<th>의사<br>결정 자신감
										</th>
										<th>관계 활용도</th>
										<th>구직 준비도</th>
										<th></th>
									</tr>
									<tr>
										<th>진로취업 역량 <br>(단계)
										</th>
										<th></th>
										<th></th>
										<th></th>
										<th></th>
										<th></th>
										<th></th>
										<th>합계</th>
									</tr>
									<tr>
										<th>자기이해</th>
										<%
										for (int i = 0; i <= 5; i++) {
										%>
										<td><input name="setMatch"
											value=<%=match.get(i).getMatching_rate()%>></td>
										<%
										}
										%>
										<td><%=(int) (match.get(0).getMatching_rate() + match.get(1).getMatching_rate() + match.get(2).getMatching_rate()
		+ match.get(3).getMatching_rate() + match.get(4).getMatching_rate() + match.get(5).getMatching_rate())%>%</td>
									</tr>

									<tr>
										<th>진로탐색</th>
										<%
										for (int i = 6; i <= 11; i++) {
										%>
										<td><input name="setMatch"
											value=<%=match.get(i).getMatching_rate()%>></td>
										<%
										}
										%>
										<td><%=(int) (match.get(6).getMatching_rate() + match.get(7).getMatching_rate() + match.get(8).getMatching_rate()
		+ match.get(9).getMatching_rate() + match.get(10).getMatching_rate() + match.get(11).getMatching_rate())%>%</td>
									</tr>

									<tr>
										<th>진로결정</th>
										<%
										for (int i = 12; i <= 17; i++) {
										%>
										<td><input name="setMatch"
											value=<%=match.get(i).getMatching_rate()%>></td>
										<%
										}
										%>
										<td><%=(int) (match.get(12).getMatching_rate() + match.get(13).getMatching_rate() + match.get(14).getMatching_rate()
		+ match.get(15).getMatching_rate() + match.get(16).getMatching_rate() + match.get(17).getMatching_rate())%>%</td>
									</tr>

									<tr>
										<th>진로설계</th>
										<%
										for (int i = 18; i <= 23; i++) {
										%>
										<td><input name="setMatch"
											value=<%=match.get(i).getMatching_rate()%>></td>
										<%
										}
										%>
										<td><%=(int) (match.get(18).getMatching_rate() + match.get(19).getMatching_rate() + match.get(20).getMatching_rate()
		+ match.get(21).getMatching_rate() + match.get(22).getMatching_rate() + match.get(23).getMatching_rate())%>%</td>
									</tr>

									<tr>
										<th>경력개발</th>
										<%
										for (int i = 24; i <= 29; i++) {
										%>
										<td><input name="setMatch"
											value=<%=match.get(i).getMatching_rate()%>></td>
										<%
										}
										%>
										<td><%=(int) (match.get(24).getMatching_rate() + match.get(25).getMatching_rate() + match.get(26).getMatching_rate()
		+ match.get(27).getMatching_rate() + match.get(28).getMatching_rate() + match.get(29).getMatching_rate())%>%</td>
									</tr>

									<tr>
										<th>실무역량</th>
										<%
										for (int i = 30; i <= 35; i++) {
										%>
										<td><input name="setMatch"
											value=<%=match.get(i).getMatching_rate()%>></td>
										<%
										}
										%>
										<td><%=(int) (match.get(30).getMatching_rate() + match.get(31).getMatching_rate() + match.get(32).getMatching_rate()
		+ match.get(33).getMatching_rate() + match.get(34).getMatching_rate() + match.get(35).getMatching_rate())%>%</td>
									</tr>

									<tr>
										<th>맞춤취업</th>
										<%
										for (int i = 36; i <= 41; i++) {
										%>
										<td><input name="setMatch"
											value=<%=match.get(i).getMatching_rate()%>></td>
										<%
										}
										%>
										<td><%=(int) (match.get(36).getMatching_rate() + match.get(37).getMatching_rate() + match.get(38).getMatching_rate()
		+ match.get(39).getMatching_rate() + match.get(40).getMatching_rate() + match.get(41).getMatching_rate())%>%</td>
									</tr>

									<tr>
										<th>구직활동</th>
										<%
										for (int i = 42; i <= 47; i++) {
										%>
										<td><input name="setMatch"
											value=<%=match.get(i).getMatching_rate()%>></td>
										<%
										}
										%>
										<td><%=(int) (match.get(42).getMatching_rate() + match.get(43).getMatching_rate() + match.get(44).getMatching_rate()
		+ match.get(45).getMatching_rate() + match.get(46).getMatching_rate() + match.get(47).getMatching_rate())%>%</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="setBtnDiv">
							<input type=submit class="level_saveBtn" value="저장"> <input
								type=submit class="level_exitBtn" value="취소">
						</div>
					</form>
				</section>


				<seciont>
				<form action="/Project_NCP/AdminMode?action=setLevel" method="post">
					<div class="match tbl_fixed match_row">
						<table>
							<tbody>
								<tr>
									<th colspan="8">우리대학 진로취업 역량별 준비수준 진단 기준 설정</th>
								</tr>
								<tr>

									<th rowspan="2">진로취업역량<br>(단계)
									</th>
									<th rowspan="2">최대점수</th>
									<th colspan="2">높음</th>

									<th colspan="2">보통</th>

									<th colspan="2">낮음</th>

								</tr>
								<tr>
									<th>최대</th>
									<th>최소</th>
									<th>최대</th>
									<th>최소</th>
									<th>최대</th>
									<th>최소</th>
								</tr>
								<tr>
									<th>자기이해</th>
									<td><%=level.get(0).getHigh_max()%></td>
									<td><input name="setLevel"
										value=<%=level.get(0).getHigh_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(0).getHigh_min()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(0).getNormal_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(0).getNormal_min()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(0).getLow_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(0).getLow_min()%>></td>
								</tr>

								<tr>
									<th>진로탐색</th>
									<td><%=level.get(1).getHigh_max()%></td>
									<td><input name="setLevel"
										value=<%=level.get(1).getHigh_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(1).getHigh_min()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(1).getNormal_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(1).getNormal_min()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(1).getLow_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(1).getLow_min()%>></td>
								</tr>

								<tr>
									<th>진로결정</th>
									<td><%=level.get(2).getHigh_max()%></td>
									<td><input name="setLevel"
										value=<%=level.get(2).getHigh_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(2).getHigh_min()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(2).getNormal_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(2).getNormal_min()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(2).getLow_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(2).getLow_min()%>></td>
								</tr>
								<tr>
									<th>진로설계</th>
									<td><%=level.get(3).getHigh_max()%></td>
									<td><input name="setLevel"
										value=<%=level.get(3).getHigh_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(3).getHigh_min()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(3).getNormal_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(3).getNormal_min()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(3).getLow_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(3).getLow_min()%>></td>
								</tr>

								<tr>
									<th>경력개발</th>
									<td><%=level.get(4).getHigh_max()%></td>
									<td><input name="setLevel"
										value=<%=level.get(4).getHigh_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(4).getHigh_min()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(4).getNormal_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(4).getNormal_min()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(4).getLow_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(4).getLow_min()%>></td>
								</tr>

								<tr>
									<th>실무역량</th>
									<td><%=level.get(5).getHigh_max()%></td>
									<td><input name="setLevel"
										value=<%=level.get(5).getHigh_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(5).getHigh_min()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(5).getNormal_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(5).getNormal_min()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(5).getLow_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(5).getLow_min()%>></td>
								</tr>
								<tr>
									<th>맞춤취업</th>
									<td><%=level.get(6).getHigh_max()%></td>
									<td><input name="setLevel"
										value=<%=level.get(6).getHigh_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(6).getHigh_min()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(6).getNormal_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(6).getNormal_min()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(6).getLow_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(6).getLow_min()%>></td>
								</tr>

								<tr>
									<th>구직활동</th>
									<td><%=level.get(7).getHigh_max()%></td>
									<td><input name="setLevel"
										value=<%=level.get(7).getHigh_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(7).getHigh_min()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(7).getNormal_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(7).getNormal_min()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(7).getLow_max()%>></td>
									<td><input name="setLevel"
										value=<%=level.get(7).getLow_min()%>></td>
								</tr>

							</tbody>
						</table>
					</div>
					<div class="setBtnDiv">
						<input type=submit class="level_saveBtn" value="저장"> <input
							type=button class="level_exitBtn" value="취소">
					</div>
				</form>
				</seciont>



			</div>
		</div>
	</main>
	<jsp:include page="SitemapPopup.jsp" />
	<jsp:include page="LoginPopup.jsp" />
	<script src="js/SitemapPopup.js"></script>
	<script src="js/LoginPopup.js"></script>
	<script src="js/MyPage.js"></script>
</body>
</html>