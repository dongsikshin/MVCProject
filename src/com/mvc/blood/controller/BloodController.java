/*
 * ��ü ��Ʈ�ѷ��� ������Ʈ ��, �� 3�ܰ踦 �����ϴ� ���� ��Ʈ�ѷ�!!
 * */
package com.mvc.blood.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.blood.model.BloodManager;
import com.mvc.controller.Controller;

public class BloodController implements Controller{
						/* is a ���谡 �����Ǹ鼭, �� �ڷ����� Controller���� �Ǿ����*/
	
	//3�ܰ�:����Ͻ� ���� ��ü�� �� ��Ų��!!
	public void execute(HttpServletRequest request , HttpServletResponse response){
		BloodManager manager = new BloodManager();
		String blood=request.getParameter("blood");
		String msg=manager.getAdvice(blood);
		
		//4�ܰ�
		request.setAttribute("msg", msg); //��û scope �������� ����!!
	}
	@Override
	public String getResultView() {
		return "/blood/view";
	}
	
	@Override
	public boolean isForward() {
		return true; //��û ����!!
	}
}









