package spring.project.shopping.userdto;

public class UserDTO {
	private String userId;
	private String userPwd;
	private String userName;
	private String userEmail;
	private String userAdds;
	private String userIp;

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String userId, String userPwd, String userName, String userEmail, String userAdds, String userIp) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAdds = userAdds;
		this.userIp = userIp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAdds() {
		return userAdds;
	}

	public void setUserAdds(String userAdds) {
		this.userAdds = userAdds;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

}
