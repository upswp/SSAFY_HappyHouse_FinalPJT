package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.CommentDto;
import com.ssafy.happyhouse.mapper.CommentMapper;
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper mCommentMapper;

	public List<CommentDto> commentListService() throws Exception {

		return mCommentMapper.commentList();
	}

	public int commentInsertService(CommentDto comment) throws Exception {

		return mCommentMapper.commentInsert(comment);
	}

	public int commentUpdateService(CommentDto comment) throws Exception {

		return mCommentMapper.commentUpdate(comment);
	}

	public int commentDeleteService(int cno) throws Exception {

		return mCommentMapper.commentDelete(cno);
	}

}
