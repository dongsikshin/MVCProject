//��� �÷������� ����� �� �ִ� �߸��� �� Ŭ����!
//�ᱹ MVC ���Ͽ��� ��ȣ�ϰ��� �ϴ� ( ���߿� �� ��������� �ϴ�) ����� ?
// ���̴�!!
package com.mvc.movie.model;
public class MovieManager {
	
	public String getAdvice(String movie){
		String msg=null;
		
		if(movie.equals("���ۺ�")){
			msg="3D�� �þ�?";
		}else if(movie.equals("������ ����Į����")){
			msg="������ �ø����� �����̾�";
		}else if(movie.equals("��ũ����Ʈ")){
			msg="��ũ����Ʈ";
		}else if(movie.equals("������")){
			msg="������1 ���� ������?";
		}else if(movie.equals("�")){
			msg="� ���� ����!";
		}		
		return msg;
		
	}
}
