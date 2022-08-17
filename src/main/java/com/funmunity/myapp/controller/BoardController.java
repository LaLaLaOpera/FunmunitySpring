package com.funmunity.myapp.controller;
import com.funmunity.myapp.boardContent.PageDAO;
import com.funmunity.myapp.boardContent.PageDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.funmunity.myapp.boardContent.PageDTO;

import java.util.HashMap;
import java.util.Map;

@Controller
public class BoardController {

	@Autowired
	PageDAO pageDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		return "index";

	}
	@RequestMapping(value="/category/{board_cat}", method = RequestMethod.GET)
	public String category(Model model, @PathVariable String board_cat){
		model.addAttribute("category", board_cat);
		return "category";
	}
	@ResponseBody
	@RequestMapping(value ="/load", method = RequestMethod.GET)
	public PageDTO loadBoard(@RequestParam("page") String page){
		try {
			Map<String, String> input = new HashMap<>();
			input.put("page", page);
			PageDTO dto = pageDAO.loadContent(input);
			return dto;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@ResponseBody
	@RequestMapping(value ="**/{board_cat}/catload", method = RequestMethod.GET)
	public PageDTO loadBoard(@RequestParam("page") String page, @PathVariable String board_cat){
		try {
			Map<String, String> input = new HashMap<>();
			input.put("page", page);
			if (board_cat != null){
				input.put("board_cat", board_cat);
			}else{
				throw new RuntimeException();
			}
			PageDTO dto = pageDAO.loadContent(input);
			return dto;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}