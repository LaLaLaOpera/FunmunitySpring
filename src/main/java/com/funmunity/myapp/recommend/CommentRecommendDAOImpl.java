package com.funmunity.myapp.recommend;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRecommendDAOImpl implements CommentRecommendDAO {

    @Autowired
    SqlSession session;

    String namespace = "com.funmunity.myapp.recommend.";

    @Override
    public int insertCommentRecommend(CommentRecommendDTO dto){

        return session.insert(namespace+"insertCommentRecommend",dto);

    }
}
