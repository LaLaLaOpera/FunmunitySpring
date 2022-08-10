package com.funmunity.myapp.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	SqlSession session;

	String namespace = "com.funmunity.myapp.comment.SubCommentMapper.";
	@Override
	public int RegisterUser(MemberDTO dto) {
		int result = 0;

		try {
			result = session.insert(namespace+"RegisterUser", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	@Override
	public MemberDTO userLogin(String user_id, String user_pw) {
		MemberDTO dto = new MemberDTO();
		Map<String, String> input  = new HashMap<>();
		input.put("user_id", user_id);
		input.put("user_pw",user_pw);

		try {
			dto = session.selectOne(namespace+"userLogin",input);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}
}
