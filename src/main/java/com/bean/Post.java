package com.bean;

import java.util.Date;

public class Post {

	private Integer postId;
	private String title;
	private String content;
	private Date createdOn;
	private Blog blog;

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public String toString() {
		return "Post [PostId=" + postId + ", title=" + title + ", createdOn=" + createdOn + ", blog=" + blog + "]";
	}
}
