package com.bean;

import java.util.Date;

@SuppressWarnings("restriction")
@sun.misc.Contended
public class PostsByUser {

	private Integer userId;
	private String emailId;
	private String blogName;
	private String title;
	private Date createdOn;
	private Integer blogId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String toString() {
		return "Post [UserId=" + userId + ", Email=" + emailId + " , blog=" + blogName + " title=" + title
				+ ", createdOn=" + createdOn + "]";
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
}
