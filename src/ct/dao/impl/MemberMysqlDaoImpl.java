package ct.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ct.dao.inf.IMemberDao;
import ct.model.MemberVO;
import ct.util.db.DBConnection;

public class MemberMysqlDaoImpl implements IMemberDao {

	@Override
	public boolean insertOneNewUser(String email,String password,Date birth,String phone) {
		Connection conn = DBConnection.getConn();
		if( conn != null ) {
			String sql 
			  = "insert into tb_member values(null, ?, ?, ?,?,1000,0,now(),now())";
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, email);
					pstmt.setString(2, password);
					pstmt.setDate(3, birth);
					pstmt.setString(4, phone);
					System.out.println("여기.");
					
					int r = pstmt.executeUpdate();
					if( r == 1 ) {
						System.out.println("회원으로 등록되었습니다.");
						return true;
					} else 
						System.out.println("회원등록이 실패하였습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return false;
	
	}

	@Override
	public boolean insertOneNewUser(MemberVO member) {
		
		return false;
	}

	@Override
	public int loginProcess(String email, String pw) {
	
		return 0;
	}

	@Override
	public List<MemberVO> selectAllUsers() {
		
		return null;
	}

}
