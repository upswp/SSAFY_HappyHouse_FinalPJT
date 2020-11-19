package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dao.QnaBoardDao;
import com.ssafy.happyhouse.dto.QnaBoardDto;

@Service
public class NoticeBoardServiceImpl implements QnaBoardService {
	
    @Autowired
	private QnaBoardDao boardDao;

    @Override
	public List<QnaBoardDto> retrieveBoard() {
		return boardDao.selectBoard();
	}
    
  	@Override
	public boolean writeBoard(QnaBoardDto board) {
		return boardDao.insertBoard(board) == 1;
	}

	@Override
	public QnaBoardDto detailBoard(int no) {
		return boardDao.selectBoardByNo(no);
	}

	@Override
	@Transactional
	public boolean updateBoard(QnaBoardDto board) {
		return boardDao.updateBoard(board) == 1;
	}

	@Override
	@Transactional
	public boolean deleteBoard(int no) {
		return boardDao.deleteBoard(no) == 1;
	}
}