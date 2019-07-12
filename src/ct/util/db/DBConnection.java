package ct.util.db;
import java.sql.*;

public class DBConnection {
	public static final String 
			DRIVER = "com.mysql.jdbc.Driver";
	public static final String
			URL = 
			"jdbc:mysql://localhost:3306/"
			+ "cafe_db";
	private static final String login = "";
	private static final String password = "";
	
	public static Connection conn;
	public static Statement stmt;
	public static PreparedStatement pstmt;
	//private CallableStatement cstmt;
	
	public static Connection getConn() {
		if( conn == null ) {
			return beginConnection();
		} else {
			return conn;
		}
	}
	
	public static Connection beginConnection() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,
					login, password);
			stmt = conn.createStatement();
			ResultSet rs 
			 = stmt.executeQuery("select now() as cu");
			if( rs.next() ) {
				System.out.println(
						"MySQL 연결 성공: " + 
							//rs.getDate(1)
							rs.getDate("cu")
						);
				if( rs != null ) rs.close();
				return conn;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			;
		}
		return null;
	}	
	public static boolean endConnection() {
		if( conn != null ) {
			try {
				if( stmt != null ) stmt.close();
				if( pstmt != null ) pstmt.close();
				conn.close();
				System.out.println("endConnection()�꽦怨�");
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static boolean releaseRS(ResultSet rs) {
		if( conn != null ) {
			if( rs != null )
			{
				try {
					rs.close();
					System.out.println("rs close()");
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	public static boolean releaseSTMT(
			Statement stmt) {
		if( conn != null ) {
			if( stmt != null )
			{
				try {
					stmt.close();
					System.out.println("stmt close()");
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;		
	}
	public static boolean releasePSTMT(
			PreparedStatement pstmt) {
		if( conn != null ) {
			if( pstmt != null )
			{
				try {
					pstmt.close();
					System.out.println("pstmt close()");
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;		
	}
	
	
	public static void main(String[] args) {
		Connection 
		   testConn = DBConnection.beginConnection();
		// DBConnection.conn 
		DBConnection.endConnection();
	}
}












