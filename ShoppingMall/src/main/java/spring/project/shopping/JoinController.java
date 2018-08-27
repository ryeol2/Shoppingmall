package spring.project.shopping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import spring.project.shopping.join_service.JoinService;
import spring.project.shopping.userdto.UserDTO;

@Controller
public class JoinController {
	@Autowired
	private JoinService joinService;
@Autowired
private BCryptPasswordEncoder passwordEncoder;
	@RequestMapping(value = "joinSuccess", method = RequestMethod.POST)
	public String sJoin(HttpServletRequest request) {

		request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		String userId = request.getParameter("userId");
		String userPwd = passwordEncoder.encode(request.getParameter("userPwd"));
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail_id") + request.getParameter("userEmail");
		String userAdds = request.getParameter("userAdds");
		String userIp = request.getHeader("X-FORWARDED-FOR");

		if (userIp == null || userIp.length() == 0 || "unknown".equalsIgnoreCase(userIp)) {
			userIp = request.getHeader("Proxy-Client-userIp");
		}
		if (userIp == null || userIp.length() == 0 || "unknown".equalsIgnoreCase(userIp)) {
			userIp = request.getHeader("WL-Proxy-Client-userIp");
		}
		if (userIp == null || userIp.length() == 0 || "unknown".equalsIgnoreCase(userIp)) {
			userIp = request.getHeader("HTTP_CLIENT_userIp");
		}
		if (userIp == null || userIp.length() == 0 || "unknown".equalsIgnoreCase(userIp)) {
			userIp = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (userIp == null || userIp.length() == 0 || "unknown".equalsIgnoreCase(userIp)) {
			userIp = request.getRemoteAddr();
		}
		UserDTO user = new UserDTO(userId, userPwd, userName, userEmail, userAdds, userIp);
		joinService.joinUser(user);

		return "redirect:/main";
	}

	@RequestMapping(value = "idCheck", method = RequestMethod.GET)
	public @ResponseBody UserDTO idChecking(@RequestParam("userId") String userId) throws Exception {
		System.out.println("getParameter : "+userId);
		UserDTO userDto = joinService.idCheck(userId);
		
		return userDto;

	}

}
