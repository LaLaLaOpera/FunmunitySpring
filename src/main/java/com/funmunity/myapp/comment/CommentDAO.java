package com.funmunity.myapp.comment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CommentDAO {
    int insertComment(CommentDTO dto);

    List<CommentDTO> queryComment(String idx);

    String maxIdx(String idx);

    CommentDTO singleComment(String boardidx, String idx);

    CommentDTO dtoMaker(ResultSet rs) throws SQLException;
}
