/*
 * ��ü ��Ʈ�ѷ��� ������Ʈ ��, �� 3�ܰ踦 �����ϴ� ���� ��Ʈ�ѷ�!!
 * */
package com.mvc.movie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.controller.Controller;
import com.mvc.movie.model.MovieManager;

public class MovieController implements Controller{
	
	//3�ܰ�:����Ͻ� ���� ��ü�� �� ��Ų��!!
	public void execute(HttpServletRequest request , HttpServletResponse response){
		MovieManager manager = new MovieManager();
		String movie=request.getParameter("movie");
		String msg=manager.getAdvice(movie);
		
		//4�ܰ�
		request.setAttribute("msg", msg); //��û scope �������� ����!!
	}
}









