package com.funmunity.myapp.comment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.funmunity.myapp.common.DBconnection;

import javax.xml.stream.events.Comment;

public class CommentDAO extends DBconnection {
	public int insertComment(CommentDTO dto) {
		int result = 0;
		String query = "Insert into user_comment (boardidx, idx, writer, content) values(?,?,?,?)";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getBoardidx());
			psmt.setString(2, dto.getIdx());
			psmt.setString(3, dto.getWriter());
			psmt.setString(4, dto.getContent());
			
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<CommentDTO> queryComment(String idx){
		List<CommentDTO> commentList = new Vector<CommentDTO>();
		String query = "Select * from user_comment where boardidx = ? order by IDX";
		try {
			psmt = con.prepareStatement(query);
			
			psmt.setString(1, idx);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				commentList.add(dtoMaker(rs));
			}
		}catch(Exception e) {
			
		}
		return commentList;
	}
	
	public String maxIdx(String idx) {
		String maxIdx = "1";
	
		String query = "SELECT MAX(idx) FROM USER_COMMENT WHERE BOARDIDX = ?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				maxIdx = rs.getString(1);
			}
		}catch(Exception e) {
			System.out.println("댓글 최대값을 찾는중 오류 발생");
			e.printStackTrace();
		}
		return maxIdx;
	}

	public CommentDTO singleComment(String boardidx, String idx){
		String sql = "Select * from user_comment where idx = ? and BOARDIDX = ?";
		try{
			psmt = con.prepareStatement(sql);
			psmt.setString(1,idx);
			psmt.setString(2, boardidx);
			rs = psmt.executeQuery();
			if(rs.next()){
				return(dtoMaker(rs));
			}

		}catch(Exception e){
			System.out.println("코멘트를 찾아오다 오류 발생");
		}
		return null;
	}


	public CommentDTO dtoMaker(ResultSet rs) throws SQLException {
		CommentDTO dto = new CommentDTO();

		dto.setBoardidx(rs.getString("boardidx"));
		dto.setIdx(rs.getString("idx"));
		dto.setContent(rs.getString("content"));
		dto.setContent(dto.getContent().replaceAll("\r\n", "<br>"));
		dto.setPostdate(rs.getDate("postdate"));
		dto.setRecommended(rs.getString("RECOMMENDED"));
		dto.setWriter(rs.getString("writer"));

		return dto;
	}
}
