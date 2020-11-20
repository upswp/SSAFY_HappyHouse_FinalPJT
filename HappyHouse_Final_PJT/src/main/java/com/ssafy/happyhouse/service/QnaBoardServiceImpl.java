package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.QnaBoardDto;
import com.ssafy.happyhouse.mapper.QnaBoardMapper;

@Service
public class QnaBoardServiceImpl implements QnaBoardService {
	
    @Autowired
	private QnaBoardMapper boardMapper;

    @Override
	public List<QnaBoardDto> retrieveBoard() {
		return boardMapper.selectBoard();
	}
    
  	@Override
	public boolean writeBoard(QnaBoardDto board) {
		return boardMapper.insertBoard(board) == 1;
	}

	@Override
	public QnaBoardDto detailBoard(int no) {
		return boardMapper.selectBoardByNo(no);
	}

	@Override
	@Transactional
	public boolean updateBoard(QnaBoardDto board) {
		return boardMapper.updateBoard(board) == 1;
	}

	@Override
	@Transactional
	public boolean deleteBoard(int no) {
		return boardMapper.deleteBoard(no) == 1;
	}
}