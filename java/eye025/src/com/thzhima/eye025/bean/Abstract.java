package com.thzhima.eye025.bean;

import java.sql.Date;

public class Abstract {

	private int id;
	private String picture1, picture2, picture3;
	private boolean publishStatus;
	private Date publishDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPicture1() {
		return picture1;
	}

	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}

	public String getPicture2() {
		return picture2;
	}

	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}

	public String getPicture3() {
		return picture3;
	}

	public void setPicture3(String picture3) {
		this.picture3 = picture3;
	}

	public boolean isPublishStatus() {
		return publishStatus;
	}

	public void setPublishStatus(boolean publishStatus) {
		this.publishStatus = publishStatus;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Abstract() {
		super();

	}

	public Abstract(int id, String picture1, String picture2, String picture3, boolean publishStatus,
			Date publishDate) {
		super();
		this.id = id;
		this.picture1 = picture1;
		this.picture2 = picture2;
		this.picture3 = picture3;
		this.publishStatus = publishStatus;
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return "Abstract [id=" + id + ", picture1=" + picture1 + ", picture2=" + picture2 + ", picture3=" + picture3
				+ ", publishStatus=" + publishStatus + ", publishDate=" + publishDate + "]";
	}

}
