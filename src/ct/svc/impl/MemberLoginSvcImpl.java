package ct.svc.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ct.dao.impl.MemberMysqlDaoImpl;
import ct.dao.inf.IMemberDao;
import ct.svc.MyFlow;
import ct.svc.inf.IMemberSvc;


//abstract public class UserLoginSvcImpl
public class MemberLoginSvcImpl
	implements IMemberSvc {
	private IMemberDao memberDao;
	public MemberLoginSvcImpl() {
		this.memberDao = new MemberMysqlDaoImpl();
	}
	
	@Override
	public MyFlow doAction(HttpServletRequest req, 
			HttpServletResponse res) throws Exception {
		// 1. 요청을 처리(파람/속성 분석)
		String email = req.getParameter("email");
		String pw = req.getParameter("pw");	
		
		// 2. 관련 모델을 결정 (VO?)
		//    비지니스 로직 수행, 만약 DB같은 저장단 
		//    데이터가 필요하면 DAO를 연동
		int r = this.memberDao.loginProcess(email, pw);
		// 3. DAO를 통해 해당 서비스의 sql 등을 처리
		// 4. 결과를 판단하여 컨트롤러에 전달할
		//	    즉, 응답으로 표시할 UI view를 결정하고,
		//    이동방식(forward,redirect)을 설정
		MyFlow mf = null;
		HttpSession ses = req.getSession(); 
		switch (r) {
		case IMemberDao.MB_LOGIN_SUCCESS:
			// 세션 처리
			System.out.println("svc: 로그인 인증 성공 - " + email);
			ses.setAttribute("login", email);
			// 페이지 이동 처리
			mf = new MyFlow("blog_show_list.my", false);
			break;
		case IMemberDao.MB_LOGIN_ERROR:			
		case IMemberDao.MB_LOGIN_NO_USER:
		case IMemberDao.MB_LOGIN_PARAM_ID_EMPTY:
		case IMemberDao.MB_LOGIN_PARAM_ID_NULL:
		case IMemberDao.MB_LOGIN_PARAM_LIMIT:
		case IMemberDao.MB_LOGIN_PARAM_PW_EMPTY:
		case IMemberDao.MB_LOGIN_PARAM_PW_NULL:
		case IMemberDao.MB_LOGIN_PASSWORD_MISMATCH:
			ses.setAttribute("msg", 
					"로그인 에러 - CODE: " + r);
			mf = new MyFlow("/MyBlog", false);
			break;			
		default:
			ses.setAttribute("msg", 
					"처리 할 수 없는 로그인 에러 - CODE: " + r);
			mf = new MyFlow("/MyBlog", false);
						// default.my(web.xml) 
						// => default.jsp
						// => _mb_login.jsp
			break;
		}
		
		return mf;
	}	
}

