<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<!--  WYSIWYG-Text-Editor -->
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">

<link rel="apple-touch-icon"
	href="//mindmup.s3.amazonaws.com/lib/img/apple-touch-icon.png" />
<link rel="shortcut icon"
	href="http://mindmup.s3.amazonaws.com/lib/img/favicon.ico">
<link
	href="resource/bootstrap-wysiwyg-master/external/google-code-prettify/prettify.css"
	rel="stylesheet">
<link
	href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-responsive.min.css"
	rel="stylesheet">
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css"
	rel="stylesheet">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script
	src="resource/bootstrap-wysiwyg-master/external/jquery.hotkeys.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
<script
	src="resource/bootstrap-wysiwyg-master/external/google-code-prettify/prettify.js"></script>
<link href="resource/bootstrap-wysiwyg-master/index.css"
	rel="stylesheet">
<script src="resource/bootstrap-wysiwyg-master/bootstrap-wysiwyg.js"></script>

<script>
	function test() {
		$('#content').val(
				document.getElementById("comments-insert-body").innerHTML);
	}
	$(function() {
		function initToolbarBootstrapBindings() {
			var fonts = [ 'Serif', 'Sans', 'Arial', 'Arial Black', 'Courier',
					'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact',
					'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
					'Times New Roman', 'Verdana' ], fontTarget = $(
					'[title=Font]').siblings('.dropdown-menu');
			$
					.each(
							fonts,
							function(idx, fontName) {
								fontTarget
										.append($('<li><a data-edit="fontName ' + fontName +'" style="font-family:\''+ fontName +'\'">'
												+ fontName + '</a></li>'));
							});
			$('a[title]').tooltip({
				container : 'body'
			});
			$('.dropdown-menu input').click(function() {
				return false;
			}).change(
					function() {
						$(this).parent('.dropdown-menu').siblings(
								'.dropdown-toggle').dropdown('toggle');
					}).keydown('esc', function() {
				this.value = '';
				$(this).change();
			});

			$('[data-role=magic-overlay]').each(
					function() {
						var overlay = $(this), target = $(overlay
								.data('target'));
						overlay.css('opacity', 0).css('position', 'absolute')
								.offset(target.offset()).width(
										target.outerWidth()).height(
										target.outerHeight());
					});
			if ("onwebkitspeechchange" in document.createElement("input")) {
				var editorOffset = $('#editor').offset();
				$('#voiceBtn').css('position', 'absolute').offset({
					top : editorOffset.top,
					left : editorOffset.left + $('#editor').innerWidth() - 35
				});
			} else {
				$('#voiceBtn').hide();
			}
		}
		;
		function showErrorAlert(reason, detail) {
			var msg = '';
			if (reason === 'unsupported-file-type') {
				msg = "Unsupported format " + detail;
			} else {
				console.log("error uploading file", reason, detail);
			}
			$(
					'<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>'
							+ '<strong>File upload error</strong> '
							+ msg
							+ ' </div>').prependTo('#alerts');
		}
		;
		initToolbarBootstrapBindings();
		$('#editor').wysiwyg({
			fileUploadError : showErrorAlert
		});
		window.prettyPrint && prettyPrint();
		
	});
</script>

<style>
.controls {
	width: 100%;
	margin-top: 10px;
}

.control-label {
	width: 80px;
}

.input-xlarge {
	width: 80%;
}

.input-large {
	margin-right: 30px;
}

input[type=file] {
	display: inline;
}
</style>

</head>

