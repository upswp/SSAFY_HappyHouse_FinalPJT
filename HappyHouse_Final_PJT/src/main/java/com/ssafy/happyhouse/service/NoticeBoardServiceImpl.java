package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.NoticeBoardDto;
import com.ssafy.happyhouse.mapper.NoticeBoardMapper;


@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {
	
    @Autowired
	private NoticeBoardMapper boardMapper;

    @Override
	public List<NoticeBoardDto> retrieveBoard() {
    	return boardMapper.selectBoard();
	}
    
  	@Override
	public boolean writeBoard(NoticeBoardDto board) {
		return boardMapper.insertBoard(board) == 1;
	}

	@Override
	public NoticeBoardDto detailBoard(int no) {
		return boardMapper.selectBoardByNo(no);
	}

	@Override
	@Transactional
	public boolean updateBoard(NoticeBoardDto board) {
		return boardMapper.updateBoard(board) == 1;
	}

	@Override
	@Transactional
	public boolean deleteBoard(int no) {
		return boardMapper.deleteBoard(no) == 1;
	}
}