package com.june.shop.site.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class UserRoleInfo {

	private Integer seq;

	private Integer user_seq;

	private Integer role_seq;
	
	private Date regiDate;
	
	private String role;

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(Integer user_seq) {
		this.user_seq = user_seq;
	}

	public Integer getRole_seq() {
		return role_seq;
	}

	public void setRole_seq(Integer role_seq) {
		this.role_seq = role_seq;
	}

	public Date getRegiDate() {
		return regiDate;
	}

	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "AdminUserRoleInfo [seq=" + seq + ", user_seq=" + user_seq
				+ ", role_seq=" + role_seq + ", regiDate=" + regiDate
				+ ", role=" + role + "]";
	}
	
	

}
