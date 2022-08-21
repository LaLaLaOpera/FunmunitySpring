package com.funmunity.myapp.controller;
import com.funmunity.myapp.boardContent.PageDAO;
import com.funmunity.myapp.boardContent.PageDAOImpl;
import com.funmunity.myapp.category.CategoryDAO;
import com.funmunity.myapp.category.CategoryDTO;
import com.funmunity.myapp.member.MemberDTO;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.funmunity.myapp.boardContent.PageDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BoardController {

	@Autowired
	PageDAO pageDAO;

	@Autowired
	CategoryDAO categoryDAO;

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
	@GetMapping("**/categoryCreate")
	public String categoryCreate(HttpSession session){
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("user_info");
		if (memberDTO.getFun_point()<1000){
			return "index";
		}
		return "cat_create";
	}

	@PostMapping("**/categoryCreate")
	public void categoryCreate(CategoryDTO categoryDTO, HttpServletRequest request, Model model){

		int result = categoryDAO.insertCategory(categoryDTO);
		if (result ==1){
			category(model,categoryDTO.getCat_name());
		}else{
			
		}
	}

	@GetMapping("**/postUpload")
	public String postUpload(){

		return "postUpload";
	}
	@PostMapping("**/postUpload")
	public void postUpload(PageDTO pageDTO, HttpSession session){
		if (pageDTO.getThumnail() == null){
			pageDTO.setThumnail("");
		}
		pageDTO.setWriter(session.getId());
		pageDAO.pageInsert(pageDTO);
	}

	@ResponseBody
	@GetMapping("**/subcategory")
	public Map subCategoryQuery(@RequestParam("category") String category){
		Map subCategory  = categoryDAO.subCategorySearch(category);
		return subCategory;
	}
}