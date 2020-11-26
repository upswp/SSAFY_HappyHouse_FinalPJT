package com.ssafy.happyhouse.dto;

import java.util.Date;

public class CommentDto {
	private int commentno;
    private int bno;
    private String content;
    private String writer;
    private Date reg_date;
 
    public int getcommentno() {
        return commentno;
    }
 
    public void setcommentno(int commentno) {
        this.commentno = commentno;
    }
 
    public int getBno() {
        return bno;
    }
 
    public void setBno(int bno) {
        this.bno = bno;
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
 
    public Date getReg_date() {
        return reg_date;
    }
 
    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

	@Override
	public String toString() {
		return "CommentDto [commentno=" + commentno + ", bno=" + bno + ", content=" + content + ", writer=" + writer + ", reg_date="
				+ reg_date + "]";
	}

}
