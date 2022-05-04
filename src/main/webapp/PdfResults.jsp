<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Результат создания файла PDF</title>
<style>
	body{
			background-image: linear-gradient(315deg, #87AAEB 0%, #A3F5F5 80%);
	}
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
		background-image: linear-gradient(315deg, #1E90FF 0%, #EF9EFF 80%);
		border-radius:12px;
	}
		.headline {
		text-align:center;
		font-size: 28pt;
		font-family: Arial Black;
		color: #c700c7;
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
		background-image: linear-gradient(315deg, #C70092 0%, #4754FF 74%);
		color: #fff;
		font-size: 20pt;
		position: relative;
		box-sizing: border-box;
		transition: all 500ms ease;
		border-radius:12px;
				text-align:center;
	}
				p {
		margin:0 auto;
    	display:block;
    	text-decoration: none;
		width: 250px;
		height: 65px;
		font-family: Comic Sans MS;
		margin-top:15px;
		border: 0;
  		background-color: #ff3d3d;
		background-image: linear-gradient(315deg, #F5DAFB 0%, #7B68EE 74%);
		color: #fff;
		font-size: 20pt;
		position: relative;
		box-sizing: border-box;
		transition: all 500ms ease;
		border-radius:12px;
				text-align:center;
	}
		.btnExit:hover {
		background: #fff;
		color: #ff0000;
		box-shadow: inset 0 0 0 3px #00c2a2;
	}
		p:hover {
		background: #fff;
		color: #ff0000;
		box-shadow: inset 0 0 0 3px #00c2a2;
	}
	   .text{
	   	text-align:center;
		font-size: 12pt;
		font-family: Arial Black;
		color: white;
	   }
</style>
</head>
<body>
	<div class="big-block">
		<div class="block">
           <h1 class="headline">Файл PDF создан</h1>
             <p><a href="DownloadFile?type=view"> Открыть PDF-файл</a></p>
             <p><a href="DownloadFile?type=download"> Скачать PDF-файл*</a></p>
             <h2 class="text">*Убедитесь, что в вашем браузере разрешено скачивание pdf-файлов</h2>
            <form action="Calc" method="post">
            <div><input class="btnExit" type="submit" value="Назад" onclick="history.back()"></div>
       </div>
	</div>
</form>
</body>