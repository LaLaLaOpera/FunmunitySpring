package com.funmunity.myapp.recommend;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostRecommendDAO {

    @Autowired
    SqlSession session;

    String namespace = "com.funmunity.myapp.recommend.";

    public int insertPostRecommend(PostRecommendDTO postRecommendDTO){
        try{
            return session.insert(namespace+"insertPostRecommend",postRecommendDTO);
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
