package ct.dao.inf;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import ct.model.MemberVO;

public interface IMemberDao {
	
	// 로그인 인증 리턴 상수들 loginProcess()
		public static final int MB_LOGIN_ERROR = 0;
		public static final int MB_LOGIN_SUCCESS = 1;
		public static final int MB_LOGIN_NO_USER = 11;
		public static final int MB_LOGIN_PASSWORD_MISMATCH = 21;
		public static final int MB_LOGIN_PARAM_ID_NULL = 31;
		public static final int MB_LOGIN_PARAM_ID_EMPTY = 33;
		public static final int MB_LOGIN_PARAM_PW_NULL = 35;
		public static final int MB_LOGIN_PARAM_PW_EMPTY = 37;
		public static final int MB_LOGIN_PARAM_LIMIT = 41;	
//		1. 회원이 가입할 수 있다. (중복..)
		boolean insertOneNewUser(String email,String password,Date birth,String phone);
		boolean insertOneNewUser(MemberVO member);
//		2. 회원이 로그인/로그아웃 할 수 있다.
		int loginProcess(String email, String pw);
//		10. 어드민이 회원 리스트 조회하기
		List<MemberVO> selectAllUsers();

}
