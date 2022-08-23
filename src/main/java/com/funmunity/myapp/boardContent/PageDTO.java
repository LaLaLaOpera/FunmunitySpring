package com.funmunity.myapp.boardContent;

import java.sql.Date;
import java.util.Objects;

public class PageDTO {
	public PageDTO() {}
	
	private String idx;
	private String title;
	private String content;
	private String thumnail;
	private Date postdate;
	private String writer;
	private String viewcount;
	private String recommendcount;
	private String board_cat;
	private String sub_cat;
	private String h_recommended;
	private String k_recommended;
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getThumnail() {
		return thumnail;
	}
	public void setThumnail(String thumnail) {
		this.thumnail = thumnail;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getViewcount() {
		return viewcount;
	}
	public void setViewcount(String viewcount) {
		this.viewcount = viewcount;
	}
	public String getRecommendcount() {
		return recommendcount;
	}
	public void setRecommendcount(String recommendcount) {
		this.recommendcount = recommendcount;
	}
	public String getBoard_cat() {
		return board_cat;
	}
	public void setBoard_cat(String board_cat) {
		this.board_cat = board_cat;
	}
	public String getSub_cat() {
		return sub_cat;
	}
	public void setSub_cat(String sub_cat) {
		this.sub_cat = sub_cat;
	}
	public String getH_recommended() {
		return h_recommended;
	}
	public void setH_recommended(String h_recommended) {
		this.h_recommended = h_recommended;
	}
	public String getK_recommended() {
		return k_recommended;
	}
	public void setK_recommended(String k_recommended) {
		this.k_recommended = k_recommended;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PageDTO pageDTO = (PageDTO) o;
		return Objects.equals(idx, pageDTO.idx) && Objects.equals(title, pageDTO.title) && Objects.equals(content, pageDTO.content) && Objects.equals(thumnail, pageDTO.thumnail) && Objects.equals(postdate, pageDTO.postdate) && Objects.equals(writer, pageDTO.writer) && Objects.equals(viewcount, pageDTO.viewcount) && Objects.equals(recommendcount, pageDTO.recommendcount) && Objects.equals(board_cat, pageDTO.board_cat) && Objects.equals(sub_cat, pageDTO.sub_cat) && Objects.equals(h_recommended, pageDTO.h_recommended) && Objects.equals(k_recommended, pageDTO.k_recommended);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idx, title, content, thumnail, postdate, writer, viewcount, recommendcount, board_cat, sub_cat, h_recommended, k_recommended);
	}
}
