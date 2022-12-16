package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.nonage.dto.AddressVO;

import util.DBManager;

public class MemberDAO {
	
	// 싱글톤 패턴
	// 1. private한 멤버 변수가 있다.
	// 2. private한 생성자가 있다.
	// 3. public static한 메소드가 있다.
	// 4. 직접 생성이 불가하다.
	// 5. 클래스 자신이 생성한 정보를 return 한다.
	
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		
		return instance;
	}
	
	public int confirmID(String id) {
		int result = -1;
		String sql = "select * from Member where id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1; // request영역에서 받아온 매개변수가 이미 데이터베이스에 있는 아이디일 때 1을 반환
			} else {
				result = -1; // 사용하고 있는 아이디가 없을 때
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	
}
