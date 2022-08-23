package com.funmunity.myapp.controller;


import com.funmunity.myapp.boardContent.PageDAO;
import com.funmunity.myapp.comment.CommentDAO;
import com.funmunity.myapp.comment.SubCommentDAO;
import com.funmunity.myapp.member.MemberDTO;
import com.funmunity.myapp.recommend.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("**/recommend")
public class RecommendController {

    CommentRecommendDAO commentRecommendDAO;
    SubCommentRecommendDAO subCommentRecommendDAO;
    PostRecommendDAO postRecommendDAO;

    CommentDAO commentDAO;
    SubCommentDAO subCommentDAO;

    PageDAO pageDAO;

    @Autowired
    private void autowiring(PageDAO pageDAO, CommentDAO commentDAO,
                            SubCommentDAO subCommentDAO,
                            PostRecommendDAO postRecommendDAO,
                            CommentRecommendDAO commentRecommendDAO,
                            SubCommentRecommendDAO subCommentRecommendDAO){
        this.pageDAO = pageDAO;
        this.commentDAO = commentDAO;
        this.subCommentDAO = subCommentDAO;
        this.subCommentRecommendDAO = subCommentRecommendDAO;
        this.commentRecommendDAO = commentRecommendDAO;
        this.postRecommendDAO = postRecommendDAO;
    }


    @ResponseBody
    @RequestMapping(value ="/comment", method = RequestMethod.POST)
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public String commentRecommend(CommentRecommendDTO dto, HttpSession session){
        System.out.println("여기까지 안오나?");
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("user_info");
        dto.setUser_id(memberDTO.getUser_id());
        int result = 0;
        try {
            result = commentRecommendDAO.insertCommentRecommend(dto);
        } catch (Exception e) {
            e.printStackTrace();
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
    @ResponseBody
    @RequestMapping(value ="/post", method = RequestMethod.POST)
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public String postRecommend(@RequestParam("idx") int idx, HttpSession session) throws Exception {
        System.out.println("여기까지 안오나?");
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("user_info");

        PostRecommendDTO dto = new PostRecommendDTO();
        dto.setIdx(idx);
        dto.setUser_id(memberDTO.getUser_id());
        int result = 0;
        try {
            result = postRecommendDAO.insertPostRecommend(dto);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        String cnt = "";
        if(result == 1){
            Map<String, Integer> input = new HashMap<>();
            input.put("idx", dto.getIdx());
            try {
                cnt = pageDAO.postRecommend(input);
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }
        System.out.println(cnt);
        return cnt;
    }

}