package com.funmunity.myapp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.funmunity.myapp.boardContent.PageDAO;
import com.funmunity.myapp.boardContent.PageDTO;

@Controller
public class BoardController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		return "index";

	}
	@RequestMapping(value="/category", method = RequestMethod.GET)
	public String category(Model model, @RequestParam("board_cat") String board_cat){
		model.addAttribute("category", board_cat);
		return "category";
	}
	@ResponseBody
	@RequestMapping(value ="/load", method = RequestMethod.GET)
	public PageDTO loadBoard(@RequestParam("page") String page, @RequestParam("board_cat") String board_cat){
		PageDAO dao = new PageDAO();
		try {
			PageDTO dto = dao.loadContent(page, board_cat);
			dao.close();
			return dto;
		}catch(Exception e) {
			dao.close();
			e.printStackTrace();
			return null;
		}
	}
}