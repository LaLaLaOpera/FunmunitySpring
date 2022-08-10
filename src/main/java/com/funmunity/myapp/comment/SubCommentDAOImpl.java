package com.funmunity.myapp.comment;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SubCommentDAOImpl implements SubCommentDAO {

	@Autowired
	SqlSession session;

	String namespace = "com.funmunity.myapp.comment.SubCommentMapper.";

	@Override
	public int insertComment(SubCommentDTO dto) {

		try {
			return session.insert(namespace+"insertComment", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public String maxIdx (Map<String, String> map){
		String result  = session.selectOne(namespace+"maxSubIdx", map);

		if (result != null){
			return result;
		} else{
			return "1";
		}
	}


	@Override
	public Map<String,List<SubCommentDTO>> queryComment(String idx) {
		Map<String,List<SubCommentDTO>> subCommentList = new HashMap<>();
		int maxIdx = 0;

		try {
			maxIdx = Integer.parseInt((String) session.selectOne(namespace+"maxIdx", idx));
		} catch (NumberFormatException e) {
			System.out.println("댓글이 없음");
		}

		for (int i = 0; i<maxIdx; i++){
			List newList = new ArrayList();
			Map<String, String> input = new HashMap<>();
			input.put("idx", String.valueOf(i));
			input.put("boardidx", idx);

			newList = session.selectList(namespace+"queryComment", input);
			subCommentList.put(String.valueOf(i),newList);
		}
		return subCommentList;
	}
}
