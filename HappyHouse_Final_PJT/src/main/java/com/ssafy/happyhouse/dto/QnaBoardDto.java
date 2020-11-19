package com.ssafy.happyhouse.dto;

import java.util.Date;

public class QnaBoardDto {
	private int no;
	private String writer;
	private String title;
	private String content;
	private int comment_count;
	private Date regtime;
	private int  comment_no;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public int getComment_count() {
		return comment_count;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	public Date getRegtime() {
		return regtime;
	}
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	public int getCommnet_no() {
		return comment_no;
	}
	public void setCommnet_no(int commnet_no) {
		this.comment_no = comment_no;
	}
	@Override
	public String toString() {
		return "BoardDto [no=" + no + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", comment_count=" + comment_count + ", regtime=" + regtime + ", commnet_no=" + comment_no + "]";
	}
	public QnaBoardDto(int no, String writer, String title, String content, int comment_count, Date regtime,
			int commnet_no) {
		super();
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.comment_count = comment_count;
		this.regtime = regtime;
		this.comment_no = comment_no;
	}
	
	
	
	
}	