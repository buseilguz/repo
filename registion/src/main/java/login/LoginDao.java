package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class LoginDao {
	
 public boolean validate(LoginBean loginBean) throws ClassNotFoundException{
 
 boolean status=false;
 		Class.forName( "org.postgresql.Driver");
	try(Connection connection=DriverManager.getConnection("jdbc:postgresql://aa1dw7zmpktpfxn.cvw4lbyfcywt.us-east-1.rds.amazonaws.com:5432/SquidGame","postgres","12345678");
			
			PreparedStatement preparedStatement=connection
					.prepareStatement("select * from users where email = ? and password = ?")){
	
		preparedStatement.setString(1,loginBean.getEmail());
		preparedStatement.setString(2, loginBean.getPassword());
		System.out.println(preparedStatement);
		ResultSet rs=preparedStatement.executeQuery();
		status=rs.next();
	}catch(SQLException e) {
		System.out.println(e);
	}
	return status;
	}}
 
 
 
 
 
 
 
 

