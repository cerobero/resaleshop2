<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		$('#c_content').val(
				document.getElementById("commentContent").innerHTML);
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
					<c:choose>
						<c:when test="${readArticle.premium==1}">
							<h1 class="pull-left">[${readArticle.categoryId}]
								${readArticle.title}&nbsp;&nbsp;프리미엄 상품</h1>
						</c:when>
						<c:when test="${readArticle.premium==0}">
							<h1 class="pull-left">[${readArticle.categoryId}]
								${readArticle.title}</h1>
						</c:when>
					</c:choose>
					<h1 class="pull-right">
						<small>조회수 ${readArticle.readCount}&nbsp;| 등록일
							${readArticle.postingDate}</small>
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
						<label class="control-label" for="price" style="width: 60px;">가격</label>
						<input type="text" id="price" class="input-large" disabled
							value="${readArticle.price}"> <label
							class="control-label" for="userid">아이디</label> <input type="text"
							id="item" class="input-large" disabled
							value="${readArticle.userId}"> <label
							class="control-label" for="userid">판매여부</label>
						<c:choose>
							<c:when test="${readArticle.soldout == 1}">
								<input type="text" id="item" class="input-large" disabled
									value="판매완료">
							</c:when>
							<c:when test="${readArticle.soldout == 0}">
								<input type="text" id="item" class="input-large" disabled
									value="판매중">
							</c:when>
						</c:choose>
					</div>
				</div>

				<br>

				<!-- 		<textarea class="form-control" rows="10"> -->
				<div>
					<img src="${readArticle.photo}"><br>
					${readArticle.content}
				</div>
				<!-- 		</textarea> -->
			</div>


		</form>

		<div class="control-group text-center">
			<!-- Button -->
			<!-- 이쪽은 아직 어떻게 할지 모르겠음 20151026 -->
			<div class="controls" align="right">
				<a href=""><button class="btn btn-success">구매</button></a> <a
					href="gonggu.do"><button class="btn btn-success">공동구매</button></a>
				<a
					href="list?view=${param.view }&categoryId=${param.categoryId }&page=${param.page }&search=${param.search }">
					<button class="btn btn-success">상품 목록</button>
				</a>

				<%-- <c:if test="${sessionScope.id == readArticle.userId }"> --%>
				<a href="a_update_form.do?articleNo=${readArticle.articleNo}">
					<button class="btn btn-success">글 수정</button>
				</a> <a href="a_delete.do?articleNo=${readArticle.articleNo }">
					<button class="btn btn-success">글 삭제</button>
				</a>
				<%-- </c:if> --%>
			</div>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-md-12"></div>
			</div>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="page-header">
						<h1>
							<small class="pull-right">${commentList.size()}개의 댓글</small>댓글
						</h1>
					</div>
					<div class="comments-list">
						<c:forEach var="comment" items="${commentList}">
							<div class="media">
								<p class="pull-right">
									<small>${comment.commentDate }</small>
								</p>
								<div class="media-body">

									<h4 class="media-heading user_name">
										<b>${comment.userId }</b>
									</h4>
									${comment.commentContent}
								</div>
								<div>
									 <a href="c_rewrite_form.do?commentNo=${comment.commentNo}">[댓글 고치기]</a>
									 <a href="c_delete.do?commentNo=${comment.commentNo}">[댓글 지우기]</a>
									</div>
							</div>
						</c:forEach>
					</div>
					<br>
					<c:if test="${not empty sessionScope.id }">
						<form action="c_write.do" method="post">
							<div class="comments-insert">
								<input type="hidden" id="c_content" name="commentContent">
								<input type="hidden" id="articleNo" name="articleNo"
									value="${readArticle.articleNo}"> <input type="hidden"
									id="UserId" name="UserId" value="${sessionScope.id}">
								<%-- 							<input type="hidden" name="commentDate" value="commentDate" value="${comment.commentDate}"> --%>
								<%--  <input type="hidden" id="userId" name="userId" value="${comment.UserId}">  --%>
								<p class="pull-right">
									<button onclick="test()">댓글등록</button>
								</p>
								<div class="comments-insert-body" id="commentContent"
									contenteditable="true"
									style="border: 1px solid gold; padding: 10px; height: 50px">
								</div>
							</div>
						</form>
					</c:if>

					<c:if test="${readArticle.faultyCheck>0}">
						<div>
							<h2>불량신고가 있는 상품입니다!</h2>
							<a href="f_list">[불량신고 보러 가기]</a>
						</div>
					</c:if>

				</div>
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

</body>

</html>
