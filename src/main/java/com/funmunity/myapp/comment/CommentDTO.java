package com.funmunity.myapp.comment;

import java.sql.Date;

public class CommentDTO {
	private String boardidx;
	private String idx;
	private String writer;
	private String content;
	private Date postdate;
	private String recommended;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}

	public String getRecommended() {
		return recommended;
	}

	public void setRecommended(String recommended) {
		this.recommended = recommended;
	}

	@Override
	public String toString() {
		return "CommentDTO{" +
				"boardidx='" + boardidx + '\'' +
				", idx='" + idx + '\'' +
				", writer='" + writer + '\'' +
				", content='" + content + '\'' +
				", postdate=" + postdate +
				", recommended='" + recommended + '\'' +
				'}';
	}
}
