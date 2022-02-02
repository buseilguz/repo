package actor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ActorDao {
	
    
    public List<ActorBean> getActors() {
    	PreparedStatement ps=null;
       Connection con=null;
       try {
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://aa1dw7zmpktpfxn.cvw4lbyfcywt.us-east-1.rds.amazonaws.com:5432/SquidGame","postgres","12345678");
            ps=con.prepareStatement("SELECT * FROM actors");
            ResultSet rs=ps.executeQuery();
            List<ActorBean> liste=new ArrayList<>();
            while(rs.next())
            {
                ActorBean aa=new ActorBean();
                aa.setActor_name(rs.getString("actor_name")); 
                aa.setDescription(rs.getString("description")); 
                liste.add(aa);
            }
            return liste;
        } 
        catch (ClassNotFoundException | SQLException exception) {
            System.out.println("Bir hata meydana geldi:"+exception);
            return null;
        }
        finally{ 
            try {
                if(con!=null){ 
                    con.close();
                }
                if(ps!=null){
                    ps.close();
                }
            } catch (SQLException sqlException) {
                System.out.println("Bir hata meydana geldi:"+sqlException);
            }
        }
    }
	
}
