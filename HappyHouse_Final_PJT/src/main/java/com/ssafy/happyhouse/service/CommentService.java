package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.CommentDto;

public interface CommentService {
	public List<CommentDto> commentListService() throws Exception;

	public int commentInsertService(CommentDto comment) throws Exception;

	public int commentUpdateService(CommentDto comment) throws Exception;

	public int commentDeleteService(int cno) throws Exception;
}
