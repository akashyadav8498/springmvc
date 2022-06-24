import java.sql.*;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
	// write your code here
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/mydb";
        String usr = "root";
        String pass = "";
		

        Connection con = DriverManager.getConnection(url,usr,pass);
		
		String QUERY = "SELECT * FROM designation";

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY); 
         
         while (rs.next()) {
            
            System.out.println("Code: " + rs.getInt("code"));
            System.out.println("Title: " + rs.getString("title"));
            
         }
      


    }
}



      