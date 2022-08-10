package com.funmunity.myapp.comment;

import java.util.List;
import java.util.Map;

public interface SubCommentDAO {
    int insertComment(SubCommentDTO dto);

    Map<String, List<SubCommentDTO>> queryComment(String idx);
}
