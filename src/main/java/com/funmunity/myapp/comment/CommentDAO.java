package com.funmunity.myapp.comment;

import java.util.List;

public interface CommentDAO {



    int insertComment(CommentDTO dto);

    List<CommentDTO> queryComment(String idx);

    String maxIdx(String idx);


    CommentDTO singleComment(CommentDTO commentDTO);
}
