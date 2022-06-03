package kh.spring.myboard.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.myboard.board.model.vo.Board;

@Repository
public class BoardDao {
	@Autowired
	private SqlSession sqlsession;
	
	public int updateBoardReplySeq(Board board) {
		return sqlsession.update("Board.updateBoardReplySeq", board);
	}
	
	public int insertBoard(Board board) {
		return sqlsession.insert("Board.insertBoard",board);
	}
	
	public List<Board> selectBoardList() {
		return sqlsession.selectList("Board.selectBoardList");
	}
	
	public Board selectBoard(String board_num) {
		return sqlsession.selectOne("Board.selectBoard",board_num);
	}
	
	public int updateBoard(Board board) {
		return sqlsession.update("Board.updateBoard",board);
	}
}
