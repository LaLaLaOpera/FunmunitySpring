package com.funmunity.myapp.controller;

import com.funmunity.myapp.member.MemberDAO;
import com.funmunity.myapp.member.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class SignUpController {

    @Autowired
    MemberDAO memberDAO;
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void signup(MemberDTO dto, HttpSession session, HttpServletResponse response) throws Exception {

        int result = memberDAO.RegisterUser(dto);

    }

//    @RequestMapping
//    public String deleteUser(){
//
//
//        return "index";
//    }
}
