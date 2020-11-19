package com.ssafy.happyhouse.dto;

import java.util.Date;

public class NoticeBoardDto {
	private int no;
	private String title;
	private String content;
	private String writer;
	private int views;
	private Date regtime;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public Date getRegtime() {
		return regtime;
	}
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	public NoticeBoardDto(int no, String title, String content, String writer, int views, Date regtime) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.views = views;
		this.regtime = regtime;
	}
	@Override
	public String toString() {
		return "NoticeBoardDto [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", views=" + views + ", regtime=" + regtime + "]";
	}

}	