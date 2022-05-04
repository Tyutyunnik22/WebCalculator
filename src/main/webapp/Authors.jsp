<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body{background-image: linear-gradient(315deg, #9EFFEF 0%, #48CEEF 74%);}
	div.big-block {
		margin: 0;
		position: absolute;
		top: 50%;
		left: 50%;
		-ms-transform: translate(-50%, -50%);
  		transform: translate(-50%, -50%);
		width: 700px;
		font-size: 20pt;
		height: 350px;
	}
	div.block {
		width: 100%;
		height: 100%;
		background: #00c2a2;
		border-radius:12px;
	}
	.head {
		text-align:center;
		font-size: 26pt;
		font-family: Arial Black;
		color: #fff;
	}
	.text {
		text-align:center;
		font-size: 26pt;
		font-family: fantasy;
	}
		.btnExit {
		margin:0 auto;
    	display:block;
		width: 120px;
		height: 65px;
		font-family: Comic Sans MS;
		margin-top:15px;
		border: 0;
  		background-color: #ff3d3d;
		background-image: linear-gradient(315deg, #ff5959 0%, #c9001b 74%);
		color: #fff;
		font-size: 20pt;
		position: relative;
		box-sizing: border-box;
		transition: all 500ms ease;
		border-radius:12px;
	}
	.btnCont2 {
		width: 100%;
	}
	.btnExit:hover {
		background: #fff;
		color: #ff0000;
		box-shadow: inset 0 0 0 3px #00c2a2;
	}
</style>
</head>
<body>
<form>
	<div class="big-block">
		<div class="block">
			<div class="head">Разработчики</div>
			<div class="head">ФИРТ ПИ-224</div>
			<div class="text">Тютюнник Е.В.</div>
			<div class="text">Салимгареев К.И.</div>
			<div class="text">Мамлеева З.Д.</div>
			<div class="text">Скитяева А.Н.</div>
			<div><input class="btnExit" type="submit" value="Назад" onclick="history.back()"></div>
		</div>
	</div>
</form>
</body>
</html>