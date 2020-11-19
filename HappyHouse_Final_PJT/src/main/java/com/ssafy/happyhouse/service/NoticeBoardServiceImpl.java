package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dao.NoticeBoardDao;
import com.ssafy.happyhouse.dto.NoticeBoardDto;


@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {
	
    @Autowired
	private NoticeBoardDao boardDao;

    @Override
	public List<NoticeBoardDto> retrieveBoard() {
		return boardDao.selectBoard();
	}
    
  	@Override
	public boolean writeBoard(NoticeBoardDto board) {
		return boardDao.insertBoard(board) == 1;
	}

	@Override
	public NoticeBoardDto detailBoard(int no) {
		return boardDao.selectBoardByNo(no);
	}

	@Override
	@Transactional
	public boolean updateBoard(NoticeBoardDto board) {
		return boardDao.updateBoard(board) == 1;
	}

	@Override
	@Transactional
	public boolean deleteBoard(int no) {
		return boardDao.deleteBoard(no) == 1;
	}
}