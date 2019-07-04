package ct.svc;
// FrontController에서 url 매핑후 분기 시
// 각 case별로 viewPath와 redirect 혹은 
// foward를 하는 상태를 담는 객체
// => 흐름제어에 사용됨
public class MyFlow {
	private String viewPath;
	 // 이동 경로 문자열
	private boolean isForward;
	 // 포워드 유무 , false라면 리다이렉트
	
	public MyFlow() {}
	public MyFlow(String viewPath, boolean isForward) {
		super();
		this.viewPath = viewPath;
		this.isForward = isForward;
	}	
	
	@Override
	public String toString() {
		return "MyFlow [viewPath=" + viewPath + ", isForward=" + isForward + "]";
	}
	
	public String getViewPath() {
		return viewPath;
	}
	public void setViewPath(String viewPath) {
		this.viewPath = viewPath;
	}
	public boolean isForward() {
		return isForward;
	}
	public void setForward(boolean isForward) {
		this.isForward = isForward;
	}
	
	
}

