package spring.project.shopping;

public class Checking {
	private static boolean adminCheck; // Ŭ���� ������� ���� (���� �����ؼ� ���������� ������ ����& �����͸� �����Ѵ�.)
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
