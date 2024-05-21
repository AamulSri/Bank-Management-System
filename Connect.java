package BankManagementSystem;

import java.sql.*;


/*Database Connection Require bellow steps
1. Register the Driver --->which is done by mysql-connector-java jar through classpath
2. Create Connect
3. Create Statement 
4. Execute Query
5. Close Connection*/
public class Connect {
	
	Connection c;
	Statement s;

	Connect(){
	  try {
		 
			 //2. Create Connection --> a URL is passed i.e a connection string with mysql UserName and Password
			     //a)jdbc connection b) mysql database c)name of the database or (localhost:3306)
		  //c = DriverManager.getConnection("jdbc:mysql://localhost:3306"); 
		  //but bydefault mysql is on port 3306 thus we can use DB name
		  
				c = DriverManager.getConnection("jdbc:mysql:///BankManagSystem", "root", "Aamul@1234");
			  
			  //3. Create Statement
				s = c.createStatement();
	  }
		catch (Exception e) {
			System.out.println(e);
		}
  }
  
}
