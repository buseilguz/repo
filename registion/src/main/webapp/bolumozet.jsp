<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<HTML>
<HEAD>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bölüm Özetleri</title>
    <link rel="stylesheet" href="stil.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript" src="accordion-js.js"></script>

</HEAD>



<div class="dil">
         
    <input type="image" src="images/turkey.png" value="submit" width="50px" onclick="location.href='http://registion2-env.eba-ay8ffjrw.us-east-1.elasticbeanstalk.com/bolumozet.jsp' ">
    <input type="image" src="images/eng.png" value="submit" width="50px" onclick="location.href='http://registion2-env.eba-ay8ffjrw.us-east-1.elasticbeanstalk.com/bolumozet-en.jsp' ">
   </div>
   
   <div class="ust" >
    <button onclick="location.href='http://registion2-env.eba-ay8ffjrw.us-east-1.elasticbeanstalk.com/login.jsp'" type="button button1" ></button>
   

  </div>
    <div class="button2"> <button onclick="location.href='http://registion2-env.eba-ay8ffjrw.us-east-1.elasticbeanstalk.com/userregister.jsp' " type="button button2" ></button></div>
<div class="etiket1">
  <h1>Giriş Yap</h1>
  </h1>
</div>
<div class="etiket2"><h1>Üye Ol</h1></div>
<div class="menu">
	<ul>
		<li><a href="index.html">Anasayfa</a></li>
		<li><a href="bolumozet.jsp">Bölüm Özetleri</a></li>
		<li><a href="oyuncular.jsp">Oyuncular</a></li>
		<li><a href="#">Müzikler</a></li>
		<li><a href="#">İletişim</a></li>
	</ul>
</div>
<div class="baslik">
    <h2>Oyuncular</h2>
</div>
<div class="resimb">

    <img src="images/anasayfa.jpg" alt="r"/>
    


  </div>
<br>
    <% int verisayac = 0;
       Connection connection = null;
       String connectionURL = "jdbc:postgresql://aa1dw7zmpktpfxn.cvw4lbyfcywt.us-east-1.rds.amazonaws.com:5432/SquidGame";
       ResultSet rs = null;
    %>
<center>
    <FORM ACTION="oyuncular.jsp" METHOD="get">
    <div class="accordion"><%
        if (request.getParameter("verigoster") != null) {
        verisayac = Integer.parseInt(request.getParameter("verigoster"));
     }
Statement statement = null;
    try {
       Class.forName("org.postgresql.Driver");
       connection = DriverManager.getConnection(connectionURL,"postgres", "12345678");
       statement = connection.createStatement();
       rs = statement.executeQuery("select * from bolumozet");
       while(rs.next()){

%>


        <div class="accordion-section" >
            <a class="accordion-section-title"><%= rs.getString(1)%><br><%=rs.getDate(3) %></a>
           <div class="accordion-section-content">
                <p><video width="360" height="320" controls="controls">
                    <source src="<%=rs.getString(2) %>" type="video/mp4" />
                    <source src="video.ogg" type="video/ogg" />
                    Tarayıcınız video etiketini desteklemiyor.
                  </video></p>
            </div></div>
<BR>
  
</FORM>
<%
}
}
catch (Exception ex) {
out.println("Veritabanına baglanilamadi.");
}
%>

</center>
</body>
</html>>