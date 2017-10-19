package cn.hr.ssm.interceptor;

import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginInterceptor implements HandlerInterceptor {

	//ִ��Handler��ɣ�ִ�д˷���
	//Ӧ�ó�����ͳһ���쳣������������ͳһ��־����
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception)
			throws Exception {
		System.out.println("LoginInterceptor.....afterCompletion");
	}

	//����Handler����֮�󣬷���modelAndView֮ǰִ��
	//Ӧ�ó�������ModelAndView����˼���������õ�ģ�����ݣ�����˵������������ﴫ����ͼ��Ҳ����������ͳһ�ƶ���ͼ
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView)
			throws Exception {
		System.out.println("LoginInterceptor.....postHandle");
	}

	//����Handler����֮ǰִ��
	//���������֤�������Ȩ
	//���磺�����֤�������֤ͨ����ʾ��ǰ�û�û�е�¼����Ҫ�˷������ز�������ִ��
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		System.out.println("LoginInterceptor.....preHandle");
		
		String url = request.getRequestURI();
		//�ж�url�Ƿ��ǹ�����ַ��ʵ��ʹ��ʱ��������ַ �����������ļ��У�
		//���﹫����ַ�ǵ�¼�ύ��ַ
		if(url.indexOf("login.action") >= 0) {
			//������е�¼�ύ ����
			return true;
		}
		
		//�ж�session
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		if(username != null) {
			return true;
		}
		
		//ִ�е������ʾ��֤ͨ������ת����¼����
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		
		//return false ��ʾ���أ���������ִ��
		//return true ��ʾ����
		return false;
	}

}
