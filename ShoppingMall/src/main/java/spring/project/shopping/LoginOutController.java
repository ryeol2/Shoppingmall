package spring.project.shopping;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.project.shopping.login_service.LoginService;
import spring.project.shopping.userdto.UserDTO;

@Controller
public class LoginOutController {
	@Autowired
	private LoginService loginService;
	private String url;
	@Autowired
	private HttpSession session;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	private UserDTO user;
	private Checking checking = new Checking();
	//private boolean loginChecked = true;
	

	@RequestMapping("login")
	public String sLogin(Model model, HttpServletRequest request) throws NoSuchAlgorithmException {
//		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
//		generator.initialize(KEY_SIZE);
//		
//		KeyPair keyPair = generator.genKeyPair();
//		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//
//		PublicKey publicKey = keyPair.getPublic();
//		PrivateKey privateKey = keyPair.getPrivate();
//		
//		session = request.getSession();
//		session.setAttribute("rsaPrivateKey", privateKey);
		model.addAttribute("loginChecked", checking.isLoginCheck()); //로그인 실패하면 경고문구 띄우기위함.

		return "/Login/loginPage";
	}

	@RequestMapping(value = "login_user", method = RequestMethod.POST)
	public String loginChecked(UserDTO userDto, Model model,HttpServletRequest request) throws IOException {

		if (session.getAttribute("logined") != null) {
			session.removeAttribute("logined");
		}
String password = request.getParameter("userPwd");
		user = loginService.LoginCheck(userDto);

		if (user != null) {
			if(passwordEncoder.matches(password, user.getUserPwd())) {

			session.setAttribute("logined", user);

			url = "main";
			}
		} else {
			checking.setLoginCheck(false);

			url = "redirect:/login";
		}

		if (user != null) {
			if (user.getUserId().equals("admin")) {
				
				checking.setAdminCheck(true);
				System.out.println("admin계정 로그인 boolean 확인 : "+checking.isAdminCheck());
				
			}
		}

		return url;

		// 방법2.
		// String userId = request.getParameter("userId");
		// String userPwd = request.getParameter("userPwd");
		// UserDTO user=loginService.LoginCheck(userId);
		// if(user !=null) {
		// if(user.getUserId().equals(userId) && user.getUserPwd().equals(userPwd)) {
		// url = "main";
		// }else {
		// url ="redirect:/login";
		// }
		// }else {
		// url = "redirect:/login";
		// }
	}

	@RequestMapping("logOut")
	public String logOut() {
		// session.removeAttribute("logined");
		if(user.getUserId().equals("admin")) {
			checking.setAdminCheck(false);
			}
		session.invalidate();
		checking.setLoginCheck(true);
		
		return "main";
	}

}
