<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
</head>

<body>
	
	<%@ include file="nav.jsp" %>

    <br>
    
    <!--  Register form -->
    <div class="container">
	    <form class="form-horizontal" action="register" method="POST" name="submitForm">
		  <fieldset>
		    <div id="legend">
		      <h1 class="page-header">회원가입</h1>
		    </div>
		    <div class="control-group">
		      <!-- userid -->
		      <label class="control-label"  for="userId">아이디</label>
		      <div class="controls">
		        <input type="text" id="userId" name="userId" placeholder="" class="input-xlarge" pattern="^[A-Za-z]{1}[A-Za-z0-9]{3,11}$" title="띄어쓰기 없이 영문과 숫자를 혼합하여 4~12자를 사용할 수 있습니다." required>
		        <p class="help-block">띄어쓰기 없이 영문과 숫자를 혼합하여 4~12자를 사용할 수 있습니다.</p>
		      </div>
		    </div>
		 
		    <div class="control-group">
		      <!-- Password-->
		      <label class="control-label" for="userPw">비밀번호</label>
		      <div class="controls">
		        <input type="password" id="userPw" name="userPw" placeholder="" class="input-xlarge" pattern="^[A-Za-z0-9]{4,20}$" title="최소한 4자 이상을 사용해 주세요." required>
		        <p class="help-block">최소한 4자 이상을 사용해 주세요.</p>
		      </div>
		    </div>
		 
		    <div class="control-group">
		      <!-- Username -->
		      <label class="control-label" for="userName">이름</label>
		      <div class="controls">
		        <input type="text" id="userName" name="userName" placeholder="" class="input-xlarge" pattern="^[ㄱ-ㅎㅏ-ㅣ가-힣]{3,4}$" title="이름을 입력해주세요." required>
		        <p class="help-block">이름을 입력해주세요.</p>
		      </div>
		    </div>
		 
		    <div class="control-group">
		      <!-- Userphone -->
		      <label class="control-label" for="userPhone">휴대폰 번호</label>
		      <div class="controls">
		        <input type="text" id="userPhone" name="userPhone" placeholder="" class="input-xlarge" pattern="^01(?:0|1[6-9])\-(?:\d{3}|\d{4})\-\d{4}$" title="휴대폰 번호를 입력해주세요." required>
		        <p class="help-block">휴대폰 번호를 입력해주세요.</p>
		      </div>
		    </div>
		 
		    <div class="control-group">
		      <!-- Username -->
		      <label class="control-label" for="userEmail">이메일</label>
		      <div class="controls">
		        <input type="text" id="userEmail" name="userEmail" placeholder="" class="input-xlarge" pattern="^[a-z0-9_+.-]+@([a-z0-9-]+\.)+[a-z0-9]{2,4}$" title="이메일을 입력해주세요." required>
		        <p class="help-block">이메일을 입력해주세요.</p>
		      </div>
		    </div>
		    
		    <br>
		 
		    <div class="control-group">
		      <!-- Button -->
		      <div class="controls">
		        <button type="submit" class="btn btn-success">회원가입</button>
		      </div>
		    </div>
		  </fieldset>
		</form>

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
