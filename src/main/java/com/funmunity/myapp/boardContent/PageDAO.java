package com.funmunity.myapp.boardContent;

import java.sql.SQLException;
import java.util.Map;

public interface PageDAO {
    //1. 프론트에서 넘겨주는 값만 있다면 그 이후는 알아서 처리하게끔 if문을 통해 첫페이지와 아닌페이지에서 SQL문을 나눈다
    PageDTO loadContent(Map input) throws SQLException;

    PageDTO ContentRetrun(String idx) throws SQLException;

    int pageInsert(PageDTO dto);

    String postRecommend(Map<String, Integer> input) throws Exception;
}
