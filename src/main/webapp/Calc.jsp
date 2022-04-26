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
	div.big-block {width: 1000px;margin: auto; font-size: 20pt}
	div.block {margin-bottom: 10px; border: 1px solid #2b2d42; width: 100%;}
	div table {width: 100%; }
	table thead {background-color: #778899;color: white; font-weight: bold;text-align: center;}
	table thead td {padding: 5px;}
	.td_right {text-align: right;padding-right: 2px; border-bottom: 1px solid #ccc;}
	.td_center {text-align: center;}
	input {font-size: 18pt; width: 100%;}
	select {font-size: 16pt}
	td.order {border-bottom: 1px solid #ccc;border-right: 1px solid #ccc;cursor: pointer;}
	.selectRow td{background-color: aqua;}
	.button {
		background-color: #0a0a23;
	    color: #fff;
	    border:none; 
	    border-radius:5px;
	    padding: 3px;
  	}
  	.button:hover {
		background-image: linear-gradient(to right, #9EEFE1 0%, #4830F0 51%, #0a0a23 100%);
	}
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
					<select name="ddlType" id = "ddlType" style="width: 550px;" onchange="ddlTypeClick()">
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
				<td><input class="button" name="btnPdf" value="Файл PDF" type="submit"></td>
			</tr>
			<tr>
				<td>Вид</td>
				<td colspan="3">
					<select name="ddlKind" id = "ddlKind" style="width: 550px;" onchange="this.form.submit()">
					<c:forEach items="${listWorkKind}" var="wKind">
						<!-- .select - обращение к getSelect() -->
						<option ${wKind.select? "selected='selected'" : ""} value="${wKind.name}">${wKind.name}</option>
					</c:forEach>
					</select>
				</td>
				<td><input class="button" name="btnAuthors" value="Авторы" type="submit"></td>
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
				<td><input name="txtCount" id="txtCount" style="width: 100px;" type="number" value="1" min="1" max="10000" required></input></td>
				<td>${count2}</td>
				<td>Итоговая сумма</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="button" name="btnAdd" id="btnAdd" value="Добавить" type="submit" ></td>
				<td><input class="button" name="btnCalc" id="btnCalc" value="Рассчитать" type="submit"></td>
				<td><div style = "border: 1px solid blue; width: 100%; height: 32px">${orderSum}</div></td>
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
			<c:forEach items="${listWorkItem}" var="wItem">
				<tr onclick="myFunction(this)">
					<td class="order">${wItem.typeName}</td>
					<td class="order">${wItem.kind}</td>
					<td class="order td_center">${wItem.price}</td>
					<td class="order td_center">${wItem.count}</td>
					<td class="td_right">${wItem.sum}</td>
				</tr>
			</c:forEach>
		</table></div>
		<input name="txtRowIdx" id="txtRowIdx" type="hidden"></input>
		<script>
			var selectRow;
			function myFunction(x){
				 //alert("Row index is: " + x.rowIndex);
				 if (selectRow != null){
					 selectRow.setAttribute('class', '');
				 }
				 if (selectRow != x){
					 x.setAttribute('class', 'selectRow');
					 selectRow = x;
					 var txt=document.getElementById("txtRowIdx");
					 txt.value = x.rowIndex;
				 } else {
					 x.setAttribute('class', '');
					 selectRow = null;
					 var txt=document.getElementById("txtRowIdx");
					 txt.value = "";
				 }
			}
		</script>
		<div class="block">
			<input class="button" name="btnClearAll" id="btnClearAll" style="width: 170px;" value="Очистить все" type="submit">
			<input class="button" name="btnDel" id="btnDel" style="width: 140px;" value="Удалить" type="submit">
		
		</form>
		<form action="Exit" method="post">
			<div style="padding-top: 10px">
			<input class="button" style="width: 130px;" value="Выход" type="submit">
			</div>
		</form>
		</div>
</div>
</body>
</html>