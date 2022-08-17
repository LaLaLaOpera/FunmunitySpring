package com.funmunity.myapp.boardContent;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Map;
@Repository
public class PageDAOImpl implements PageDAO {

	@Autowired
	SqlSession session;

	String namespace = "com.funmunity.myapp.boardContent.PageMapper.";

	@Override
	public PageDTO loadContent(Map input){
//		String sql = "SELECT * FROM ( SELECT tb.*, ROWNUM rNum FROM ( SELECT * FROM user_board ";
//		if(!board_cat.equals(null) && !board_cat.equals("")){
//			return loadCatContent(num, board_cat, sql);
//
//		}
//		sql += " order by idx desc) tb ) WHERE rNum = ?";
//		PageDTO dto = new PageDTO();
//		psmt = con.prepareStatement(sql);
//
//		psmt.setString(1, num);
//
//		rs = psmt.executeQuery();
//
//		if(rs.next()) {
//			dto = DtoMaker(rs);
//		}
//		return dto;
		if (input.get("board_cat")!= null){
			try{
				return session.selectOne(namespace+"loadContent2", input);
			}catch (Exception e){
				e.printStackTrace();
			}
		}else{
			try {
				return session.selectOne(namespace+"loadContent", input);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

//	private PageDTO loadCatContent(String num, String board_cat, String sql) throws SQLException {
//		sql += " where board_cat = ? order by idx desc) tb ) where rNum = ?";
//		PageDTO dto = new PageDTO();
//		psmt = con.prepareStatement(sql);
//
//		psmt.setString(1, board_cat);
//		psmt.setString(2, num);
//
//		rs = psmt.executeQuery();
//
//		if(rs.next()){
//			dto = DtoMaker(rs);
//		}
//		return dto;
//	}
	@Override
	public PageDTO ContentRetrun(String idx){
		return session.selectOne(namespace+"ContentReturn",idx);
	}

	@Override
	public int pageInsert(PageDTO dto){

		return session.insert(namespace+"pageInsert",dto);
	}
}