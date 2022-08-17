package com.funmunity.myapp.recommend;

import java.util.Date;
import java.util.Objects;

public class CommentRecommendDTO {
    private String boardidx;
    private String idx;
    private String user_id;
    private Date recommended_date;

    public String getBoardidx() {
        return boardidx;
    }

    public void setBoardidx(String boardidx) {
        this.boardidx = boardidx;
    }

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Date getRecommended_date() {
        return recommended_date;
    }

    public void setRecommended_date(Date recommended_date) {
        this.recommended_date = recommended_date;
    }

    @Override
    public String toString() {
        return "CommentRecommendDTO{" +
                "boardidx='" + boardidx + '\'' +
                ", idx='" + idx + '\'' +
                ", user_id='" + user_id + '\'' +
                ", recommended_date=" + recommended_date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentRecommendDTO that = (CommentRecommendDTO) o;
        return Objects.equals(boardidx, that.boardidx) && Objects.equals(idx, that.idx) && Objects.equals(user_id, that.user_id) && Objects.equals(recommended_date, that.recommended_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boardidx, idx, user_id, recommended_date);
    }
}
