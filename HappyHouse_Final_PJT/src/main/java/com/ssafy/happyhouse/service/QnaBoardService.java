package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.QnaBoardDto;

public interface QnaBoardService {
	public List<QnaBoardDto> retrieveBoard();
	public QnaBoardDto detailBoard(int no);
	public boolean writeBoard(QnaBoardDto board);
	public boolean updateBoard(QnaBoardDto board);
	public boolean deleteBoard(int no);
}
