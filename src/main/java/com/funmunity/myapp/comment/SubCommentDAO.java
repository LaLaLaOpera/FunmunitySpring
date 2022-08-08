package com.funmunity.myapp.comment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.funmunity.myapp.common.DBconnection;

public class SubCommentDAO extends DBconnection {
	public int insertComment(SubCommentDTO dto) {
		int result = 0;
		String query = "Insert into subcomment (boardidx, commentidx, writer, content, mention) values(?,?,?,?,?)";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getBoardidx());
			psmt.setString(2, dto.getCommentidx());
			psmt.setString(3, dto.getWriter());
			psmt.setString(4, dto.getContent());
			psmt.setString(5, dto.getMention());
			
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public Map<String,List<SubCommentDTO>> queryComment(String idx) {
		Map<String,List<SubCommentDTO>> subCommentsList = new HashMap<String,List<SubCommentDTO>>();
		
		String query = "Select Max(idx) from user_comment where boardidx = ?";
		int result = 0;
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(Exception e) {
			System.out.println("코멘트 수를 세다가 오류");
			e.printStackTrace();
		}
		
		for (int i = 1; i<=result;i++) {
			List<SubCommentDTO> newList = new Vector<SubCommentDTO>();
			query = "Select * from subcomment where commentidx = ? AND boardidx = ? ORDER BY POSTDATE";
			try {
				psmt = con.prepareStatement(query);
				psmt.setString(1,String.valueOf(i));
				psmt.setString(2,idx);
				rs = psmt.executeQuery();
				
				while(rs.next()){
					
					newList.add(dtomaker(rs));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			subCommentsList.put(String.valueOf(i), newList);
		}
		return subCommentsList;
	}

	private SubCommentDTO dtomaker(ResultSet rs) throws SQLException {
		SubCommentDTO dto = new SubCommentDTO();
		dto.setBoardidx(rs.getString("boardidx"));
		dto.setCommentidx(rs.getString("commentidx"));
		dto.setContent(rs.getString("content"));
		dto.setContent(dto.getContent().replaceAll("\r\n", "<br>"));
		dto.setMention(rs.getString("mention"));
		dto.setPostdate(rs.getDate("postdate"));
		dto.setRecommended(rs.getString("recommended"));
		dto.setWriter(rs.getString("writer"));

		return dto;
	}
}
