package mc.sn.buyus.ybjService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mc.sn.buyus.ybjDAO.BoardDAO;
import mc.sn.buyus.ybjVO.YbjBoardReplyVO;
import mc.sn.buyus.ybjVO.YbjBoardVO;
import mc.sn.buyus.ybjVO.YbjReviewReplyVO;
import mc.sn.buyus.ybjVO.YbjReviewVO;

@Service("boardService")
public class BoardService {
	@Autowired
	private BoardDAO boardDAO; 
	
	//Create
	public boolean writeReview(YbjReviewVO vo) {
		boolean flag=false;
		int result=0;
		result=boardDAO.insertReview(vo);
		if(result>0) {
			flag=true;
		}
		
		return flag;
	}
	public boolean writeReview_reply(YbjReviewReplyVO vo) {
		boolean flag=false;
		int result=0;
		result=boardDAO.insertReview_reply(vo);
		if(result>0) {
			flag=true;
		}
		
		return flag;
		}
	public boolean writeBoard(YbjBoardVO vo) {
		boolean flag=false;
		int result=0;
		result=boardDAO.insertBoard(vo);
		if(result>0) {
			flag=true;
		}
		
		return flag;
	}
	public boolean writeBoard_reply(YbjBoardReplyVO vo) {
		boolean flag=false;
		int result=0;
		result=boardDAO.insertBoard_reply(vo);
		if(result>0) {
			flag=true;
		}
		
		return flag;
	}
	
	//Select
	public List<YbjReviewVO> readAllReview(String ottName) {
		List<YbjReviewVO> list=null;
		list=boardDAO.selectAllReview(ottName);
		return list;		
	}
	public List<YbjReviewReplyVO> readAllReview_reply(int find_review) {
		List<YbjReviewReplyVO> list=null;
		list=boardDAO.selectAllReview_reply(find_review);
		return list;		
	}
	public List<YbjBoardVO> readAllBoard(String content_title) {
		List<YbjBoardVO> list=null;
		list=boardDAO.selectAllBoard(content_title);
		return list;		
	}
	public List<YbjBoardReplyVO> readAllBoard_reply(int find_board) {
		List<YbjBoardReplyVO> list=null;
		list=boardDAO.selectAllBoard_reply(find_board);
		return list;		
	}
	
	//Update
	
	public boolean modReview(YbjReviewVO vo) {
		boolean flag=false;
		int result=0;
		result=boardDAO.updateReview(vo);
		if(result>0) {
			flag=true;
		}
		
		return flag;
	}
	// reply_body, seq_reviewreply
	public boolean modReview_reply(YbjReviewReplyVO vo) {
		boolean flag=false;
		int result=0;
		result=boardDAO.updateReview_reply(vo);
		if(result>0) {
			flag=true;
		}
		
		return flag;
			
		}
	//Board_Title, Board_Body, seq_board
	public boolean modBoard(YbjBoardVO vo) {
		boolean flag=false;
		int result=0;
		result=boardDAO.updateBoard(vo);
		if(result>0) {
			flag=true;
		}
		
		return flag;
		
	}
	//Board_Title, Board_Body, seq_boardreply
	public boolean modBoard_reply(YbjBoardReplyVO vo) {
		boolean flag=false;
		int result=0;
		result=boardDAO.updateBoard_reply(vo);
		if(result>0) {
			flag=true;
		}
		
		return flag;
		
	}
	
	//Delete
	
	public boolean eraseReview(int seq_review) {
		boolean flag=false;
		int result=0;
		result=boardDAO.deleteReview(seq_review);
		if(result>0) {
			flag=true;
		}
		
		return flag;
	}
	public boolean eraseReview_reply(int seq_reviewreply) {
		boolean flag=false;
		int result=0;
		result=boardDAO.deleteReview_reply(seq_reviewreply);
		if(result>0) {
			flag=true;
		}
		
		return flag;
			
		}
	public boolean eraseBoard(int seq_board) {
		boolean flag=false;
		int result=0;
		result=boardDAO.deleteBoard(seq_board);
		if(result>0) {
			flag=true;
		}
		
		return flag;
		
	}
	public boolean eraseBoard_reply(int seq_boardreply) {
		boolean flag=false;
		int result=0;
		result=boardDAO.deleteBoard_reply(seq_boardreply);
		if(result>0) {
			flag=true;
		}
		
		return flag;
		
	}
	
	public boolean countview(int seq_board) {
		boolean flag=false;
		int result = 0;
		result = boardDAO.countview(seq_board);
		if(result>0) {
			flag=true;
		}
		return flag;
	}
	
	
	public List<YbjBoardVO> readDetailBoard(int index) {
		List<YbjBoardVO> list=null;
		boardDAO.countview(index);
		list=boardDAO.selectDetailBoard(index);
		return list;		
	}
	

}
