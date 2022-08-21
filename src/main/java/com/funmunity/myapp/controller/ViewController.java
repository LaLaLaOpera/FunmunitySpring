package com.funmunity.myapp.controller;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class ViewController {


	PageDAO pageDAO;
	CommentDAO commentDAO;

	SubCommentDAO subCommentDAO;

	@Autowired
	private void autowiring(PageDAO pageDAO, CommentDAO commentDAO, SubCommentDAO subCommentDAO){
		this.pageDAO = pageDAO;
		this.commentDAO = commentDAO;
		this.subCommentDAO = subCommentDAO;
	}
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String home(Model m, @RequestParam String idx) throws SQLException {

		PageDTO Contentdto = pageDAO.ContentRetrun(idx);

		List<CommentDTO> commentList = commentFilter(commentDAO.queryComment(idx));

		Map<String, List<SubCommentDTO>> subCommentMap = subCommentDAO.queryComment(idx);

		m.addAttribute("Contentdto", Contentdto);

		m.addAttribute("commentList", commentList);
		m.addAttribute("subCommentMap", subCommentMap);
		return "view";
	}

	private List<CommentDTO> commentFilter(List<CommentDTO> commentDTOS){
		List<CommentDTO> newCommentList = new ArrayList<>();
		for (CommentDTO commentDTO : commentDTOS){
			Date date = commentDTO.getPostdate();
			commentDTO.setSimpleDate(dateFilter(date));
			newCommentList.add(commentDTO);
		}
		return newCommentList;
	}
	private String dateFilter(Date postdate){
		Date simDa = new Date();
		int diff = (int)simDa.getTime() - (int)(postdate.getTime());
		int second = diff/1000;
		if (second < 60) return "방금 전";
		int minute = second/60;
		if (minute < 60) return String.valueOf(minute)+"분 전";
		int hour = minute/60;
		if (hour < 24) return String.valueOf(hour)+"시간 전";
		int day = hour/24;
		if (day <30) return String.valueOf(day)+"일 전";
		int month = day/30;
		if (month <12) return String.valueOf(month)+"달 전";
		int year = month/12;
		return String.valueOf(year)+"년 전";
	}
}