package com.funmunity.myapp.comment;

import java.sql.Date;
import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CommentDTO that = (CommentDTO) o;
		return Objects.equals(boardidx, that.boardidx) && Objects.equals(idx, that.idx) && Objects.equals(writer, that.writer) && Objects.equals(content, that.content) && Objects.equals(postdate, that.postdate) && Objects.equals(recommended, that.recommended);
	}

	@Override
	public int hashCode() {
		return Objects.hash(boardidx, idx, writer, content, postdate, recommended);
	}
}
