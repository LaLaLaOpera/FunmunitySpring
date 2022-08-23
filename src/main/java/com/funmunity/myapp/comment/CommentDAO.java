package com.funmunity.myapp.comment;

import java.util.List;
import java.util.Map;

public interface CommentDAO {



    int insertComment(CommentDTO dto);

    List<CommentDTO> queryComment(String idx);

    String maxIdx(String idx);


    CommentDTO singleComment(CommentDTO commentDTO);

    String commentRecommend(Map<String, String> map);
}
