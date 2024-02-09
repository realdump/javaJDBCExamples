package abmn.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp19 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
        String user="root";
        String pass="root_pass_1234";
        String url = "jdbc:mysql://127.0.0.1:3306/employee?autoReconnect=true&useSSL=false&&allowPublicKeyRetrieval=true";
        Connection con = DriverManager.getConnection(url,user,pass);
        Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
        ResultSet rs=st.executeQuery("select * from emp1");
        System.out.println("Data In Forward Direction");
        System.out.println("ENO\tENAME\tESAL\tEADDR\t");
        System.out.println("----------------------------------");
        while(rs.next()){
        System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"
        +rs.getFloat(3)+"\t"+rs.getString(4));
        }
        System.out.println("Data In Backward Direction");
        System.out.println("ENO\tENAME\tESAL\tEADDR");
        System.out.println("-------------------------------");
        while(rs.previous()){
        System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"
        +rs.getFloat(3)+"\t"+rs.getString(4));
        }
        con.close();
        
	}

}
