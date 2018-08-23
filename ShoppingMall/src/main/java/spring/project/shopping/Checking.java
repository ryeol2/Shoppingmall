package spring.project.shopping;

public class Checking {
	private static boolean adminCheck; // 클래스 멤버변수 선언 (실행 시작해서 끝날때까지 데이터 보유& 데이터를 공유한다.)
	private static boolean loginCheck;
	public Checking() {
		// TODO Auto-generated constructor stub
	}

	public boolean isAdminCheck() {
		return adminCheck;
	}

	public void setAdminCheck(boolean adminCheck) {
		Checking.adminCheck = adminCheck;
	}

	public boolean isLoginCheck() {
		return loginCheck;
	}

	public void setLoginCheck(boolean loginCheck) {
		Checking.loginCheck = loginCheck;
	}
	
	

	
}
