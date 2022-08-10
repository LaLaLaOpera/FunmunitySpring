package com.funmunity.myapp.comment;

import java.sql.Date;
import java.util.Objects;

public class SubCommentDTO {
	private String boardidx;
	private String commentidx;
	private String writer;
	private String content;
	private Date postdate;
	private String recommended;
	private String mention;
	private String idx;
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

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
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
				", idx='" + idx + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SubCommentDTO that = (SubCommentDTO) o;
		return Objects.equals(boardidx, that.boardidx) && Objects.equals(commentidx, that.commentidx) && Objects.equals(writer, that.writer) && Objects.equals(content, that.content) && Objects.equals(postdate, that.postdate) && Objects.equals(recommended, that.recommended) && Objects.equals(mention, that.mention) && Objects.equals(idx, that.idx);
	}

	@Override
	public int hashCode() {
		return Objects.hash(boardidx, commentidx, writer, content, postdate, recommended, mention, idx);
	}
}
