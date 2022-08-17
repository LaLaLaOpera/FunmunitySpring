package com.funmunity.myapp.controller;


import com.funmunity.myapp.comment.CommentDAO;
import com.funmunity.myapp.member.MemberDTO;
import com.funmunity.myapp.recommend.CommentRecommendDAO;
import com.funmunity.myapp.recommend.CommentRecommendDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/recommend")
public class RecommendController {

    @Autowired
    CommentRecommendDAO commentRecommendDAO;

    @Autowired
    CommentDAO commentDAO;

    @ResponseBody
    @RequestMapping(value ="/comment", method = RequestMethod.POST)
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public String commentRecommend(CommentRecommendDTO dto, HttpSession session){
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("user_info");
        dto.setUser_id(memberDTO.getUser_id());
        int result = 0;
        try {
            result = commentRecommendDAO.insertCommentRecommend(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String cnt = "";
        if(result == 1){
            Map<String, String> input = new HashMap<>();
            input.put("boardidx", dto.getBoardidx());
            input.put("idx", dto.getIdx());
            try {
                cnt = commentDAO.commentRecommend(input);
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }
        System.out.println(cnt);
        return cnt;
    }
}