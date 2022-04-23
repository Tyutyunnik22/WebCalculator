<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.block { 
		width: 600px;
		height: 421px;
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
	.head {
		text-align:center;
		font-size: 26pt;
		font-family: Arial Black;
		color: #fff;
	}
	.label {
		color: #fff;
	}
	div table {width: 100%;}
	.txt1 {
		font-size: 18pt;
		color: #000;
		font-family: Arial Black;
		width: 200px;
	}
	.select {
		font-size: 18pt;
	}
	.btn {
		margin:0 auto;
    	display:block;
		width: 500px;
		height: 100px;
		font-family: Comic Sans MS;
		margin-top:30px;
		border: 0;
  		background-color: #00b712;
		background-image: linear-gradient(315deg, #00b712 0%, #008f6b 74%);
		color: #fff;
		font-size: 30pt;
		position: relative;
		box-sizing: border-box;
		transition: all 500ms ease;
	}
	.btnCont1 {
		width: 100%;
	}
	.btn:hover {
		background: #fff;
		color: #3bcf00;
		box-shadow: inset 0 0 0 5px #008554;
	}
		.btnExit {
		float: right;
    	display:block;
		width: 100px;
		height: 30px;
		font-family: Comic Sans MS;
		margin-top:30px;
		border: 0;
  		background-color: #ff3d3d;
		background-image: linear-gradient(315deg, #ff5959 0%, #c9001b 74%);
		color: #fff;
		font-size: 15pt;
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
		box-shadow: inset 0 0 0 3px #002038;
	}
</style>
</head>
<body style="background-color: #fff">
<div class="block">
	<form action="Admin" method="post">
		
		
			<div class="head">Панель админа</div>
			<div class="head">Изменение цены</div>
			<table>
			<tr>
				<td class="label">Тип</td>
				<td>
					<select class="select" name="adminType" id = "adminType" style="width: 350px;" onchange="this.form.submit()">
					<c:forEach items="${adminWorkType}" var="wType">
						<!-- .select - обращение к getSelect() -->
						<option ${wType.select? "selected='selected'" : ""} value="${wType.name}">${wType.name}</option>
					</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td class="label">Вид</td>
				<td>
					<select class="select" name="adminKind" id = "adminKind" style="width: 350px;">
					<c:forEach items="${adminWorkKind}" var="wKind">
						<!-- .select - обращение к getSelect() -->
						<option ${wKind.select? "selected='selected'" : ""} value="${wKind.name}">${wKind.name}</option>
					</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td class="label">Новая цена</td>
				<td>
					<div class="label"><input class="txt1" type="number" min="1" max="1000000" name="adminPrice"> руб.</div>
				</td>
			</tr>
			</table>
			<div class="btnCont1"><input class="btn" type="submit" value="Применить"></div>
	</form>
	<form action="Exit" method="post">
		<div class="btnCont2"><input class="btnExit" type="submit" value="Выход" onclick="/Login.jsp"></div>
	</form>
</div>
</body>
</html>