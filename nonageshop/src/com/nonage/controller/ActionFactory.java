package com.nonage.controller;

import com.nonage.controller.action.Action;
import com.nonage.controller.action.IndexAction;
import com.nonage.controller.action.ProductDetailAction;
import com.nonage.controller.action.ProductKindAction;

public class ActionFactory { // 역할 : 프론트 컨트롤러가 넘겨주는 정보를 받아서 액션 컨트롤러에 연결해준다.
	
	// 싱글톤 패턴
	// 1. private한 멤버 변수가 있다.
	// 2. private한 생성자가 있다. 
	// 3. public static한 메소드가 있다.
	// 4. 직접 생성이 불가하다.
	// 5. 클래스 자신이 생성한 정보를 return 한다.
	private static ActionFactory instance = new ActionFactory(); // 자기 자신을 생성
	
	private ActionFactory() { // 생성자는 외부에서 호출하지 못하도록 private로 지정
		
	}
	
	public static ActionFactory getInstance() { // static한 메서드 - 자기 자신을 return함.
		return instance;
	}
	
	public Action getAction(String command) {
		
		Action action = null;
		System.out.println("ActionFactory : " + command );
		
		if(command.equals("index")) {
			action = new IndexAction();
		} else if(command.equals("product_detail")) {
			action = new ProductDetailAction();
		} else if (command.equals("catagory")) {
			 action = new ProductKindAction();
		 }
		return action;
	}
	
	
}
