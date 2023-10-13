package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	public static Connection getConnection()
	{
		Connection cons =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cons = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcbankdb","root","happy123$");
		}   
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
		return cons;
	}
	
	public static void main(String[] args)
	{
		System.out.println(getConnection());
	}

}
 
static final Logger LOGGER = Logger.getLogger(LoginController.class);
@Override
public boolean login(String username, String password) {
	Connection con = DBConnect.getConnection();
	String sql = "select * from abcbanktb where username='" + username
			+ "' and password='" + password + "'"; 
	PreparedStatement ps;
	try {
		ps = (PreparedStatement) con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			con.close();
			return true;
		}
	} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return false;

 
<%
	     
	 String  un = (String)session.getAttribute("user");
	  
	 UserDAOImpl userdao = new UserDAOImpl();
	 ResultSet data;
	    
	 data=userdao.data(un);
	 String acno = data.getString("acno");
	 String email = data.getString("email");
	 String balance = data.getString("balance");
	 String mobile = data.getString("mobile");
	 String fb=data.getString("feedback");
	    
	  %>
	      
	Hello <% out.println(ESAPI.encoder().encodeForHTML(un)); %>
	      <br><br>
	      You account number: <% out.println(ESAPI.encoder().encodeForHTML(acno)); %> <br>
	      Your email id is: email; %> <br>  
	      Your balance is: <% out.println(ESAPI.encoder().encodeForHTML(balance)); %> <br>
	      Your mobile number is: <% out.println(ESAPI.encoder().encodeForHTML(mobile)); %> <br>
	      Your feedback is: <% out.println(ESAPI.encoder().encodeForHTML(fb)); %> <br>
	

	  <br> <a href="feedback.jsp">Feedback</a>
	   </body>
