package com.funmunity.myapp;

import com.funmunity.myapp.comment.CommentDAO;
import com.funmunity.myapp.comment.CommentDTO;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.stream.events.Comment;
import java.util.Map;

@Controller
public class CommentController {
    @ResponseBody
    @RequestMapping(value ="/comment", method = RequestMethod.POST)
    public CommentDTO insertComment(CommentDTO dto) throws Exception {
        System.out.println(dto.toString());
        CommentDAO dao = new CommentDAO();
        String idx = "1";
        try {
            idx = String.valueOf(Integer.parseInt(dao.maxIdx(dto.getBoardidx()))+1);
        }catch(Exception e) {
            System.out.println("게시물의 첫댓글");
        }

        dto.setIdx(idx);

        int result = dao.insertComment(dto);

        dto = dao.singleComment(dto.getBoardidx(),idx);
        dao.close();

        if (result != 1){
            throw new Exception();
        }
        return dto;
    }

}
