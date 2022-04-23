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
	div.block {margin-bottom: 10px; border: 1px solid blue; width: 700px;}
	div table {width: 100%;}
	table thead {background-color: #778899;color: white; font-weight: bold;}
	div.big-block {width: 700px;margin: auto; font-size: 20pt}
	input {font-size: 18pt; width: 100%;}
	select {font-size: 16pt}
</style>
</head>
<body>
<div class="big-block">
	<form action="Calc" method="post">
		<div class="block">
		<table>
			<tr>
				<td>Тип</td>
				<td colspan="3">
					<select name="ddlType" id = "ddlType" style="width: 350px;" onchange="this.form.submit()">
					<c:forEach items="${listWorkType}" var="wType">
						<!-- .select - обращение к getSelect() -->
						<option ${wType.select? "selected='selected'" : ""} value="${wType.name}">${wType.name}</option>
					</c:forEach>
					</select>
				</td>
				<td><input name="btnPdf" value="Файл PDF" type="submit"></td>
			</tr>
			<tr>
				<td>Вид</td>
				<td colspan="3">
					<select name="ddlKind" id = "ddlKind" style="width: 350px;" onchange="this.form.submit()">
					<c:forEach items="${listWorkKind}" var="wKind">
						<!-- .select - обращение к getSelect() -->
						<option ${wKind.select? "selected='selected'" : ""} value="${wKind.name}">${wKind.name}</option>
					</c:forEach>
					</select>
				</td>
				<td><input name="btnAuthors" value="Авторы" type="submit"></td>
			</tr>
						<tr>
				<td>Цена</td>
				<td><div style = "border: 1px solid blue; width: 105px">${price1}</div></td>
				<td>${price2}</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Кол-во</td>
				<td><input style="width: 100px;"></input></td>
				<td>${count2}</td>
				<td>Итоговая сумма</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><input name="button1" id="button1" value="Добавить" type="submit" ></td>
				<td><input value="Рассчитать" type="submit"></td>
				<td><div style = "border: 1px solid blue; width: 100%">0.00</div></td>
				<td></td>
			</tr>
		</table></div>
		<div class="block">
		<table>
		<thead>
			<tr>
				<td>Тип</td>
				<td>Вид</td>
				<td>Цена</td>
				<td>Кол-во</td>
				<td>Сумма</td>
			</tr>
		</thead>
			<tr>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
			</tr>
						<tr>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
			</tr>
						<tr>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
			</tr>
									<tr>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
			</tr>
									<tr>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
			</tr>
			<tr>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
			</tr>
		</table></div>
		<div class="block">
			<input style="width: 170px;" value="Очистить все" type="submit">
			<input style="width: 140px;" value="Удалить" type="submit">
		</div>
		</form>
		<form action="Exit" method="post">
			<div class="block"><input class="block" style="width: 130px;" value="Выход" type="submit"></div>
		</form>
</div>
</body>
</html>