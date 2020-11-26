package com.ssafy.happyhouse.dto;


public class CommentDto {
	/*댓글 고유 넘버*/
	private int commentno;
	/*댓글 총 갯수*/
    private int bno;
    /*내용*/
    private String content;
    /*작성자*/
    private String writer;
    /*작성일자*/
    private String reg_date;
 
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
 
    public String getReg_date() {
        return reg_date;
    }
 
    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

	@Override
	public String toString() {
		return "CommentDto [commentno=" + commentno + ", bno=" + bno + ", content=" + content + ", writer=" + writer + ", reg_date="
				+ reg_date + "]";
	}

}
