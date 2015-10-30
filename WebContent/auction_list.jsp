<%@page import="vo.ArticlePage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>중고(딩)나라</title>

<!-- Bootstrap Core CSS -->
<link href="resource/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resource/css/3-col-portfolio.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<!-- jQuery -->
<script src="resource/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="resource/js/bootstrap.min.js"></script>

<style>
.abbreviation {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}
</style>
</head>

<body>

	<%@ include file="nav.jsp"%>

	<br>

	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header" style="display:inline-block">
					경매 상품
				</h1>
				<a href="auctionWrite.do"><button type="button" class="btn btn-primary" style="margin-left: 30px">경매등록</button></a>
			</div>
		</div>
		<!-- /.row -->

		<c:if test="${somePage.pageArticleCount > 0 }">
			<div class="row">
				<c:forEach var="auction"
					items="${somePage.list }" begin="0"
					end="${somePage.pageArticleCount > 4 ? 4 - 1 : somePage.pageArticleCount }">
					<div class="col-md-3 portfolio-item">
						<a href="#"> <img class="img-responsive"
							src="${auction.photo }" alt="">
						</a>
						<h3>
							<a class="abbreviation"
								href="auction.do?auctionNo=${auction.auctionNo }&page=${param.page }&search=${param.search }">${auction.title }</a>
						</h3>
						<p class="abbreviation">
							${auction.content }
						</p>
					</div>
				</c:forEach>
			</div>
		</c:if>
		<c:if test="${somePage.pageArticleCount > 4 }">
			<div class="row">
				<c:forEach var="auction"
					items="${somePage.list }" begin="4"
					end="${somePage.pageArticleCount - 1 }">
					<div class="col-md-3 portfolio-item">
						<a href="#"> <img class="img-responsive"
							src="${auction.photo }" alt="">
						</a>
						<h3>
							<a class="abbreviation"
								href="auction.do?auctionNo=${auction.auctionNo }&page=${param.page }&search=${param.search }">${auction.title }</a>
						</h3>
						<p class="abbreviation">${auction.content }</p>
					</div>
				</c:forEach>
			</div>
		</c:if>

		<!-- Pagination -->
		<c:if test="${somePage.articleCount > 0 }">
			<div class="row text-center">
				<div class="col-lg-12">
					<ul class="pagination">
						<c:if
							test="${somePage.currentPage != somePage.startPage }">
							<li><a
								href="auctionList.do?page=${somePage.currentPage - 1 }&search=${param.search }">&laquo;</a>
							</li>
						</c:if>
						<c:forEach var="num"
							begin="${somePage.startPage }"
							end="${somePage.endPage }" varStatus="status">
							<c:choose>
								<c:when test="${somePage.currentPage == num }">
									<li><a class="btn-primary active disabled"
										href="auctionList.do?page=${num }&search=${param.search }">${num }</a>
									</li>
								</c:when>
								<c:otherwise>
									<li><a
										href="auctionList.do?page=${num }&search=${param.search }">${num }</a>
									</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if
							test="${somePage.currentPage != somePage.endPage }">
							<li><a
								href="auctionList.do?page=${somePage.currentPage + 1 }&search=${param.search }">&raquo;</a>
							</li>
						</c:if>
					</ul>
				</div>
			</div>
		</c:if>

			<div class="row">
				<form class="input-form" role="search" action="auctionList.do" method="get">
					<div class="col-lg-4 col-lg-offset-4">
						<div class="input-group">
							<input name="search" type="text" class="form-control"
								style="margin-right: 35px, border: 1px solid black;"
								placeholder="글제목 검색"><span
								class="input-group-btn">
								<button type="submit" class="btn btn-default">
									<span class="glyphicon glyphicon-search"> <span
										class="sr-only">검색</span>
									</span>
								</button>
							</span>
						</div>
					</div>
				</form>
			</div>
			<!-- /.row -->

			<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Your Website 2014</p>
				</div>
			</div>
			<!-- /.row -->
		</footer>

	</div>
	<!-- /.container -->

</body>

</html>
