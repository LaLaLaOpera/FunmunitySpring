package com.funmunity.myapp.pageview;

import com.funmunity.myapp.boardContent.PageDAO;
import com.funmunity.myapp.boardContent.PageDAOImpl;
import com.funmunity.myapp.boardContent.PageDTO;
import com.funmunity.myapp.comment.*;
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
	PageDAO pageDAO;
	@Autowired
	CommentDAO commentdao;

	@Autowired
	SubCommentDAO subCommentDAO;

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String home(Model m, @RequestParam String idx) throws SQLException {

		PageDTO Contentdto = pageDAO.ContentRetrun(idx);

		List<CommentDTO> commentList = commentdao.queryComment(idx);

		Map<String, List<SubCommentDTO>> subCommentMap = subCommentDAO.queryComment(idx);

		m.addAttribute("Contentdto", Contentdto);

		m.addAttribute("commentList", commentList);
		m.addAttribute("subCommentMap", subCommentMap);
		return "view";
	}
}