package com.korea.board.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.korea.board.mapper.BoardMapper;
import com.korea.board.vo.BoardVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardDAO {
	
	private final BoardMapper boardMapper;
	
	//페이지 별 게시물 조회
	public List<BoardVO> selectList(HashMap<String, Integer> map) {
		return  boardMapper.selectList(map);
	};
	
	//총 게시물 수 조회
	public int getRowTotal() {
		return boardMapper.getRowTotal();
	};

}
