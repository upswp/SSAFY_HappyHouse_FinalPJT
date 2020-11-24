package com.ssafy.happyhouse.dto;

public class NoticeBoardDto {
	/*공지사항 글 no*/
	private int no;
	/*공지사항 글 이름*/
	private String title;
	/*공지사항 글 내용*/
	private String content;
	/*공지사항 글 작성자*/
	private String writer;
	/*공지사항 글 열럼횟수*/
	private int views;
	/*공지사항 글 등록일*/
	private String regtime;
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
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	@Override
	public String toString() {
		return "NoticeBoardDto [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", views=" + views + ", regtime=" + regtime + "]";
	}

}	