package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	// 추상메서드
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException; // request, response 객체를 받는 추상메서드
}
