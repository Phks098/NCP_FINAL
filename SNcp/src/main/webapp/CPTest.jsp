<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<form action="CPTest" method="post">
			<div class="contents">
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
							<c:forEach begin="1" end="5" varStatus="status">
								<td><input class="Scolar_Evauation" name="check_1"
									value="${status.index}" type="radio"></td>
							</c:forEach>
						</tr>
						<tr>

							<td>나는 내가 어떤 일을 좋아하는지 안다.</td>
							<c:forEach begin="1" end="5" varStatus="status">
								<td><input class="Scolar_Evauation" name="check_2"
									value="${status.index}" type="radio"></td>
							</c:forEach>


						</tr>
						<tr>
							<td>나는 내가 무엇을 잘 하는지 안다.</td>
							<c:forEach begin="1" end="5" varStatus="status">
								<td><input class="Scolar_Evauation" name="check_3"
									value="${status.index}" type="radio"></td>
							</c:forEach>


						</tr>
						<tr>
							<th>나는 내가 소중하게 생각하는 가치가 무엇인지 안다.</th>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_4"
									value="${status.index}" type="radio"></td>
							</c:forEach>


						</tr>
						<tr>
							<td>나는 내가 즐겁게 할 수 있는 일이 무엇인지 안다.</td>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_5"
									value="${status.index}" type="radio"></td>
							</c:forEach>


						</tr>
						<tr>
							<th rowspan="6">2.전공직업지식</th>
							<th>나는 내가 관심 있는 직업에서 하는 일과 필요한 능력에 대해 안다.</th>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_6"
									value="${status.index}" type="radio"></td>

							</c:forEach>

						</tr>
						<tr>
							<td>나는 내가 선택한 전공(학과)에 대해 잘 알고 있다.</td>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_7"
									value="${status.index}" type="radio"></td>

							</c:forEach>

						</tr>
						<tr>
							<th>나는 내가 관심 있는 직업의 향후 전망에 대해 안다.</th>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_8"
									value="${status.index}" type="radio"></td>
							</c:forEach>



						</tr>
						<tr>
							<td>나는 내가 관심 있는 직업에 대해 잘 알고 있다.</td>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_9"
									value="${status.index}" type="radio"></td>
							</c:forEach>


						</tr>
						<tr>
							<th>나는 나의 전공에 관련된 직업에 대하여 상세히 설명해 줄 수 있다</th>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_10"
									value="${status.index}" type="radio"></td>

							</c:forEach>

						</tr>
						<tr>
							<td>나는 내가 관심 있는 직업의 임금수준과 근무환경에 대해 안다.</td>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_11"
									value="${status.index}" type="radio"></td>

							</c:forEach>

						</tr>






						<tr>
							<th rowspan="5">3.진로결정</th>
							<td>나는 나의 진로를 결정했다.</td>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_12"
									value="${status.index}" type="radio"></td>

							</c:forEach>

						</tr>
						<tr>
							<th>나는 내가 결정한 진로에 대하여 당분간은 바꿀 생각이 없다.</th>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_13"
									value="${status.index}" type="radio"></td>


							</c:forEach>
						</tr>
						<tr>
							<td>나는 내가 결정한 진로에 대해 만족한다.</td>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_14"
									value="${status.index}" type="radio"></td>


							</c:forEach>
						</tr>
						<tr>
							<th>나는 타인들에게 내가 결정한 진로에 대해 말할 수 있다.</th>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_15"
									value="${status.index}" type="radio"></td>


							</c:forEach>
						</tr>

						<tr>
							<td>나는 내가 결정한 진로와 관련하여 구체적인 계획을 갖고 있다.</td>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_16"
									value="${status.index}" type="radio"></td>


							</c:forEach>
						</tr>

						<tr>
							<th rowspan="6">4.의사결정</th>
							<td>나는 나의 진로를 결정했다.</td>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_17"
									value="${status.index}" type="radio"></td>


							</c:forEach>
						</tr>
						<tr>
							<th>나는 내가 결정한 진로에 대하여 당분간은 바꿀 생각이 없다.</th>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_18"
									value="${status.index}" type="radio"></td>


							</c:forEach>
						</tr>
						<tr>
							<td>나는 내가 결정한 진로에 대해 만족한다.</td>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_19"
									value="${status.index}" type="radio"></td>
							</c:forEach>


						</tr>
						<tr>
							<th>나는 타인들에게 내가 결정한 진로에 대해 말할 수 있다.</th>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_20"
									value="${status.index}" type="radio"></td>


							</c:forEach>
						</tr>

						<tr>
							<td>나는 내가 결정한 진로와 관련하여 구체적인 계획을 갖고 있다.</td>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_21"
									value="${status.index}" type="radio"></td>


							</c:forEach>
						</tr>
						<tr>
							<th>나는 내가 결정한 진로에 대하여 당분간은 바꿀 생각이 없다.</th>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_22"
									value="${status.index}" type="radio"></td>


							</c:forEach>
						</tr>

						<tr>
							<th rowspan="6">5.관계활용</th>
							<td>나는 진로를 결정하는 과정에서 주변 사람들에게 도움을 달라고 요청할 수 있다.</td>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_23"
									value="${status.index}" type="radio"></td>

							</c:forEach>
						</tr>
						<tr>
							<th>나는 관심 갖고 있는 기업에 대한 정보를 대학의 취업관련 기관에 방문하여 알아 볼 수 있다.</th>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_24"
									value="${status.index}" type="radio"></td>

							</c:forEach>
						</tr>
						<tr>
							<td>나는 취업 기회에 대한 정보를 주변 사람들에게 요청하여 얻을 수 있다.</td>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_25"
									value="${status.index}" type="radio"></td>
							</c:forEach>
						</tr>
						<tr>
							<th>나는 채용과 관련된 의문이 있을 때 인사담당자에게 직접 문의할 수 있다.</th>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_26"
									value="${status.index}" type="radio"></td>

							</c:forEach>

						</tr>

						<tr>
							<td>나는 내가 어려움에 처했을 때 도와줄 수 있는 사람을 찾아 도움을 요청할 수 있다.</td>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_27"
									value="${status.index}" type="radio"></td>


							</c:forEach>
						</tr>
						<tr>
							<td>나는 취업을 위해 주변 사람들에게 도움을 요청할 수 있다.</td>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_28"
									value="${status.index}" type="radio"></td>


							</c:forEach>
						</tr>


						<tr>
							<th rowspan="7">6.구직준비도</th>
							<td>나는 진로를 결정하는 과정에서 주변 사람들에게 도움을 달라고 요청할 수 있다.</td>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_29"
									value="${status.index}" type="radio"></td>

							</c:forEach>

						</tr>
						<tr>
							<th>나는 관심 갖고 있는 기업에 대한 정보를 대학의 취업관련 기관에 방문하여 알아 볼 수 있다.</th>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_30"
									value="${status.index}" type="radio"></td>

							</c:forEach>

						</tr>
						<tr>
							<td>나는 취업 기회에 대한 정보를 주변 사람들에게 요청하여 얻을 수 있다.</td>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_31"
									value="${status.index}" type="radio"></td>

							</c:forEach>

						</tr>
						<tr>
							<th>나는 채용과 관련된 의문이 있을 때 인사담당자에게 직접 문의할 수 있다.</th>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_32"
									value="${status.index}" type="radio"></td>
							</c:forEach>


						</tr>

						<tr>
							<td>나는 내가 어려움에 처했을 때 도와줄 수 있는 사람을 찾아 도움을 요청할 수 있다.</td>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_33"
									value="${status.index}" type="radio"></td>
							</c:forEach>


						</tr>
						<tr>
							<td>나는 취업을 위해 주변 사람들에게 도움을 요청할 수 있다.</td>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><input class="Scolar_Evauation" name="check_34"
									value="${status.index}" type="radio"></td>

							</c:forEach>

						</tr>
						<tr>
							<td>나는 나의 이력서를 잘 작성할 수 있다.</td>

							<c:forEach begin="1" end="5" varStatus="status">

								<td><label><input class="Scolar_Evauation"
										name="check_35" value="${status.index}" type="radio"></label></td>
							</c:forEach>
						</tr>
					</table>
				</div>
				<div>
					<input style="width: 110px; height: 30px" type="submit" value="저장">
					<input style="width: 110px; height: 30px" type="button"
						onclick="exit()" value="취소">
				</div>
			</div>
		</form>
	</main>
</body>
</html>