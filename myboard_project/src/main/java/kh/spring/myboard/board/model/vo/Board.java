package kh.spring.myboard.board.model.vo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class Board {
//	BOARD_NUM               NOT NULL NUMBER         
//	BOARD_TITLE                      VARCHAR2(50)   
//	BOARD_WRITER                     VARCHAR2(15)   
//	BOARD_CONTENT                    VARCHAR2(2000) 
//	BOARD_ORIGINAL_FILENAME          VARCHAR2(100)  
//	BOARD_RENAME_FILENAME            VARCHAR2(100)  
//	BOARD_DATE                       TIMESTAMP(6)   
//	BOARD_LEVEL                      NUMBER         
//	BOARD_REF                        NUMBER         
//	BOARD_REPLY_REF                  NUMBER         
//	BOARD_REPLY_SEQ                  NUMBER         
//	BOARD_READCOUNT                  NUMBER
	
	private int board_num;
	private String board_title;
	private String board_writer;
	private String board_content;
	private String board_original_filename;
	private String board_rename_filename;
	private Timestamp board_date;
	private int board_level;
	private int board_ref;
	private int board_reply_ref;
	private int board_reply_seq;
	private int board_readcount;
	private int refnum;
	@Override
	public String toString() {
		return "Board [board_num=" + board_num + ", board_title=" + board_title + ", board_writer=" + board_writer
				+ ", board_content=" + board_content + ", board_original_filename=" + board_original_filename
				+ ", board_rename_filename=" + board_rename_filename + ", board_date=" + board_date + ", board_level="
				+ board_level + ", board_ref=" + board_ref + ", board_reply_ref=" + board_reply_ref
				+ ", board_reply_seq=" + board_reply_seq + ", board_readcount=" + board_readcount + ", refnum=" + refnum
				+ "]";
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_original_filename() {
		return board_original_filename;
	}
	public void setBoard_original_filename(String board_original_filename) {
		this.board_original_filename = board_original_filename;
	}
	public String getBoard_rename_filename() {
		return board_rename_filename;
	}
	public void setBoard_rename_filename(String board_rename_filename) {
		this.board_rename_filename = board_rename_filename;
	}
	public Timestamp getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Timestamp board_date) {
		this.board_date = board_date;
	}
	public int getBoard_level() {
		return board_level;
	}
	public void setBoard_level(int board_level) {
		this.board_level = board_level;
	}
	public int getBoard_ref() {
		return board_ref;
	}
	public void setBoard_ref(int board_ref) {
		this.board_ref = board_ref;
	}
	public int getBoard_reply_ref() {
		return board_reply_ref;
	}
	public void setBoard_reply_ref(int board_reply_ref) {
		this.board_reply_ref = board_reply_ref;
	}
	public int getBoard_reply_seq() {
		return board_reply_seq;
	}
	public void setBoard_reply_seq(int board_reply_seq) {
		this.board_reply_seq = board_reply_seq;
	}
	public int getBoard_readcount() {
		return board_readcount;
	}
	public void setBoard_readcount(int board_readcount) {
		this.board_readcount = board_readcount;
	}
	public int getRefnum() {
		return refnum;
	}
	public void setRefnum(int refnum) {
		this.refnum = refnum;
	}
	
}
