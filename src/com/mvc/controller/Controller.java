package com.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//3,4�ܰ� �����ϴ� �޼��� 
	public void execute(HttpServletRequest request, HttpServletResponse response);
	
	//� �並 ������������� �����ϴ� �޼���!!
	public String getResultView();
	
	//�����̷�Ʈ ����, Ȥ�� ������ ���� 
	public boolean isForward();
	
}
