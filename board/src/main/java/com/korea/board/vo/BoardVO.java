package com.korea.board.vo;

import lombok.Data;

@Data
public class BoardVO {
	private int idx; 			//게시판 일련번호
	private String name;		//작성자
	private String subject; 	//글 제목
	private String content; 	//글 내용(CLOB: CharLargeObject)
	private String pwd;			//비번
	private String ip;			//IP
	private String regdate; 	//작성날짜
	private int readhit;		//조회수
	private int ref;			//기준 글 번호(댓글을 달기 위한 참조하는 글)
	private int step;			//댓글 순서(수직적)
	private int depth;			//댓글의 깊이(댓글의 댓글 개념)
	private int del_info;		//삭제 여부: 0 이면 삭제 X, -1이면 삭제
}
