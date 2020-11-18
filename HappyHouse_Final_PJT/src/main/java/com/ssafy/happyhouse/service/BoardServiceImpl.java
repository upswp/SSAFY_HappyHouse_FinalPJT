package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dao.BoardDao;
import com.ssafy.happyhouse.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	
    @Autowired
	private BoardDao boardDao;

    @Override
	public List<BoardDto> retrieveBoard() {
		return boardDao.selectBoard();
	}
    
  	@Override
	public boolean writeBoard(BoardDto board) {
		return boardDao.insertBoard(board) == 1;
	}

	@Override
	public BoardDto detailBoard(int no) {
		return boardDao.selectBoardByNo(no);
	}

	@Override
	@Transactional
	public boolean updateBoard(BoardDto board) {
		return boardDao.updateBoard(board) == 1;
	}

	@Override
	@Transactional
	public boolean deleteBoard(int no) {
		return boardDao.deleteBoard(no) == 1;
	}
}