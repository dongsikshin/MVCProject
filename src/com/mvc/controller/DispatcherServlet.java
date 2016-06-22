/*
 * �� Ŭ������ �츮 ���ø����̼��� ��� ��û�� ���� , ���� �����̴�!!
 * 
 *  web, or application �̰� ��� ���α׷������� ��Ʈ�ѷ��� 5�� ����!!!
 *  1.��û�� �޴´� 
 *  2.��û�� �м��Ѵ� 
 *  3.�˸´� ������ �𵨿��� �����Ų��
 *  4.����� �ִٸ� ����� �޸𸮿� �����Ѵ�!! (���� ����)
 *  5.����� �����ش�
 * */
package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.context.ApplicationContext;
public class DispatcherServlet extends HttpServlet{
	ApplicationContext applicationContext;
	
	//������ �ν��Ͻ��� �޸𸮿� �����ɶ� ���� 1�� ȣ��Ǵ� �ʱ�ȭ �޼���!! 
	public void init(ServletConfig config){
		ServletContext context=config.getServletContext();
		String param=config.getInitParameter("contextConfigLocation");
		String path=context.getRealPath(param);
		applicationContext = new ApplicationContext(path);
	}
	
	//Ŭ���̾�Ʈ�� post ������� ��û�� �õ��ϸ� �� �޼��尡 �۵��Ѵ�.1!!
	//����, �� �޼��� ȣ����?  ������ ---> service ---> doPost
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	
	protected void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost ȣ����!");
		req.setCharacterEncoding("utf-8");//�Ķ������ �񿵾�� ���ڰ� ������ �ʵ���...
		resp.setCharacterEncoding("utf-8");//Ȥ�� �������� ����� ���� �ִٸ�..������
		//�ʰ� �ϱ� ����...(��Ģ�� ��Ʈ�ѷ��� ȭ�鿡 ���𰡸� �Ѹ��� �ȵȴ�..view�ƴϹǷ�)
		resp.setContentType("text/html");
		
		//2�ܰ� : Ŭ���̾�Ʈ�� ���� ���ϴ��� �˾ƾ� �𵨿��� ���� ��Ű�Ƿ�, ��û�м���
					// ����!!
		String uri=req.getRequestURI();
		System.out.println("Ŭ���̾�Ʈ�� uri�� "+uri);
		
		Controller controller=applicationContext.getController(uri);
		RequestDispatcher dispatcher=null;
		
		//���ǹ��� ������� ����, �ܺ��� ���������� �о�鿩, �ش� ��û�� ó���� 
		//���� ��Ʈ�ѷ� Ŭ������ ���� �޸𸮿� �÷��� ���۽�Ű��!!

		controller.execute(req, resp);
		
		String key=controller.getResultView();	
		String viewPage = applicationContext.getViewPage(key);
		
		if(controller.isForward()){
			dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, resp);
		}else{
			resp.sendRedirect(viewPage);
		}
	}
}






