package com.funmunity.myapp;

import com.funmunity.myapp.comment.SubCommentDAO;
import com.funmunity.myapp.comment.SubCommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SubcommentController {

    @Autowired
    SubCommentDAO subCommentDAO;


    @ResponseBody
    @RequestMapping(value ="/subcomment", method = RequestMethod.POST)
    public SubCommentDTO insertComment(SubCommentDTO dto) throws Exception {
        System.out.println(dto.toString());
        if (dto.getMention() == null){
            dto.setMention("");
        }
        Map<String, String> input = new HashMap<>();
        input.put("boardIdx", dto.getBoardidx());
        input.put("commentIdx",dto.getCommentidx());

        String maxIdx = subCommentDAO.maxIdx(input);
        dto.setIdx(maxIdx);
        System.out.println("dto = " + dto);
        subCommentDAO.insertComment(dto);
        dto.setRecommended("0");
        Date date = new Date();

        long timeInMilliSeconds = date.getTime();
        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);

        dto.setPostdate(date1);
        return dto;
    }
}