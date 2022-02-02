package verification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class VerificationDao {
	 public boolean validate(VerificationBean verificationBean) throws ClassNotFoundException{
		 
		 boolean status=false;
		 		Class.forName( "org.postgresql.Driver");
			try(Connection connection=DriverManager.getConnection("jdbc:postgresql://aa1dw7zmpktpfxn.cvw4lbyfcywt.us-east-1.rds.amazonaws.com:5432/SquidGame","postgres","12345678");
					
					PreparedStatement preparedStatement=connection
							.prepareStatement("select * from users where email = ?")){
			
				preparedStatement.setString(1,verificationBean.getEmail());
				System.out.println(preparedStatement);
				ResultSet rs=preparedStatement.executeQuery();
				status=rs.next();
			}catch(SQLException e) {
				System.out.println(e);
			}
			return status;
			}}

