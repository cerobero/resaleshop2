<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<!--  WYSIWYG-Text-Editor -->
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">

<link rel="apple-touch-icon"
	href="//mindmup.s3.amazonaws.com/lib/img/apple-touch-icon.png" />
<!-- <link rel="shortcut icon" -->
<!-- 	href="http://mindmup.s3.amazonaws.com/lib/img/favicon.ico"> -->
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

	window.onload=function timeck() {
// 		function timeck(){
		var startdate = "2015102822";
		var enddate = "2015110224";

		var now = new Date();

		year = now.getFullYear();
		month = now.getMonth() + 1;
		if ((month + "").length < 2) {
			month = "0" + month;
		}
		date = now.getDate();
		if ((date + "").length < 2) {
			date = "0" + date;
		}
		hour = now.getHours();
		if ((hour + "").length < 2) {
			hour = "0" + hour;
		}
		var today = year + "" + month + "" + date + "" + hour;
		console.log("today:"+today);
		if ((eval(today) >= eval(startdate)) && ((eval(today) <= eval(enddate)))) {
			$('#btn-tc').prop('disabled', false);
		}
	}
// 	timeck();
	
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

<c:if test="${empty sessionScope.id }">
	<script type="text/javascript">
 		alert("로그인 된 사용자만 볼 수 있습니다");
 		location.href="login.do";
 	</script>
	</c:if>
	
	<br>

	<div class="container">
		<form class="form-group" action="" method="POST">
			<div class="hero-unit">
				<div id="legend" class="page-header">
					<c:choose>
						<c:when test="${requestScope.itemArticle.premiume==1}">
							<h1 class="pull-left">[${requestScope.itemArticle.categoryName}]
								${requestScope.itemArticle.title}&nbsp;&nbsp;프리미엄 상품</h1>
						</c:when>
						<c:when test="${requestScope.itemArticle.premiume==0}">
							<h1 class="pull-left">[${requestScope.itemArticle.categoryName}]
								${requestScope.itemArticle.title}</h1>
						</c:when>
					</c:choose>
					<div align="center"><h1>중고(딩)나라 공동구매</h1></div>
				</div>

				<br>

				<!-- 		<textarea class="form-control" rows="10"> -->
				<div>
					<!-- 			<img src="upload/balloon.png"><br> -->
					${requestScope.itemArticle.content}
				</div>
				<!-- 		</textarea> -->
			</div>
		</form>

		<div class="control-group text-center">
			<!-- Button -->
			
		<div class="container">
            <div class="row">
                <div class="col-md-12">
               
               
<table class="table table-striped table-hover">
    <tr>
        <td width="350" rowspan="12"><img src="resource/img/stm.jpg"></td>
        <td width="97">제품명</td>
        <td width="460"><b>라온티앤아이 타무즈 스톤 X-10 게이밍 마우스</b></td>
    </tr>
    <tr>
        <td width="97">정가</td>
        <td width="460"><STRIKE>23,000</STRIKE> 원</td>
    </tr>
    <tr>
        <td width="97">특가</td>
        <td width="460"><span style="font-size:16pt;"><b>12,500</b></span> 원</td>
    </tr>
    <tr>
        <td width="97">수량</td>
        <td width="460">50 개</td>
    </tr>
    <tr>
        <td width="97">진행</td>
        <td width="460">2015/10/28/22:00:00 부터 ~ 2015/11/02/23:59:59 까지</td>
    </tr>
    <tr>
        <td width="97">배송비</td>
        <td width="460">무료 배송</td>
    </tr>
    <tr>
        <td width="97">발송일</td>
        <td width="460">입금확인후 순차배송 (1~2일 늦어질 수 있음)</td>
    </tr>
    <tr>
        <td width="97">주의</td>
        <td width="460">신청자는 보너스 20점 삭감됩니다.</td>
    </tr>
    <tr>
        <td width="97">신청수</td>
        <td width="460" >
        
