package com.funmunity.myapp.pageview;

import com.funmunity.myapp.boardContent.PageDAO;
import com.funmunity.myapp.boardContent.PageDTO;
import com.funmunity.myapp.comment.CommentDAO;
import com.funmunity.myapp.comment.CommentDTO;
import com.funmunity.myapp.comment.SubCommentDAO;
import com.funmunity.myapp.comment.SubCommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
public class ViewController {
	@Autowired
	CommentDAO commentdao;

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String home(Model m, @RequestParam String idx) throws SQLException {
		PageDAO Contentdao = new PageDAO();

		PageDTO Contentdto = Contentdao.ContentRetrun(idx);


		List<CommentDTO> commentList = commentdao.queryComment(idx);
		SubCommentDAO subCommentdao = new SubCommentDAO();


		Map<String, List<SubCommentDTO>> subCommentMap = subCommentdao.queryComment(idx);


		Contentdao.close();
		subCommentdao.close();

		m.addAttribute("Contentdto", Contentdto);

		m.addAttribute("commentList", commentList);
		m.addAttribute("subCommentMap", subCommentMap);
		return "view";
	}
}