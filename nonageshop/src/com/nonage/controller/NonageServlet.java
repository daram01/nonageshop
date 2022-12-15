package com.nonage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.controller.action.Action;


@WebServlet("/NonageServlet") // 프론트 컨트롤러 역할을 하게 됨. 아파트의 경비원 같은 것.
public class NonageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NonageServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트로부터 command 요청을 받는다.
		String command = request.getParameter("command");
		// 리퀘스트 영역에서 command의 값을 받아온 뒤 변수에 담는다. (.jsp에 작성되어있음.)
		System.out.println("NonageServlet에서 요청을 받음을 확인 : " + command);
		// 받아온 command 값 출력
		
		// 2. ActionFactory에 요청 전달 - 명령
		ActionFactory af = ActionFactory.getInstance(); // ActionFactory 객체 생성하여 af에 담는다. 
		Action action = af.getAction(command); // ActionFactory의 getAction 메서드 호출. 
		
		// 3. 전달받은 actionController를 실행한다.
		if(action != null) {
			action.execute(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // post 방식은 get과 다르게 한글 깨짐 방지 꼭 해주어야 한다.
		doGet(request,response);
	}

}