<input type="hidden" name="xx" value="1" />
1개만 신청할 수 있습니다.
</td>
</tr>
    <tr>
        <td width="97">옵션</td>
        <td width="460">색상선택 가능</td>
    </tr>

    <tr>
        <td width="97">
				<button type='button'  id="btn-tc" class="btn btn-primary" disabled="disabled" onClick="location.href='gongu.do'">구매</button>
		</td>
		<td>구매 버튼은 공구 시작시간에 활성화 되어, 종료시간에 비활성화 됩니다</td>
		
        <td width="460" colspan="2">

</td>
    </tr>
<tr>
<td colspan="2">
<!-- <a href="winner.do">⊙ 신청자 기록 보기</a> -->
<%-- 	<c:forEach var="winner" items="${winnerList}"> --%>
<%-- <td>${winner.order_no}</td> --%>
<%-- <td>${winner.user_id}</td> --%>
<%--  	</c:forEach> --%>

<font color=red>*</font> 특가 재판매 관련<br>
<font color=red>*수령지 미기재 신청 안됨 / 자진취소자 3개월 / 가입제한 3일</font>
</td>
</tr>
</table>

<hr align="left">
* 중고(딩)나라 특가 진행은 별도의 수수료 없이 진행되는 특가입니다. <br>
* 중고(딩)나라는 회원분들에게 직접적으로 입금 받지 않습니다. 입금은 진행업체 계좌로 처리됩니다.<br>
* 입금관련, 현금영수증, 발송등의 내용은 진행업체쪽으로 문의 바랍니다. <br>
* 중고(딩)나라는 판매의 당사자가 아니며 상품 주문, 배송 및 환불의 의무와 책임은 각 진행업체에 있습니다.<br>
* 중고(딩)나라는 특가는 개인 회원만을 위한 특가 입니다. 사업자는 참여 할 수 없습니다.<br>
* 비정상적인 방법으로 특가 시도 및 신청시 해당 유저는 제재 또는 영구제재 처리됩니다. <br>
<hr><br><br>
						<div align="center">
							<h2>★ 공식 DB 리뷰 ★</h2>
							<br>
							<br>

							<h4>
								라온티앤아이 타무즈 스톤 X-10 게이밍 마우스 <br>
								http://prod.danawa.com/info/?pcode=3472265
							</h4>
							<h4>
								★ 리뷰 ★<br> ▶ 제목: 돌 굴러가유~ TAMMUZ STONE-X10 Mouse 리뷰<br>
								▶ 링크:
								http://www.coolenjoy.net/bbs/boardc.php?board=review&no=29093
							</h4>
						</div>
						<img src="resource/img/tm.jpg">
                    
                </div>
            </div>
        </div>

		<div class="container">
			<div class="row">
				<div class="col-md-12">
                  <div class="page-header">
                    <h1><small class="pull-right">${requestScope.commentList.size() }개의 댓글</small>댓글</h1>
                  </div> 
                   <div class="comments-list">
					<c:forEach var="comment" items="${requestScope.commentList }">                  
                       <div class="media">
                           <p class="pull-right"><small>${comment.comment_Date }</small></p>
                            <div class="media-body">
                                
                              <h4 class="media-heading user_name"><b>${comment.userId }</b></h4>
                              ${comment.content }
                            </div>
                          </div>
                    </c:forEach>
                   </div>
                   <br>
                   <c:if test="${not empty sessionScope.id }">
					<form action="itemInfo" method="post">
						<div class="comments-insert">
							<input type="hidden" id="categoryId" name="cateogryId" value="${param.categoryId }">
							<input type="hidden" id="page" name="page" value="${param.page}">
							<input type="hidden" id="search" name="search" value="${param.search}">
 							<input type="hidden" id="commentcontent" name="commentcontent">
							<input type="hidden" id="articleNo" name="articleNo" value="${requestScope.itemArticle.articleNo}">
							<input type="hidden" id="content" name="content">
							<input type="hidden" name="type" value="comment">
							<%-- 					  <input type="hidden" id="userId" name="userId" value="${requestScope.itemArticle.userId}"> --%>
							<p class="pull-right">
								<button type="submit" onclick="test()">댓글등록</button>
							</p>
							<div class="comments-insert-body" id="comments-insert-body"
								contenteditable="true"
								style="border: 1px solid gold; padding: 10px; height: 50px">
							</div>
						</div>
					</form>
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
