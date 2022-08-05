package com.funmunity.myapp.boardContent;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.funmunity.myapp.common.DBconnection;

public class PageDAO extends DBconnection{
	//1. 프론트에서 넘겨주는 값만 있다면 그 이후는 알아서 처리하게끔 if문을 통해 첫페이지와 아닌페이지에서 SQL문을 나눈다
	public PageDTO loadContent(String num, String board_cat) throws SQLException{
		String sql = "SELECT * FROM ( SELECT tb.*, ROWNUM rNum FROM ( SELECT * FROM user_board ";
		if(!board_cat.equals(null) && !board_cat.equals("")){
			return loadCatContent(num, board_cat, sql);

		};
		sql += " order by idx desc) tb ) WHERE rNum = ?";
		PageDTO dto = new PageDTO();
		psmt = con.prepareStatement(sql);
		
		psmt.setString(1, num);
		
		rs = psmt.executeQuery();
		
		if(rs.next()) {
			dto = DtoMaker(rs);
		}
		return dto;
	}

	private PageDTO loadCatContent(String num, String board_cat, String sql) throws SQLException {
		sql += " where board_cat = ? order by idx desc) tb ) where rNum = ?";
		PageDTO dto = new PageDTO();
		psmt = con.prepareStatement(sql);

		psmt.setString(1, board_cat);
		psmt.setString(2, num);

		rs = psmt.executeQuery();

		if(rs.next()){
			dto = DtoMaker(rs);
		}
		return dto;
	}



	public PageDTO ContentRetrun(String idx) throws SQLException{
		String sql = "SELECT * FROM user_board WHERE idx = ?";
		PageDTO dto = new PageDTO();
		psmt = con.prepareStatement(sql);

		psmt.setString(1, idx);

		rs = psmt.executeQuery();

		if(rs.next()) {
			dto = DtoMaker(rs);
		}
		return dto;
	}

	private PageDTO DtoMaker(ResultSet rs) throws SQLException{
		PageDTO dto = new PageDTO();
		dto.setIdx(rs.getString(1));
		dto.setTitle(rs.getString(2));
		dto.setContent(rs.getString(3));
		dto.setThumnail(rs.getString(4));
		dto.setPostdate(rs.getDate(5));
		dto.setWriter(rs.getString(6));
		dto.setViewcount(rs.getString(7));
		dto.setRecommandcount(rs.getString(8));
		dto.setBoard_cat(rs.getString(9));
		dto.setSub_cat(rs.getString(10));
		dto.setH_recommanded(rs.getString(11));
		dto.setK_recommanded(rs.getString(12));
		return dto;
	}
}