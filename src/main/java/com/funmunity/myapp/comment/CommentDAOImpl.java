package com.funmunity.myapp.comment;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	SqlSession session;

	String namespace = "com.funmunity.myapp.comment.CommentMapper.";


	@Override
	public int insertComment(CommentDTO dto) {
		try {
			return session.insert(namespace+"insertComment",dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public List<CommentDTO> queryComment(String idx){

		return session.selectList(namespace+"queryComment",idx);
	}

	@Override
	public String maxIdx(String idx) {
		String maxIdx = "1";

//		String query = "SELECT MAX(idx) FROM USER_COMMENT WHERE BOARDIDX = ?";
//
//		try {
//			psmt = con.prepareStatement(query);
//			psmt.setString(1, idx);
//			rs = psmt.executeQuery();
//
//			if(rs.next()) {
//				maxIdx = rs.getString(1);
//			}
//		}catch(Exception e) {
//			System.out.println("댓글 최대값을 찾는중 오류 발생");
//			e.printStackTrace();
//		}
//		return maxIdx;
		if(session.selectOne(namespace+"maxIdx",idx)==null){
			return maxIdx;
		}
		return session.selectOne(namespace+"maxIdx",idx);
	}

	@Override
	public CommentDTO singleComment(CommentDTO commentDTO){
//		String sql = "Select * from user_comment where idx = ? and BOARDIDX = ?";
//		try{
//			psmt = con.prepareStatement(sql);
//			psmt.setString(1,idx);
//			psmt.setString(2, boardidx);
//			rs = psmt.executeQuery();
//			if(rs.next()){
//				return(dtoMaker(rs));
//			}
//
//		}catch(Exception e){
//			System.out.println("코멘트를 찾아오다 오류 발생");
//		}
//		return null;

		return session.selectOne(namespace+"singleComment", commentDTO);
	}
	public String commentRecommend(Map<String, String> map){
		session.update(namespace+"recommendUpdate", map);

		return session.selectOne(namespace+"commentRecommend", map);
	}

}
