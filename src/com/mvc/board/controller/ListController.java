package com.mvc.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.model.BoardDAO;
import com.mvc.controller.Controller;

public class ListController implements Controller{
	BoardDAO board;
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//3�ܰ�: �˸´� ����Ͻ� ���� ��ü�� �� ��Ų��!!
		board = new BoardDAO();
		List list=board.selectAll();
		
		//4�ܰ�: ��� ������ ���� �մٸ� �޸� �� ��� ���� 
		request.setAttribute("list",list);		
	}

	public String getResultView() {
		return "/board/list/view";
	}

	@Override
	public boolean isForward() {
		return true;
	}
	
}
