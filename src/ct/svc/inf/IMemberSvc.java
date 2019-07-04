package ct.svc.inf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ct.svc.MyFlow;

public interface IMemberSvc {
	public MyFlow doAction(HttpServletRequest req,HttpServletResponse res)
	throws Exception;
}
