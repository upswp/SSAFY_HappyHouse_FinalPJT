package com.ssafy.happyhouse.dto;


public class QnaBoardDto {
	/*QnA 글 no*/
	private int no;
	/*QnA 글 작성자*/
	private String writer;
	/*QnA 글 제목*/
	private String title;
	/*QnA 글 내용*/
	private String content;
	/*QnA 글 댓글 갯수*/
	private int comment_count;
	/*QnA 글 등록일*/
	private String regtime;
	/*QnA 댓글 no*/
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
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public int getComment_no() {
		return comment_no;
	}
	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}
	@Override
	public String toString() {
		return "QnaBoardDto [no=" + no + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", comment_count=" + comment_count + ", regtime=" + regtime + ", comment_no=" + comment_no + "]";
	}
	
}	