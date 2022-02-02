<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Üye Ol</title>
</head>
<body style="background-color:red">
<div align="center">
<h1>Üyelik Formu</h1>
<form action="<%=request.getContextPath() %>/register" method="post">
<table style="width: 80%" >
<tr>
<td style="font-size: 150%">İsim giriniz:</td>
<td><input type="text" name="name" />

</tr>
<tr>
<td style="font-size: 150%">Soyisim giriniz</td>
<td><input type="text" name="surname"/>

</tr>
<tr>
<td style="font-size: 150%">Cep numaranızı giriniz</td>
<td><input type="text" name="number"/>

</tr>

<tr>
<td style="font-size: 150%">Doğum tarihiniz</td>
<td><input type="text" name="birthday"/>

</tr>
<tr>
<td style="font-size: 150%">Email adresiniz</td>
<td><input type="text" name="email"/>

</tr>
<tr>
<td style="font-size: 150%">Adres giriniz</td>
<td><input type="text" name="adres"/>

</tr>
<tr>
<td style="font-size: 150%">Şifre belirleyiniz</td>
<td><input type="text" name="password"/>

</tr>


</table>
<input type="submit" value="Üye Ol" style="background-color: black ;width:15%; height: 50%;color:white;font-size:150%"/>
</form>

</div>
</body>
</html>