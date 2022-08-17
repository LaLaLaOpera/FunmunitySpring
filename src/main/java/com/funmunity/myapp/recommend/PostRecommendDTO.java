package com.funmunity.myapp.recommend;

import java.util.Date;

public class PostRecommendDTO {
    private int idx;
    private String user_id;
    private Date recommended_date;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
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
        return "PostRecommendDTO{" +
                "idx=" + idx +
                ", user_id='" + user_id + '\'' +
                ", recommended_date=" + recommended_date +
                '}';
    }
}
