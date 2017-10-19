package cn.hr.ssm.interceptor;

import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginInterceptor implements HandlerInterceptor {

	//执行Handler完成，执行此方法
	//应用场景：统一的异常处理，，还可以统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception)
			throws Exception {
		System.out.println("LoginInterceptor.....afterCompletion");
	}

	//进入Handler方法之后，返回modelAndView之前执行
	//应用场景：从ModelAndView出发思考，将公用的模型数据（比如菜单导航）在这里传到视图，也可以在这里统一制定视图
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView)
			throws Exception {
		System.out.println("LoginInterceptor.....postHandle");
	}

	//进入Handler方法之前执行
	//进行身份认证，身份授权
	//比如：身份认证，如果认证通过表示当前用户没有登录，需要此方法拦截不再向下执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		System.out.println("LoginInterceptor.....preHandle");
		
		String url = request.getRequestURI();
		//判断url是否是公开地址（实际使用时将公开地址 配置在配置文件中）
		//这里公开地址是登录提交地址
		if(url.indexOf("login.action") >= 0) {
			//如果进行登录提交 放行
			return true;
		}
		
		//判断session
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		if(username != null) {
			return true;
		}
		
		//执行到这里，表示验证通过，跳转到登录界面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		
		//return false 表示拦截，不再向下执行
		//return true 表示放行
		return false;
	}

}
