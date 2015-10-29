<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="vo.ArticlePage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

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
<script src="resource/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="resource/js/bootstrap.min.js"></script>

</head>

<body>

	<%@ include file="nav.jsp"%>

	<br>

	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					최신 등록상품! <small><a href="list?view=">더보기</a></small>
				</h1>
			</div>
		</div>
		<c:if test="${allNewPage.articleList.size() > 0 }">
			<div class="row">
				<c:forEach var="article" items="${allNewPage.articleList}" begin="0"
					end="${allNewPage.articleList.size()  }">
					<div class="col-md-3 portfolio-item">
						<a href="read&articleNo=${article.articleNo}"> <img
							class="img-responsive" src="${article.photo}" alt="">
						</a>
						<h4>
							<a href="read&articleNo=${article.articleNo}">${article.title}</a>
						</h4>
						<p>${article.content}</p>
					</div>
					<c:if test="${article.faultyCheck>0}">
						<div>불량신고가 있는 상품입니다!</div>
					</c:if>
				</c:forEach>
			</div>
		</c:if>

		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Hot! 등록상품 <small><a href="list?view=hot">더보기</a></small>
				</h1>
			</div>
		</div>


		<c:if test="${hotNewPage.articleList.size() > 0 }">
			<div class="row">
				<c:forEach var="article" items="${hotNewPage.articleList }"
					begin="0" end="${hotNewPage.articleList.size() }">
					<div class="col-md-3 portfolio-item">
						<a href="read&articleNo=${article.articleNo}"> <img
							class="img-responsive" src="${article.photo}" alt="">
						</a>
						<h4>
							<a href="read&articleNo=${article.articleNo}">${article.title}</a>
						</h4>
						<p>${article.content}</p>
						<c:if test="${article.faultyCheck>0}">
							<div>불량신고가 있는 상품입니다!</div>
						</c:if>
					</div>
				</c:forEach>
			</div>
		</c:if>


		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					프리미엄 등록상품 <small><a href="list?view=premium">더 보기</a></small>
				</h1>
			</div>
		</div>

		<c:if test="${premiumNewPage.articleList.size() > 0 }">
			<div class="row">
				<c:forEach var="article" items="${premiumNewPage.articleList}"
					begin="0" end="${premiumNewPage.articleList.size()  }">
					<div class="col-md-3 portfolio-item">
						<a href="read&articleNo=${article.articleNo}"> <img
							class="img-responsive" src="${article.photo}" alt="">
						</a>
						<h4>
							<a href="read&articleNo=${article.articleNo}">${article.title}</a>
						</h4>
						<p>${article.content}</p>
						<c:if test="${article.faultyCheck>0}">
							<div>불량신고가 있는 상품입니다!</div>
						</c:if>
					</div>
				</c:forEach>
			</div>
		</c:if>


		<hr>
		<div class="row">
			<div class="col-lg-12">
				<h3 class="page-header">
					<a href="">젊은 우리의 특별 관심상품!</a>
				</h3>
			</div>
			<div class="col-lg-12">
				<h3 class="page-header">
					<a href="">아이들은 가라! 중년들을 위한 특별 관심상품!</a>
				</h3>
			</div>
			<div class="col-lg-12">
				<h3 class="page-header">
					<a href="">지금이 청춘인 어르신들을 위한 특별 관심상품 </a>
				</h3>
			</div>
		</div>
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
