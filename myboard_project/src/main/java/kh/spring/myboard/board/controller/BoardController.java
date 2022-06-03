package kh.spring.myboard.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.spring.myboard.board.model.service.BoardService;
import kh.spring.myboard.board.model.vo.Board;
import kh.spring.myboard.common.FileUpload;
import kh.spring.myboard.member.model.vo.Member;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService service;
	
	@Autowired
	private FileUpload commonfile;
	
	@GetMapping("/write")
	public ModelAndView pageInsertBoard(ModelAndView mv
			, @RequestParam(name = "refnum", defaultValue = "0") String refnumStr
			) {
		int refnum = 0;
		try {
			refnum = Integer.parseInt(refnumStr);
		}catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("refnum", refnum);
		mv.setViewName("board/write");
		return mv;
	}
	@PostMapping("/write")
	public ModelAndView insertBoard(
			ModelAndView mv
//			, @RequestParam(name = "refnum", defaultValue = "0") String refnumStr
			, Board board
			, @RequestParam(name = "uploadfile", required = false) MultipartFile multiFile
			, HttpServletRequest req
			, HttpSession session
			, RedirectAttributes rttr
			) {
		Member loginInfo = (Member) session.getAttribute("loginSsInfo");
		if(loginInfo == null) {
			rttr.addFlashAttribute("msg", "로그인 후 글쓰기를 다시 시도해 주세요.");
			mv.setViewName("redirect:/member/login");
			return mv;
		}
		
		board.setBoard_writer(loginInfo.getId());
		
		if(multiFile != null) {
			String rename_filename = commonfile.saveFile(multiFile, req);
			if(rename_filename != null) {
				board.setBoard_original_filename(multiFile.getOriginalFilename());
				board.setBoard_rename_filename(rename_filename);
			}
		}
		int result = service.insertBoard(board);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	@GetMapping("/list")
	public ModelAndView selectBoardList(ModelAndView mv) {
		List<Board> boardlist = service.selectBoardList();
		mv.addObject("boardlist", boardlist);
		mv.setViewName("board/list");
		return mv;
	}
	
	@GetMapping("/read")
	public ModelAndView selectBoard(
			ModelAndView mv
			, @RequestParam(name = "board_num", required = false) String board_num
			) {
		if(board_num == null) {
			mv.setViewName("redirect:/board/list");
			return mv;
		}
		mv.addObject("board", service.selectBoard(board_num));
		mv.setViewName("board/read");
		return mv;
	}
	@PostMapping("/update")
	public ModelAndView pageUpdateBoard(
			ModelAndView mv
			, @RequestParam(name = "board_num", required = false) String board_num
			) {
		if(board_num == null) {
			mv.setViewName("redirect:/board/list");
			return mv;
		}
		mv.addObject("board", service.selectBoard(board_num));
		mv.setViewName("board/update");
		return mv;
	}
	
	@PostMapping("/updateDo")
	public ModelAndView updateBoard(
			ModelAndView mv
			, @RequestParam(name = "board_num", required = false) String board_num
			, Board board
			, @RequestParam(name = "uploadfile", required = false) MultipartFile multiFile
			, @RequestParam(name = "org_filepath", required = false) String org_filepath
			, HttpServletRequest req
			, RedirectAttributes rttr
			, HttpSession session
			) {
		// 예외처리
		if(board_num == null) {
			mv.setViewName("redirect:/board/list");
			return mv;
		}
		// 예외처리 - 로그인
		Member loginInfo = (Member) session.getAttribute("loginSsInfo");
		if(loginInfo == null) {
			rttr.addFlashAttribute("msg", "로그인 후 글쓰기를 다시 시도해 주세요.");
			mv.setViewName("redirect:/member/login");
			return mv;
		}
		// 파일 수정 여부확인
		if(board.getBoard_original_filename().equals("") && org_filepath != null) {					
			commonfile.removeFile(org_filepath, req);
			board.setBoard_original_filename(null);
			board.setBoard_rename_filename(null);
		}
		if(multiFile != null) {
			String rename_filename = commonfile.saveFile(multiFile, req);
			if(rename_filename != null) {
				board.setBoard_original_filename(multiFile.getOriginalFilename());
				board.setBoard_rename_filename(rename_filename);
			}
		}
		// DB update
		
		mv.addObject("board_num", board_num);
		mv.setViewName("redirect:/board/read");
		return mv;
	}
}
