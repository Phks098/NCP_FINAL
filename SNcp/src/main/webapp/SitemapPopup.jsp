<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="sitemap_popup">
	<div class="sitemap_popup_body">
		<div class="sitemap_wrapper">
			<section class="sitemap_header">
				<h2>전체메뉴</h2>
				<a class="sitemap_close"></a>
			</section>
			<section class="sitemap_content">
				<div class="sitemap_inner">
					<div class="sitemap_list sitemap_list1">
						<h2>SEMS+ 안내</h2>
						<ul>
							<li><a href="">SEMS+ 소개</a></li>
							<li><a href="">역량기반 교육체계</a></li>
							<li><a href="">CUKI 마일리지</a></li>
						</ul>
					</div>
					<div class="sitemap_list sitemap_list2">
						<h2>역량기반교과</h2>
						<ul>
							<li><a href="">교과 정보 조회</a></li>
							<li><a href="">통합역량성취도 조회</a></li>
						</ul>
					</div>
					<div class="sitemap_list sitemap_list3">
						<h2>CUKI비교과</h2>
						<ul>
							<li><a href="">비교과 프로그램 신청</a></li>
							<li><a href="">비교과 프로그램 내역</a></li>
							<li><a href="">자기주도활동</a></li>
						</ul>
					</div>
					<div class="sitemap_list sitemap_list4">
						<h2>상담</h2>
						<ul>
							<li><a href="">사제동행상담</a></li>
							<li><a href="">심리상담</a></li>
							<li><a href="">진로 및 취·창업상담</a></li>
							<li><a href="">학습상담</a></li>
							<li><a href="">나의 상담 내역</a></li>
							<li><a href="">성고충상담 안내</a></li>
						</ul>
					</div>
					<div class="sitemap_list sitemap_list5">
						<h2>진로/취업</h2>
						<ul>
							<li><a href="">진로 설계</a></li>
							<li><a href="">진로 디자인맵 조회</a></li>
							<li><a href="">취업 정보</a></li>
							<li><a href="">채용 정보</a></li>
							<li><a href="">멘토링 프로그램</a></li>
							<li><a href="">취업 지원 프로그램</a></li>
							<li><a href="">취업 커뮤니티</a></li>
						</ul>
					</div>
					<div class="sitemap_list sitemap_list6">
						<h2>설문/진단</h2>
						<ul>
							<li><a href="">전공역량 진단</a></li>
							<li><a href="CPTest.jsp">진로개발준비도 검사</a></li>
							
						</ul>
					</div>
					<div class="sitemap_list sitemap_list7">
						<h2>인증</h2>
						<ul>
							<li><a href="">내 역량 현황</a></li>
							<li><a href="">내 인증 현황</a></li>
						</ul>
					</div>
					<div class="sitemap_list sitemap_list8">
						<h2>커뮤니티</h2>
						<ul>
							<li><a href="">공지사항</a></li>
							<li><a href="">갤러리</a></li>
							<li><a href="">자료실</a></li>
							<li><a href="">FAQ</a></li>
							<li><a href="">쪽지</a></li>
						</ul>
					</div>
					<!-- 학생 접속 -->
					<c:if test="${cookie.power.value eq '3' }">
						<div class="sitemap_list sitemap_list9">
							<h2>마이페이지</h2>
							<ul>
								<li><a href="mypage">마이페이지</a></li>
								<li><a href="">포트폴리오</a></li>
							</ul>
						</div>
					</c:if>
					<!-- 교수 접속 -->
					<c:if test="${cookie.power.value eq '2' }">
						<div class="sitemap_list sitemap_list10">
							<h2>교수</h2>
							<ul>
								<li><a href="Professor_Search_Student.jsp">학생정보 조회</a></li>
							</ul>
						</div>
					</c:if>
					<!-- 직원 접속 -->
					<c:if test="${cookie.power.value eq '1' }">
						<div class="sitemap_list sitemap_list11">
							<h2>관리자</h2>
							<ul>
								<li><a href="ProgramManagement.jsp">비교과 프로그램<br />관리
								</a></li>
								<li><a href="Admin_mode.jsp">역량 평가 설정<br />관리
								</a></li>
							</ul>
						</div>
					</c:if>
					<!-- 슈퍼 유저 접속 -->
					<c:if test="${cookie.power.value eq '0' }">
						<div class="sitemap_list sitemap_list9">
							<h2>마이페이지</h2>
							<ul>
								<li><a href="mypage">마이페이지</a></li>
								<li><a href="">포트폴리오</a></li>
							</ul>
						</div>
						<div class="sitemap_list sitemap_list10">
							<h2>교수</h2>
							<ul>
								<li><a href="StudentManagement.jsp">학생정보 조회</a></li>
								
							</ul>
						</div>
						<div class="sitemap_list sitemap_list11">
							<h2>관리자</h2>
							<ul>
								<li><a href="ProgramManagement.jsp">비교과 프로그램<br />관리
								</a></li>
							</ul>
						</div>
					</c:if>

				</div>
			</section>
		</div>
	</div>
</div>