package cn.hr.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class HandlerInterceptor1 implements HandlerInterceptor {

	//ִ��Handler��ɣ�ִ�д˷���
	//Ӧ�ó�����ͳһ���쳣������������ͳһ��־����
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception)
			throws Exception {
		System.out.println("HandlerInterceptor1.....afterCompletion");
	}

	//����Handler����֮�󣬷���modelAndView֮ǰִ��
	//Ӧ�ó�������ModelAndView����˼���������õ�ģ�����ݣ�����˵������������ﴫ����ͼ��Ҳ����������ͳһ�ƶ���ͼ
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView)
			throws Exception {
		System.out.println("HandlerInterceptor1.....postHandle");
	}

	//����Handler����֮ǰִ��
	//���������֤�������Ȩ
	//���磺�����֤�������֤ͨ����ʾ��ǰ�û�û�е�¼����Ҫ�˷������ز�������ִ��
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		System.out.println("HandlerInterceptor1.....preHandle");
		//return false ��ʾ���أ���������ִ��
		//return true ��ʾ����
		return true;
	}

}
