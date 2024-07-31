import java.sql.*;
import javax.swing.*;
public class SqlConnection {
	Connection conn=null;
	public static Connection dbConnector()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","spoorthi");
		  return conn;
			
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
		
	}
}

