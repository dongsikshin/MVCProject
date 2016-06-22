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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.blood.controller.BloodController;
import com.mvc.movie.controller.MovieController;
public class DispatcherServlet extends HttpServlet{
	
	
	
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
		
		Controller controller=null;
		RequestDispatcher dispatcher=null;
		if(uri.equals("/movie/movie.do")){
			controller = new MovieController();
			dispatcher = req.getRequestDispatcher("/movie/result.jsp");
		}else if(uri.equals("/blood/blood.do")){
			controller = new BloodController();
			dispatcher = req.getRequestDispatcher("/blood/result.jsp");		
		}
		controller.execute(req, resp);
		dispatcher.forward(req, resp);
	}
}






