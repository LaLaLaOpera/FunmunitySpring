package com.funmunity.myapp.category;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CategoryDAO {

    @Autowired
    SqlSession session;



    String namespace = "";

    public int insertCategory(CategoryDTO categoryDTO){
        return session.insert(namespace+"insertCategory",categoryDTO);
    }

    public Map subCategorySearch(String category){

        return session.selectMap(namespace+"subCategorySearch",category);
    }
}
