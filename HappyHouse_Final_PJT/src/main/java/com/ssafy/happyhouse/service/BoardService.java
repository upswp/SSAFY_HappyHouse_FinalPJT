package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.BoardDto;

public interface BoardService {
	public List<BoardDto> retrieveBoard();
	public BoardDto detailBoard(int no);
	public boolean writeBoard(BoardDto board);
	public boolean updateBoard(BoardDto board);
	public boolean deleteBoard(int no);
}
