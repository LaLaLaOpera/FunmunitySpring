package com.funmunity.myapp.controller;

import com.funmunity.myapp.comment.CommentDAO;
import com.funmunity.myapp.comment.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    CommentDAO commentdao;
    @ResponseBody
    @RequestMapping(value ="/comment", method = RequestMethod.POST)
    public CommentDTO insertComment(CommentDTO dto) throws Exception {
        dto.setContent(dto.getContent().replaceAll("\r\n", "<br>"));
        System.out.println("dto = " + dto);
        String idx = commentdao.maxIdx(dto.getBoardidx());
        commentdao.maxIdx(dto.getBoardidx());
        try {
            idx = String.valueOf(Integer.parseInt(commentdao.maxIdx(dto.getBoardidx()))+1);
        }catch(Exception e) {
            System.out.println("게시물의 첫댓글");
        }

        dto.setIdx(idx);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        int result = commentdao.insertComment(dto);
        dto = commentdao.singleComment(dto);
        String date = format.format(dto.getPostdate());
        Date date1 = format.parse(date);
        dto.setPostdate(date1);
        System.out.println("dto = " + dto);
        System.out.println(dto.getPostdate());
        if (result != 1){
            throw new Exception();
        }
        return dto;
    }
}
