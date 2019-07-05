package ct.svc.impl;


import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ct.dao.impl.MemberMysqlDaoImpl;
import ct.dao.inf.IMemberDao;
import ct.svc.MyFlow;
import ct.svc.inf.IMemberSvc;


public class MemberAddSvcImpl implements IMemberSvc {
	@Override
	public MyFlow doAction(
			HttpServletRequest req,
			HttpServletResponse res)
		throws Exception
		
	{
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String birthbefore = req.getParameter("birth");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		Date birth= new Date( sdf.parse(birthbefore).getTime() );
		String phone = req.getParameter("phone");
		System.out.println(email);
		IMemberDao mbDao = new MemberMysqlDaoImpl();
	
		
		MyFlow mf = null;
		if( mbDao.insertOneNewUser(email, password,birth, phone)) {
			System.out.println("svc: user insert OK.");
			mf = new MyFlow("default.ct",false); // 리다이렉트
		} else {
			System.out.println("svc: user insert Error.");
			mf = new MyFlow("index.jsp",true); // 포워딩
		}
	
		return  mf;
	}
}


