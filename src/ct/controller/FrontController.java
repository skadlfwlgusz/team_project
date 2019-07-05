package ct.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ct.svc.MyFlow;
import ct.svc.impl.MemberAddSvcImpl;
import ct.svc.impl.MemberLoginSvcImpl;
import ct.svc.inf.IMemberSvc;


/**
Servlet implementation class FrontController
0:0:0:0:0:0:0:1, /MyBlog/hello.my
0:0:0:0:0:0:0:1, /MyBlog/hello43433443.my
0:0:0:0:0:0:0:1, /MyBlog/hello/343433443.my
0:0:0:0:0:0:0:1, /MyBlog/hello/yolgil.my
 */
@WebServlet(description = "Url mapping, flow control, security, logging..", 
	urlPatterns = { "*.ct" }) //, "/myblog/mm/*" })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWWW(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doWWW(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException  
	{
		// get, post 요청 모두 내가 처리
		String addr = request.getRemoteAddr();
		String uri = request.getRequestURI();
		
		String ctxPath = request.getContextPath();
		System.out.println("ctxPath = " + ctxPath);
		System.out.println("uri = " + uri);
		
		String action = null;
		// .my로 endsWith? 인지, uri "/" 인지?
		if( uri.equals(ctxPath+"/") ) {
			//action = "default";
			action = "/";
		} else {
			System.out.println("Action = " +
			 uri.substring(ctxPath.length()+1, // "/??"
					 uri.length()-3) // ".my"
					//uri.substring(ctxPath.length())
					);
			action = uri.substring(
				ctxPath.length()+1, uri.length()-3);
		}
		
		response.setContentType
				("text/html; charset=UTF-8");
		//PrintWriter pw = response.getWriter();
		//pw.append(addr + ", " + uri);
		System.out.println(addr + ", " + uri);
		MyFlow mf = null;
		IMemberSvc svc = null;
		//String viewPath = "/";
		
		// 서비스 분기 처리 (URL 매핑) ---------
		switch(action) {
			// 0. 메인 페이지 /MyBlog/default.my
			// 	   		    /MyBlog  (web.xml)
			case "/":				
				//request.setAttribute("msg",
				//		"저는 /요청으로 왔어요!");
			case "default": 
				mf = 
				 new MyFlow("index.jsp", true);
				 //new MyFlow("view/member/new_mb.jsp", true);
				break;
			//1. 회원이 가입할 수 있다. (중복..)
			// new_member.my <<FORWARD>>
			case "new_member": // (가입폼 준비)
				System.out.println(">> new_member.jsp!!!");
				mf = new MyFlow();
				mf.setViewPath("join/join2.jsp");
				mf.setForward(true);
				break;
			// member_add_proc.my <<REDIRECT>>
			case "member_add_proc": //  (DAO 연동)	
				System.out.println(">> !!!");
		 
				svc = new MemberLoginSvcImpl();
				try {
					mf = svc.doAction(request, response);
				} catch (Exception e) {					
					e.printStackTrace();
				}

				break;
				
			//2. 회원이 로그인/로그아웃 할 수 있다.
			//member_login_proc.ct
			
			case "member_login_proc": //<<REDIRECT>>

				HttpSession ses = request.getSession();

				ses.setAttribute("msg",

						"로그인 시도");

				System.out.println("로그인 시도");

				//UserLoginSvcImpl svc2 =

				svc = new MemberLoginSvcImpl();				

			try {

				mf = svc.doAction(request, response);

			} catch (Exception e) {

				e.printStackTrace();

			}				

//				mf = new MyFlow();

//				mf.setViewPath("default.jsp");

//				mf.setForward(false);

				break;
				
				
				

			default:
			   response
			   	.sendError(
			   	 HttpServletResponse.SC_NOT_FOUND);
				//.sendError(404);
			   System.out.println("error 404!");
			   return;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// -------------------------
		if( mf != null ) {
			if(	mf.isForward() == true ) {
				RequestDispatcher rd = 
				request
				   .getRequestDispatcher(mf.getViewPath());
				rd.forward(request, response);// 포워드
			}
			else
				response.sendRedirect(mf.getViewPath());
		} else {
			response.sendError(
					HttpServletResponse
					.SC_INTERNAL_SERVER_ERROR 
					);  // 500
			System.out.println("mf null!!");
		}
		
		/* 응답 혹은 이동을 처리하는 방식...
		 *  1. 응답코드 보내기 res.sendError(code)
		 *  2. rd.forward, <jsp:forward 내부url>
		 *  3. rd.include, <jsp:include>
		 *  4. res.sendRedirect(내/외부url)
		 */  
		
		
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		doWWW(request, response);
		//doGet(request, response);
	}
}




