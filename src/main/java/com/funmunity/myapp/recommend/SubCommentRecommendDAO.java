package com.funmunity.myapp.recommend;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class SubCommentRecommendDAO {

    @Autowired
    SqlSession session;

    String namespace = "com.funmunity.myapp.recommend.";

    public int insertCommentRecommend(SubCommentRecommendDTO dto){
        try{
            return session.insert(namespace+"insertSubCommentRecommend",dto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
