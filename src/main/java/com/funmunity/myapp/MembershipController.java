package com.funmunity.myapp;

import com.funmunity.myapp.member.MemberDAO;
import com.funmunity.myapp.member.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("*/membership")
public class MembershipController {
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public MemberDTO login(@RequestParam("map")Map<String, String> map) {
        MemberDAO dao = new MemberDAO();
        try{
            MemberDTO dto = dao.userLogin(map.get("user_id"), map.get("user_pw"));

            return dto;
        }catch(Exception e){
            return null;
        }
    }
}