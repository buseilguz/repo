package registion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

	public int registerUser(User user) throws ClassNotFoundException{
		String INSERT_USERS_SQL="INSERT INTO users"+
	"(name,surname,number,birthday,email,adres,password) VALUES"+
				"(?,?,?,?,?,?,?);";
		int result=0;
		Class.forName( "org.postgresql.Driver");
		try(Connection connection=DriverManager.getConnection("jdbc:postgresql://aa1dw7zmpktpfxn.cvw4lbyfcywt.us-east-1.rds.amazonaws.com:5432/SquidGame","postgres","12345678");
				PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USERS_SQL)){
				
					preparedStatement.setString(1, user.getName());
					preparedStatement.setString(2, user.getSurname());
					preparedStatement.setString(3, user.getNumber());
					preparedStatement.setString(4, user.getBirthday());
					preparedStatement.setString(5, user.getEmail());
					preparedStatement.setString(6, user.getAdres());
					preparedStatement.setString(7, user.getPassword());
					
					result=preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}
