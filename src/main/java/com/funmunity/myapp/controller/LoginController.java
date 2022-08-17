package com.funmunity.myapp.controller;

import com.funmunity.myapp.member.MemberDAO;
import com.funmunity.myapp.member.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class LoginController {

    @Autowired
    MemberDAO memberDAO;
    @ResponseBody
    @RequestMapping(value = "**/user", method = RequestMethod.POST)
    public String login(MemberDTO data, HttpSession session, HttpServletResponse response) throws IOException {
        MemberDTO dto = memberDAO.userLogin(data.getUser_id(), data.getUser_pw());
        System.out.println("dto = " + dto);

        if (dto.getUser_id().equals(data.getUser_id())) {
            session.setAttribute("user_info", dto);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();

            out.println("<script language='javascript'>'");
            out.println("alert('로그인에 성공했습니다.')");
            out.println("</script>");
            out.close();

            return "성공했습니다";
        }else{
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();

            out.println("<script language='javascript'>'");
            out.println("alert('로그인에 실패했습니다.')");
            out.print("location.reload()");
            out.println("</script>");
            out.close();

            return "실패했습니다";
        }
    }
    @RequestMapping(value = "**/logout",method = RequestMethod.POST)
    public String logout(HttpSession session){
        session.removeAttribute("user_info");

        return "index";
    }
}