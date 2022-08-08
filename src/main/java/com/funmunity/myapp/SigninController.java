package com.funmunity.myapp;

import com.funmunity.myapp.member.MemberDAO;
import com.funmunity.myapp.member.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class SigninController {
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public void signup(MemberDTO dto, HttpSession session, HttpServletResponse response) throws Exception {
        MemberDAO dao = new MemberDAO();

        int result = dao.RegisterUser(dto);
        dao.close();
        if(result == 1){
            LoginController loginController = new LoginController();
            try {
                loginController.login(dto, session, response);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("로그인 오류");
            }
        }else{
            System.out.println("회원등록 실패");
            throw new Exception();
        }
    }

//    @RequestMapping
//    public String deleteUser(){
//
//
//        return "index";
//    }
}
