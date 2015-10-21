<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index">중고(딩)나라</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<form action="list" class="navbar-form navbar-left" role="search">
				<div class="input-group">
					<input name="search" type="text" class="form-control pull-right"
						style="margin-right: 35px, border: 1px solid black;"
						placeholder="검색"> <span class="input-group-btn">
						<button type="submit" class="btn btn-default">
							<span class="glyphicon glyphicon-search"> <span
								class="sr-only">검색</span>
							</span>
						</button>
					</span>
				</div>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${sessionScope.id != null }">
						<li><a href="login?cmd=logout">로그아웃</a></li>
						<li><a href="write">판매등록</a></li>
						<li><a href="login?cmd=mypage">마이페이지</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="login">로그인</a></li>
						<li><a href="register">회원가입</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
			<!-- 		    	모바일 화면에서 보이는 메뉴 -->
			<ul class="nav navbar-nav visible-xs">
				<li><a href="list?categoryId=1">IT기기</a></li>
				<li><a href="list?categoryId=2">가전제품</a></li>
				<li><a href="list?categoryId=3">중고차</a></li>
				<li><a href="list?categoryId=4">취미</a></li>
				<li><a href="list?categoryId=5">의복</a></li>
			</ul>
		</div>
		<div class="collapse navbar-collapse">
			<!-- 	    		모바일 외의 화면에서 보이는 메뉴 -->
			<ul class="nav navbar-nav">
				<li><a href="list?categoryId=1">IT기기</a></li>
				<li><a href="list?categoryId=2">가전제품</a></li>
				<li><a href="list?categoryId=3">중고차</a></li>
				<li><a href="list?categoryId=4">취미</a></li>
				<li><a href="list?categoryId=5">의복</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>