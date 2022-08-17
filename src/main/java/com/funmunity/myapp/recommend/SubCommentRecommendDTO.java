package com.funmunity.myapp.recommend;

import java.util.Date;

public class SubCommentRecommendDTO {
    private int idx;
    private int boardidx;
    private int commentidx;
    private String recommender;
    private Date date;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getBoardidx() {
        return boardidx;
    }

    public void setBoardidx(int boardidx) {
        this.boardidx = boardidx;
    }

    public int getCommentidx() {
        return commentidx;
    }

    public void setCommentidx(int commentidx) {
        this.commentidx = commentidx;
    }

    public String getRecommender() {
        return recommender;
    }

    public void setRecommender(String recommender) {
        this.recommender = recommender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SubCommentRecommendDTO{" +
                "idx=" + idx +
                ", boardidx=" + boardidx +
                ", commentidx=" + commentidx +
                ", recommender='" + recommender + '\'' +
                ", date=" + date +
                '}';
    }
}
