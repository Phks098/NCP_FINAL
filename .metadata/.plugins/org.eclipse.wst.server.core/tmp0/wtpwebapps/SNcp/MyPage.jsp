<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setCharacterEncoding("utf-8");
%>

<%@ page import="rlogic.Rlogic"%>
<%@ page import="java.util.Vector"%>
<%@ page import="data.RecommendationResult"%>

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
	<jsp:include page="TopArea.jsp" />

	<main class="main_contents">
		<div class="contents">
			<section class="nav-contents">
				<div class="nav-inner">
					<ul class="nav-list">
						<li class="l-info select-list"><a class="btnInfo">정보</a></li>
						<li class="l-setting"><a class="btnSetting">설정</a></li>
					</ul>
				</div>
			</section>
			<div class="contents-info show">
				<section class="section_marea">
					<div class="info_text_area">
						<img
							src="https://semsplus.seowon.ac.kr/contents/images/client/sub/icon_tit_lg.png" />
						<h3 class="info_text">기본 정보</h3>
					</div>

					<div class="base_info_table">
						<table>
							<tbody>
								<tr>
									<th>단과대학</th>
									<td>미디어융합대학</td>
									<th>소속</th>
									<td>${student.major }</td>
								</tr>
								<tr>
									<th>부/복수/연계/융합전공</th>
									<td></td>
									<th>학년</th>
									<td>${student.grade }학년</td>
								</tr>
								<tr>
									<th>학번</th>
									<td>${student.university_number }</td>
									<th>이름</th>
									<td>${student.name }</td>
								</tr>
								<tr>
									<th>연락처</th>
									<td>010-3099-6707</td>
									<th>이메일</th>
									<td>juke2391@gmail.com</td>
								</tr>
								<tr>
									<th>주소</th>
									<td colspan="3">충청북도 청주시 흥덕구 덕암로108번길 44</td>
								</tr>
							</tbody>
						</table>
					</div>
				</section>


				<section class="section_marea">
					<div class="recommendation_result_area">
						<div class="info_text_area">
							<img
								src="https://semsplus.seowon.ac.kr/contents/images/client/sub/icon_tit_lg.png" />
							<h3 class="info_text">진단 결과</h3>
						</div>
						<div class="base_info_table">

							<table>
								<tr>
									<th colspan="6">진단 결과</th>
								</tr>
								<tr>
									<th>진단역량</th>
									<th>백분율</th>
									<th>준비수준</th>
									<th>순위</th>
									<th>역량 평가</th>
								</tr>

								<c:choose>
									<c:when test="${not empty preLevels}">
										<c:forEach items="${preLevels}" var="preLevels">
											<tr>
												<c:if test="${preLevels.preparation_rank eq 1}">
													<th class="level_category">${preLevels.capability_category}</th>

													<td class="level_score">${preLevels.preparation_degree}%</td>
													<td><c:out value="${preLevels.preparation_level}"></c:out></td>
													<td>${preLevels.preparation_rank}</td>
													<td rowspan="8"><div class="canvas_graph">
															<canvas id="myCanvas" style="background-color: aliceblue"
																width="380px" height="380px">			
															</canvas>

														</div></td>
												</c:if>
												<c:if test="${preLevels.preparation_rank != 1 }">
													<th class="level_category">${preLevels.capability_category}</th>
													<td class="level_score"><c:out
															value="${preLevels.preparation_degree }" />%</td>
													<td>${preLevels.preparation_level}</td>
													<td>${preLevels.preparation_rank}</td>
												</c:if>
											</tr>

										</c:forEach>

									</c:when>
									<c:otherwise>
										<tr>
											<th>자기이해</th>

											<td colspan="4" rowspan="8" style="font-size: 20px;">진로개발진비도
												검사를 진행해주세요</td>
											<td rowspan="8"><div class="canvas_graph">
													<canvas id="myCanvas" style="background-color: aliceblue"
														width="380px" height="380px">			
															</canvas>

												</div></td>

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


									</c:otherwise>
								</c:choose>



							</table>

						</div>

					</div>
				</section>















				<section class="section_area">
					<div class="recommendation_result_area">
						<div class="info_text_area">
							<img
								src="https://semsplus.seowon.ac.kr/contents/images/client/sub/icon_tit_lg.png" />
							<h3 class="info_text">비교과 프로그램 추천 목록</h3>
						</div>

						<c:forEach items="${results}" var="results" varStatus="status">
							<div class="recommendation_result_table_area">

								<h4>
									<strong><c:out value="${status.count }" />. </strong>
									<c:choose>
										<c:when
											test="${preLevelsDesc[status.index].capability_category == 1}">자기이해</c:when>
										<c:when
											test="${preLevelsDesc[status.index].capability_category == 2}">진로탐색</c:when>
										<c:when
											test="${preLevelsDesc[status.index].capability_category == 3}">진로결정</c:when>
										<c:when
											test="${preLevelsDesc[status.index].capability_category == 4}">진로설계</c:when>
										<c:when
											test="${preLevelsDesc[status.index].capability_category == 5}">경력개발</c:when>
										<c:when
											test="${preLevelsDesc[status.index].capability_category == 6}">실무역량</c:when>
											<c:when
											test="${preLevelsDesc[status.index].capability_category == 7}">실무역량</c:when>
											<c:when
											test="${preLevelsDesc[status.index].capability_category == 8}">구직활동</c:when>
										
									</c:choose>
									) 준비도:
									<c:out
										value="${preLevelsDesc[status.index].preparation_degree }" />
									%
								</h4>
								<div class="recommendation_result">
									<table>
										<tbody>
											<tr>
												<th rowspan="2">프로그램 코드</th>
												<th colspan="2">프로그램 단계</th>
												<th colspan="3">프로그램 세부내용</th>
												<th rowspan="2">운영 상황</th>
												<th rowspan="2">최종 적합도</th>
											</tr>
											<tr>
												<th>대분류</th>
												<th>중분류</th>
												<th>프로그램명</th>
												<th>운영기간</th>
												<th>이수시간</th>
											</tr>
											<c:forEach items="${results }" var="result">
												<tr>
													<td><c:out value="${result.code}" /></td>
													<td><c:out value="${result.category_large_name}" /></td>
													<td><c:out value="${result.category_middle_name }" /></td>
													<td><c:out value="${result.program_name }" /></td>
													<td><c:out value="${result.day }" /></td>
													<td><c:out value="${result.completation_time }" /></td>
													<td><c:out value="${result.operating_state_name }" /></td>
													<td><c:out value="${result.recommendation_degree }" />
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
						</c:forEach>
					</div>
				</section>


			</div>
			<div class="contents-setting">
				<section class="preferenceInformation-area">
					<div class="info_text_area">
						<img
							src="https://semsplus.seowon.ac.kr/contents/images/client/sub/icon_tit_lg.png" />
						<h3 class="info_text">비교과 프로그램 선호 조건 설정</h3>
					</div>
					<div class="table-area">
						<table>
							<tbody>
								<tr>
									<th>희망 직무</th>
									<td><select id="ncs">
											<c:forEach items="${ncsList}" var="ncs">
												<option value="${ncs.code }">
													<c:out value="${ncs.category_name } " />
												</option>
											</c:forEach>
									</select></td>
									<th>희망 운영방식</th>
									<td><select id="operatingMethod">
											<c:forEach items="${operatingMethodList}"
												var="operatingMethod">
												<option value="${operatingMethod.code}">
													<c:out value="${operatingMethod.category_name} " />
												</option>
											</c:forEach>
									</select></td>
								</tr>
								<tr>
									<th>참여 희망<br>교육 시간
									</th>
									<td colspan="3"><input id="start_day" type="date"
										name="start_day" /> 부터 <input id="end_day" type="date"
										name="end_day" /> 까지</td>
								</tr>
							</tbody>
						</table>
						<input type="hidden" id="universityNumber"
							value="${student.university_number }" />
						<div class="btnArea">
							<input type="submit" id="btnRegister" class="btnRegister"
								value="등록" onclick="updatePreferenceInformation();" />
						</div>
					</div>
				</section>
			</div>
		</div>
	</main>

	<jsp:include page="SitemapPopup.jsp" />
	<jsp:include page="LoginPopup.jsp" />

	<script src="js/SitemapPopup.js"></script>
	<script src="js/LoginPopup.js"></script>
	<script src="js/MyPage.js"></script>
	<script src="js/Competency_graph.js"></script>
</body>
</html>
