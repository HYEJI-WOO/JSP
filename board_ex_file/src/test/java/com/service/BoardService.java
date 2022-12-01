package com.service;

import java.util.List;

import com.dao.BoardDao;
import com.domain.BoardVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardService {

	private BoardDao dao;

	public List<BoardVO> boardList() {
		return dao.selectAll();
	}
}
