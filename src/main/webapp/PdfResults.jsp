<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Результат создания файла PDF</title>
<style>
	p {margin-top: 20px; font-size: 18px;}
</style>
</head>
<body>
<h1 class="headline">Файл PDF создан. Нажмите на кнопку, чтобы скачать.</h1>
<p><a href="DownloadFile?type=view"> Открыть PDF-файл</a></p>
<p><a href="DownloadFile?type=download"> Скачать PDF-файл</a></p>
<form action="Calc" method="post">
    <input type="submit" name="sign" value="Вернуться назад">
</form>
</body>
</html>