<body>

	<%@ include file="nav.jsp"%>

	<br>

	<div class="container">
		<form class="form-group" action="" method="POST">
			<div class="hero-unit">
				<div id="legend" class="page-header">
					<h1 class="pull-left">${auction.title}</h1>
					<h1 class="pull-right">
						<small>
							조회수 ${auction.readCount} | 등록일 <fmt:formatDate value="${auction.postingDate }" type="both" dateStyle="short" timeStyle="short"/> | 
							종료일 <fmt:formatDate value="${auction.endDate }" type="both" dateStyle="short" timeStyle="short"/>
						</small>
					</h1>
					<div class="clearfix"></div>
				</div>

				<!---
		Please read this before copying the toolbar:

		* One of the best things about this widget is that it does not impose any styling on you, and that it allows you
		* to create a custom toolbar with the options and functions that are good for your particular use. This toolbar
		* is just an example - don't just copy it and force yourself to use the demo styling. Create your own. Read
		* this page to understand how to customise it:
	    * https://github.com/mindmup/bootstrap-wysiwyg/blob/master/README.md#customising-
		--->
				<div class="control-group">
					<div class="controls">
						<label class="control-label" for="startPrice" style="width: 60px;">시작가격</label>
						<input type="text" id="startPrice" class="input-large" disabled value="${auction.startPrice}">
						
						<label class="control-label" for="currentPrice" style="width: 60px;">현재가격</label>
						<c:choose>
							<c:when test="${not empty newestBid.bidPrice }">
								<input type="text" id="currentPrice" class="input-large" disabled value="${newestBid.bidPrice}"> 
							</c:when>
							<c:otherwise>
								<input type="text" id="currentPrice" class="input-large" disabled value="${auction.startPrice}"> 
							</c:otherwise>
						</c:choose>
							
						<label class="control-label" for="userid">아이디</label>
						<input type="text" id="item" class="input-large" disabled value="${auction.userId}">

						<label class="control-label" for="userid">판매여부</label>
						<c:choose>
							<c:when test="${auction.soldout == 1}">
								<input type="text" id="item" class="input-large" disabled
									value="판매완료">
							</c:when>
							<c:when test="${auction.soldout == 0}">
								<input type="text" id="item" class="input-large" disabled
									value="판매중">
							</c:when>
						</c:choose>
					</div>
				</div>

				<br>

				<!-- 		<textarea class="form-control" rows="10"> -->
				<div>
					<!-- 			<img src="upload/balloon.png"><br> -->
					${auction.content}
				</div>
				<!-- 		</textarea> -->
			</div>


		</form>

		<div class="control-group text-center">
			<!-- Button -->
			<div class="controls" align="right">
				<form action="bid.do" method="POST">
				<c:if test="${not empty sessionScope.id && auction.soldout == 0}">
					<label for="bidPrice">입찰가</label>
					<c:choose>
						<c:when test="${not empty newestBid.bidPrice }">
							<input type="text" id="bidPrice" name="bidPrice" class="input-large" value="${newestBid.bidPrice + minimunBidPrice}">
						</c:when>
						<c:otherwise>
							<input type="text" id="bidPrice" name="bidPrice" class="input-large" value="${auction.startPrice + minimunBidPrice}">
						</c:otherwise>
					</c:choose>

					<input type="hidden" id="auctionNo" name="auctionNo" value="${param.auctionNo }">
					<input type="hidden" id="page" name="page" value="${param.page }">
					<input type="hidden" id="search" name="search" value="${param.search }">

					<button type="button" class="btn btn-success" data-toggle="modal" data-target="#bidModal">입찰</button>
					<!-- 입찰 Dialog -->
					<div id="bidModal" class="modal fade" role="dialog" align="left">
					  <div class="modal-dialog">
					
					    <!-- Modal content-->
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal">&times;</button>
					        <h4 class="modal-title">입찰확인</h4>
					      </div>
					      <div class="modal-body">
					        <p>입찰하시겠습니까?</p>
					      </div>
					      <div class="modal-footer">
					        <button type="submit" class="btn btn-success">입찰</button>
					        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					      </div>
					    </div>
					
					  </div>
					</div>
				</c:if>
				<button type="button" id="bidInfo" name="bidInfo" class="btn btn-info" data-toggle="modal" data-target="#bidInfoModal">입찰정보</button>
				<a
					href="auctionList.do?page=${param.page }&search=${param.search }">
					<button type="button" class="btn btn-success">글 목록</button>
				</a>
				<c:if test="${sessionScope.id == auction.userId }">
					<a href="#">
						<button type="button" class="btn btn-success">글 수정</button>
					</a>
					<a href="#">
						<button type="button" class="btn btn-success">글 삭제</button>
					</a>
				</c:if>
				</form>
			</div>
		</div>

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
	
	<!-- 입찰정보 Dialog -->
	<div id="bidInfoModal" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">입찰정보</h4>
	      </div>
	      <div class="modal-body">
<!-- 	        <p>입찰 정보는 최근 10개만 표시됩니다.</p> -->
			<c:choose>
				<c:when test="${not empty bidList }">
			      	<table class="table table-hover table-condensed">
			      		<tr>
			      			<th>입찰회수</th>
			      			<th>입찰자</th>
			      			<th>입찰가</th>
			      			<th>입찰시간</th>
			      		</tr>
			      		<c:forEach var="bid" items="${bidList }" varStatus="status">
			      			<tr>
			      				<td>${bidList.size() - status.index }</td>
			      				<td>${bid.bidder }</td>
			      				<td>${bid.bidPrice }</td>
			      				<td>
					      			<fmt:formatDate value="${bid.bidDate }" type="both" dateStyle="short" timeStyle="short"/>
								</td>
			      			</tr>
			      		</c:forEach>
			      	</table>
				</c:when>
				<c:otherwise>
					<p>입찰정보가 없습니다.</p>
				</c:otherwise>
			</c:choose>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
	      </div>
	    </div>
	
	  </div>
	</div>

</body>

</html>
