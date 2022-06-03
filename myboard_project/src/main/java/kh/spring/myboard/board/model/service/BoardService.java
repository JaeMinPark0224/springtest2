package kh.spring.myboard.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.myboard.board.model.dao.BoardDao;
import kh.spring.myboard.board.model.vo.Board;

@Service
public class BoardService {
	@Autowired
	private BoardDao dao;
	
//	@Transactional
	public int insertBoard(Board board) {
		if(board.getRefnum() > 0) {
			dao.updateBoardReplySeq(board);
			return dao.insertBoard(board);
		}
		return dao.insertBoard(board);
	}
	
	public List<Board> selectBoardList() {
		return dao.selectBoardList();
	}
	
	public Board selectBoard(String board_num) {
		return dao.selectBoard(board_num);
	}
	
	public int updateBoard(Board board) {
		return dao.updateBoard(board);
	}
}
