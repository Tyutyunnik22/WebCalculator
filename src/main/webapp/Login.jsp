<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.block { 
		width: 550px;
		height: 400px;
		font-size: 26pt;
		background-color: #002038;
		margin: 0;
		position: absolute;
		top: 50%;
		left: 50%;
		-ms-transform: translate(-50%, -50%);
  		transform: translate(-50%, -50%);
  		border-radius:12px;
	}
	.block-2 {
		width: 100%;
	}
	.txt1 {
		padding: 10px;
		font-family: VERDANA;
		color: #00c8ff;
		font-size: 16pt;
		width: 100%;
	}
	.txt2 {
		margin-left:10px;
		background:transparent;
		color: #66fcff;
		margin:5px 5;
		font-size: 26pt;
		width: 96%;
		border:0;
  		border-bottom:1px solid #fff;
	}
	.btn {
		width: 100%;
		height: 100px;
		font-family: Comic Sans MS;
		margin-top:30px;
		border: 0;
  		background: linear-gradient(to right, rgba(125,185,232,0) 1%,rgba(125,185,232,0.02) 2%,rgba(30,87,153,0.98) 45%,rgba(32,89,154,1) 46%,rgba(125,185,232,0) 100%);
		color: #66fcff;
		font-size: 30pt;
	}
	.btn:hover {
	    box-shadow: 0 0 10px #00c8ff;
	    -moz-box-shadow: 0 0 10px #00c8ff;
	    -o-box-shadow: 0 0 10px #00c8ff;
	    -ms-box-shadow: 0 0 10px #00c8ff;
	    -webkit-box-shadow: 0 0 10px #00c8ff;
	}
	.head {
		text-align:center;
		font-size: 26pt;
		font-family: Arial Black;
		color: #fff;
	}
	.error {
		color: #FF4500;
	}
	input {font-size: 18pt}
</style>
</head>
<body style="background-color: #002d4f">
<form action="Login" method="post">
		<div class="block">
			<div class="head">Авторизация</div>
			<div class="txt1">Имя пользователя</div>
			<div><input class="txt2" type="text" name="username" onfocus="this.value=''" value = user></div>
			<div class="txt1">Пароль</div>
			<div><input class="txt2" type="password" name="password" onfocus="this.value=''" value = 123></div>
			<div><input class="btn" type="submit" value="Войти"></div>
			<div class="error">${err}</div>
		</div>
</form>
</body>
</html>