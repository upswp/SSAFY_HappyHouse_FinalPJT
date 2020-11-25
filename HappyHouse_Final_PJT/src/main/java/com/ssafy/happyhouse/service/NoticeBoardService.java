package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.NoticeBoardDto;


public interface NoticeBoardService {
	public List<NoticeBoardDto> retrieveBoard();
	public NoticeBoardDto detailBoard(int no);
	public boolean writeBoard(NoticeBoardDto board);
	public boolean updateBoard(NoticeBoardDto board);
	public boolean deleteBoard(int no);
	public boolean countViewsBoard(int no);
}
