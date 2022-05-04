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
    body{background-image: linear-gradient(315deg, #00A2C2 0%, #42FFA1 80%);}
	.label {color: #fff;}
	div table {width: 100%;}
	.select {width: 300px;font-size: 22pt;}
	.btnCont1 {width: 100%;}
	.block { 
		width: 600px;
		height: 470px;
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
	.txt1 {
		font-size: 22pt;
		color: #000;
		font-family: Arial Black;
		width: 200px;
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
	.labelPrice{
		padding-left: 5px;
		font-family: Arial;
		font-size: 22pt;
		background: #fff;
		width: 295px;
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
					<select class="select" name="ddlType" id = "ddlType" onchange="ddlTypeClick()">
					<c:forEach items="${listWorkType}" var="wType">
						<!-- .select - обращение к getSelect() -->
						<option ${wType.select? "selected='selected'" : ""} value="${wType.name}">${wType.name}</option>
					</c:forEach>
					</select>
					<input name="btnDdlType1" id="btnDdlType1" value="ddlType" type="submit" hidden="hidden">
					<script>
						function ddlTypeClick() {
							var btn= document.getElementById("btnDdlType1");
							btn.click();
						}
					</script>
				</td>
			</tr>
			<tr>
				<td class="label">Вид</td>
				<td>
					<select class="select" name="ddlKind" id = "ddlKind" onchange="this.form.submit()">
					<c:forEach items="${listWorkKind}" var="wKind">
						<!-- .select - обращение к getSelect() -->
						<option ${wKind.select? "selected='selected'" : ""} value="${wKind.name}">${wKind.name}</option>
					</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td class="label">Старая цена</td>
				<td><div class="labelPrice">${price1} ${price2}</div></td>
			</tr>
			<tr>
				<td class="label">Новая цена</td>
				<td>
					<div class="label">
						<input class="txt1" name="txtNewPrice" id="txtNewPrice" type="number" value="1" min="1" max="1000000" required></input> руб.
					</div>
				</td>
			</tr>
		</table>
		
		<input type="hidden" name="txtKind" id="txtKind" value="${txtKind}">
		<input type="hidden" name="txtUnit" id="txtUnit" value="${txtUnit}">
		<input type="hidden" name="txtPrice" id="txtPrice" value="${txtPrice}">
		
		<div class="btnCont1"><input class="btn" name="btnApply" id = "btnApply" type="submit" value="Применить"></div>
	</form>
	<form action="Calc" method="post">
		<div class="btnCont2"><input class="btnExit" name="btnExit" id = "btnExit" type="submit" value="Выход"></div>
	</form>
</div>
</body>
</html>