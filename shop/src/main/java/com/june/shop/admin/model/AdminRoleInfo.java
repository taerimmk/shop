package com.june.shop.admin.model;

import javax.persistence.Entity;

@Entity
public class AdminRoleInfo {

	private Integer seq;
	
	private String role;

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
