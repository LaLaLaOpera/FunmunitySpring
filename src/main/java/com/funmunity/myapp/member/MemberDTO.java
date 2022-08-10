package com.funmunity.myapp.member;

import java.util.Objects;

public class MemberDTO {
	private String user_id;
	private String user_num;
	private String user_pw;
	private int fun_point;
	private String user_email;
	private String user_name;
	private String char_job;
	private String auth_level;
	private String user_level;
	private int user_exp;
	private String profile_img;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_num() {
		return user_num;
	}
	public void setUser_num(String user_num) {
		this.user_num = user_num;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public int getFun_point() {
		return fun_point;
	}
	public void setFun_point(int fun_point) {
		this.fun_point = fun_point;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getChar_job() {
		return char_job;
	}
	public void setChar_job(String char_job) {
		this.char_job = char_job;
	}
	public String getAuth_level() {
		return auth_level;
	}
	public void setAuth_level(String auth_level) {
		this.auth_level = auth_level;
	}
	public String getUser_level() {
		return user_level;
	}
	public void setUser_level(String user_level) {
		this.user_level = user_level;
	}
	public int getUser_exp() {
		return user_exp;
	}
	public void setUser_exp(int user_exp) {
		this.user_exp = user_exp;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}

	@Override
	public String toString() {
		return "MemberDTO{" +
				"user_id='" + user_id + '\'' +
				", user_num='" + user_num + '\'' +
				", user_pw='" + user_pw + '\'' +
				", fun_point=" + fun_point +
				", user_email='" + user_email + '\'' +
				", user_name='" + user_name + '\'' +
				", char_job='" + char_job + '\'' +
				", auth_level='" + auth_level + '\'' +
				", user_level='" + user_level + '\'' +
				", user_exp=" + user_exp +
				", profile_img='" + profile_img + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MemberDTO memberDTO = (MemberDTO) o;
		return fun_point == memberDTO.fun_point && user_exp == memberDTO.user_exp && Objects.equals(user_id, memberDTO.user_id) && Objects.equals(user_num, memberDTO.user_num) && Objects.equals(user_pw, memberDTO.user_pw) && Objects.equals(user_email, memberDTO.user_email) && Objects.equals(user_name, memberDTO.user_name) && Objects.equals(char_job, memberDTO.char_job) && Objects.equals(auth_level, memberDTO.auth_level) && Objects.equals(user_level, memberDTO.user_level) && Objects.equals(profile_img, memberDTO.profile_img);
	}

	@Override
	public int hashCode() {
		return Objects.hash(user_id, user_num, user_pw, fun_point, user_email, user_name, char_job, auth_level, user_level, user_exp, profile_img);
	}
}
