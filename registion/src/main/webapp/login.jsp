<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Giriş yap </title>
</head>
<body style="background-color:red">
<div align="center">
<h1>Giriş Yap</h1>
<form action="<%=request.getContextPath() %>/login" method="post">
<table style="width: 80%" >
<tr>
<td style="font-size: 150%">Email giriniz:</td>
<td><input type="text" name="email" />

</tr>

<tr>
<td style="font-size: 150%">Şifre giriniz:</td>
<td><input type="text" name="password" />

</tr>



</table>
<input type="submit" value="Giriş Yap" style="background-color: black ;width:15%; height: 50%;color:white;font-size:150%"/>
</form>

</div>
</body>
</html>