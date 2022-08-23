package com.funmunity.myapp.recommend;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostRecommendDAOImpl implements PostRecommendDAO {

    @Autowired
    SqlSession session;

    String namespace = "com.funmunity.myapp.recommend.";

    @Override
    public int insertPostRecommend(PostRecommendDTO postRecommendDTO){
        return session.insert(namespace+"insertPostRecommend",postRecommendDTO);
    }
}
