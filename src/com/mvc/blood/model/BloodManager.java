//��� �÷������� ����� �� �ִ� �߸��� �� Ŭ����!
//�ᱹ MVC ���Ͽ��� ��ȣ�ϰ��� �ϴ� ( ���߿� �� ��������� �ϴ�) ����� ?
// ���̴�!!
package com.mvc.blood.model;
public class BloodManager {
	
	public String getAdvice(String blood){
		String msg=null;
		
		if(blood.equals("A")){
			msg="�����ϰ� �����ϴ�";
		}else if(blood.equals("B")){
			msg="�������� ��������";
		}else if(blood.equals("AB")){
			msg="�Դ�, ���ٸ� �����δ�";
		}else if(blood.equals("O")){
			msg="�������� �������д�";
		}	
		return msg;
		
	}
}
