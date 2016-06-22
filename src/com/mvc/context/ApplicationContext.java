/*
 * �������� ���߱� ����, ������ ���ø����̼ǿ��� ����� ��� ��ü�� 
 * �ܺ��� �������Ϸ� �����ϰڴ�!! 
 * ���⼭ ���������̶� java�� Ŭ������ �ƴ� �Ϲ� �ؽ�Ʈ����, xml, json...��Ÿ
 * �ؽ�Ʈ����� �����̸� �������!!
 * 
 * �������� �ڹ� ���α׷����� �ܺ� �ڿ��� ������ �о���̱� ���ؼ��� ��Ʈ�����
 * �ʿ��ϴ�!!
 * */
package com.mvc.context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.mvc.controller.Controller;

public class ApplicationContext {
	FileInputStream fis; //������ �о���� �� �ִ� ��Ʈ�� 
	Properties props; //��Ʈ������ �о���� �����  key=value�� �Ǿ����� ��� 
	//�ش� �����͸� �ؼ��� �� �ִ� ��ü...
	
	//�� �����ڸ� ȣ���ϴ� �ڰ� ��θ� �Ѱ���� �Ѵ�!! 
	public ApplicationContext(String path) {
		try {
			fis = new FileInputStream(path);
			props = new Properties();
			
			props.load(fis);
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//Ŭ���̾�Ʈ�� ��û�� ����, �˸´� ���� ��Ʈ�ѷ��� ��ȯ�ϴ� �޼��� 
	public Controller getController(String uri){
		String className=props.getProperty(uri); 
		
		//new�����ڸ��� �ν��Ͻ��� �޸𸮿� ������ �� �մ°��� �ƴϴ�!! (�������� ������)
		Controller obj=null;
		try {
			Class controllerClass=Class.forName(className);//Ŭ���� �ε�!!
			obj = (Controller)controllerClass.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	//���� �������� ��ȯ 
	public String getViewPage(String key){
		return props.getProperty(key);
	}
}













