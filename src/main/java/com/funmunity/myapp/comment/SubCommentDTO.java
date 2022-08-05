package com.funmunity.myapp.comment;

import java.sql.Date;

public class SubCommentDTO {
	private String boardidx;
	private String commentidx;
	private String writer;
	private String content;
	private Date postdate;
	private String recommended;
	private String mention;
	public String getBoardidx() {
		return boardidx;
	}
	public void setBoardidx(String boardidx) {
		this.boardidx = boardidx;
	}
	public String getCommentidx() {
		return commentidx;
	}
	public void setCommentidx(String commentidx) {
		this.commentidx = commentidx;
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

	public String getMention() {
		return mention;
	}
	public void setMention(String mention) {
		this.mention = mention;
	}

	public String getRecommended() {
		return recommended;
	}
	public void setRecommended(String recommended) {
		this.recommended = recommended;
	}

	@Override
	public String toString() {
		return "SubCommentDTO{" +
				"boardidx='" + boardidx + '\'' +
				", commentidx='" + commentidx + '\'' +
				", writer='" + writer + '\'' +
				", content='" + content + '\'' +
				", postdate=" + postdate +
				", recommended='" + recommended + '\'' +
				", mention='" + mention + '\'' +
				'}';
	}
}
