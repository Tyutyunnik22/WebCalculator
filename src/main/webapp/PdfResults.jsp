<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Результат создания файла PDF</title>
</head>
<body>
<h1 class="headline">Файл PDF создан. Нажмите на кнопку, чтобы скачать.</h1>
<a href="/CreatePDF/Check.pdf"> Открыть PDF-файл</a>
<a href="/CreatePDF/Check.pdf" download> Скачать PDF-файл</a>

<form action="${pageContext.request.contextPath}/Calc.jsp">
    <input type="submit" name="sign" value="Вернуться назад">
</form>
</body>
</html>