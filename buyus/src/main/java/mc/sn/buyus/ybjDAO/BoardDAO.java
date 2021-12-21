package mc.sn.buyus.ybjDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mc.sn.buyus.ybjVO.YbjBoardReplyVO;
import mc.sn.buyus.ybjVO.YbjBoardVO;
import mc.sn.buyus.ybjVO.YbjReviewReplyVO;
import mc.sn.buyus.ybjVO.YbjReviewVO;

@Repository("BoardDAO")

public class BoardDAO {
	@Autowired
	private SqlSession sqlSession;

	// id, ottName, review_title, eval, review_body
	public int insertReview(YbjReviewVO vo) {
		int result = 0;
		result = sqlSession.insert("mapper.yaboard.insertReview", vo);
		System.out.println(result);
		return result;
	}

	// find_review, id, reply_body
	public int insertReview_reply(YbjReviewReplyVO vo) {
		int result = 0;
		result = sqlSession.insert("mapper.yaboard.insertReviewReply", vo);
		System.out.println(result);
		return result;
	}

	// Board_Tile, Board_Body,ya_id, content_title
	public int insertBoard(YbjBoardVO vo) {
		int result = 0;
		result = sqlSession.insert("mapper.yaboard.insertBoard", vo);
		System.out.println(result);
		return result;
	}

	public int insertBoard_reply(YbjBoardReplyVO vo) {
		int result = 0;
		result = sqlSession.insert("mapper.yaboard.insertBoard_reply", vo);
		System.out.println(result);
		return result;
	}

	//
	public List<YbjReviewVO> selectAllReview(String contenttitle) {
		List<YbjReviewVO> list = null;
		list = sqlSession.selectList("mapper.yaboard.selectReview", contenttitle);
		return list;
	}

	public List<YbjReviewReplyVO> selectAllReview_reply(int find_review) {
		List<YbjReviewReplyVO> list = null;
		list = sqlSession.selectList("mapper.yaboard.selectReviewReply", find_review);
		return list;
	}

	public List<YbjBoardVO> selectAllBoard(String content_title) {
		List<YbjBoardVO> list = null;
		list = sqlSession.selectList("mapper.yaboard.selectBoard", content_title);
		return list;
	}
	public List<YbjBoardVO> selectDetailBoard(int index) {
		List<YbjBoardVO> list = null;
		list = sqlSession.selectList("mapper.yaboard.selectDetailBoard", index);
		return list;
	}

	public List<YbjBoardReplyVO> selectAllBoard_reply(int find_board) {
		List<YbjBoardReplyVO> list = null;
		list = sqlSession.selectList("mapper.yaboard.selectBoardReply", find_board);
		return list;
	}
	

	// review_title, review_body, seq_review
	public int updateReview(YbjReviewVO vo) {
		int result = 0;
		result = sqlSession.update("mapper.yaboard.updateReview", vo);
		return result;
	}

	// reply_body, seq_reviewreply
	public int updateReview_reply(YbjReviewReplyVO vo) {
		int result = 0;
		result = sqlSession.update("mapper.yaboard.updateReviewReply", vo);
		return result;

	}

	// Board_Title, Board_Body, seq_board
	public int updateBoard(YbjBoardVO vo) {
		int result = 0;
		result = sqlSession.update("mapper.yaboard.updateBoard", vo);
		return result;

	}

	// Board_Title, Board_Body, seq_boardreply
	public int updateBoard_reply(YbjBoardReplyVO vo) {
		int result = 0;
		result = sqlSession.update("mapper.yaboard.updateBoardReply", vo);
		return result;

	}

	public int deleteReview(int seq_review) {
		int result = 0;
		result = sqlSession.delete("mapper.yaboard.deleteReview", seq_review);
		return result;
	}

	public int deleteReview_reply(int seq_reviewreply) {
		int result = 0;
		result = sqlSession.delete("mapper.yaboard.deleteReviewReply", seq_reviewreply);
		return result;

	}

	public int deleteBoard(int seq_board) {
		int result = 0;
		result = sqlSession.delete("mapper.yaboard.deleteBoard", seq_board);
		return result;

	}

	public int deleteBoard_reply(int seq_boardreply) {
		int result = 0;
		result = sqlSession.delete("mapper.yaboard.deleteBoardReply", seq_boardreply);
		return result;
	}
	public int countview(int seq_board) {
		int result = 0;
		result = sqlSession.update("mapper.yaboard.countView", seq_board);
		return result;
	}
}
