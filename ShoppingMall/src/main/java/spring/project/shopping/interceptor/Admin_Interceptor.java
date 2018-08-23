package spring.project.shopping.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import spring.project.shopping.Checking;

public class Admin_Interceptor extends HandlerInterceptorAdapter {
	private Checking checkClass;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		checkClass = new Checking();
		boolean adminCheck = checkClass.isAdminCheck();
		System.out.println("인터셉터class boolean 확인 : "+adminCheck);
		if(request.getSession().getAttribute("logined") != null) {
			if(adminCheck) {
				
				return true;
			}else {
				response.sendRedirect(request.getContextPath()+"/main");
				return false;
			}
			
		}else {
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
		
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
}
