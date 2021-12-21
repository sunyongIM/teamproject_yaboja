package mc.sn.buyus.ybjController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import mc.sn.buyus.ybjService.BoardService;
import mc.sn.buyus.ybjVO.YbjBoardReplyVO;
import mc.sn.buyus.ybjVO.YbjBoardVO;
import mc.sn.buyus.ybjVO.YbjReviewReplyVO;
import mc.sn.buyus.ybjVO.YbjReviewVO;

@RestController("boardController")

public class BoardController {
	boolean flag = false;
	
	@Autowired
	private BoardService service;
	@Autowired
	private YbjBoardVO boardVO;
	@Autowired
	private YbjBoardReplyVO boardRPVO;
	@Autowired
	private YbjReviewVO reviewVO;
	@Autowired
	private YbjReviewReplyVO reviewRPVO;

	
	/*
	 * // 글쓰기
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/board", method = RequestMethod.POST) public void
	 * writeBoard(@RequestBody String json, HttpServletResponse resp) throws
	 * IOException { boardVO = new ObjectMapper().readValue(json,YbjBoardVO.class);
	 * flag = service.writeBoard(boardVO); if (flag) { System.out.println("삽입성공");
	 * resp.sendError(HttpServletResponse.SC_OK); } else {
	 * System.out.println("삽입실패"); resp.sendError(HttpServletResponse.SC_NOT_FOUND);
	 * } }
	 */

//	@ResponseBody
//	@RequestMapping(value = "createboard", method = RequestMethod.GET)
//	public boolean writeBoard(){
//		boolean flag=false;
//		YbjBoardVO vo=new YbjBoardVO() ;
//		vo.setId("lee");
//		vo.setBoardTitle("타이틀");
//		vo.setBoardBody("바디");
//		vo.setContentTitle("ironman");
//		
//		flag = dao.writeBoard(vo);
//		if(flag==true) {
//			System.out.println("삽입성공");
//		}
//		return flag;
//		}
	//
	/*
	 * // 글댓글 쓰기
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/boardreply", method = RequestMethod.POST, produces
	 * = "application/json; charset=utf8") public boolean
	 * writeBoardReply(@RequestBody YbjBoardReplyVO boardRPVO) { boolean flag =
	 * false; flag = service.writeBoard_reply(boardRPVO); if (flag) {
	 * System.out.println("삽입성공"); } return flag; }
	 */

	// 리뷰쓰기
	@RequestMapping(value = "/review", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public boolean writeReview(@RequestBody YbjReviewVO reviewVO, HttpServletResponse resp) {
		boolean flag = false;
		flag = service.writeReview(reviewVO);
		if (flag) {
			System.out.println("삽입성공");
		}
		System.out.println("리뷰타이틀 작성" + reviewVO.getReviewTitle());
		return flag;
	}
	//리뷰보기
	@ResponseBody
	@RequestMapping(value = "/readreview", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public String readReview(HttpServletRequest req, HttpServletResponse resp) {
		List<YbjReviewVO> vo = null;
		String contentTitle = req.getParameter("reviewTitle");
		System.out.println("리뷰타이틀 받아온거로 리뷰목록작성" + contentTitle);
		vo = service.readAllReview(contentTitle);
		String json = new Gson().toJson(vo);
		System.out.println(json);
		return json;

	}

	// 리뷰댓글쓰기
	@ResponseBody
	@RequestMapping(value = "/reviewreply", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public boolean writeReviewReply(@RequestBody YbjReviewReplyVO reviewRPVO) {
		boolean flag = false;
		flag = service.writeReview_reply(reviewRPVO);
		if (flag) {
			System.out.println("삽입성공");
		}
		return flag;
	}

	/*
	 * // 글목록
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/board/{contentTitle}", method = RequestMethod.GET,
	 * produces = "application/json; charset=utf8") public List<YbjBoardVO>
	 * readBoard(@PathVariable("contentTitle") String contentTitle,
	 * HttpServletRequest req, HttpServletResponse resp) { List<YbjBoardVO> vo =
	 * null; // String contentTitle="ironman"; vo =
	 * service.readAllBoard(contentTitle); System.out.println(vo.toString()); return
	 * vo; }
	 */

	/*
	 * // 글 댓글 목록
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/board/{boardindex}", method = RequestMethod.GET)
	 * public List<YbjBoardReplyVO> readBoardReply(@PathVariable("boardIndex") int
	 * boardIndex, HttpServletRequest req, HttpServletResponse resp) {
	 * List<YbjBoardReplyVO> vo = null; // int boardIndex=4; vo =
	 * service.readAllBoard_reply(boardIndex); System.out.println(vo.toString());
	 * return vo; }
	 */


	// 리뷰목록
//	@ResponseBody
//	@RequestMapping(value = "review/{reviewTitle}", method = RequestMethod.GET,produces = "application/json; charset=utf8")
//	public String readReview(@PathVariable("reviewTitle") String reviewTitle, HttpServletRequest req, HttpServletResponse resp) {// reviewTitle값을 가져온다.
//		List<YbjReviewVO> vo = null;
//		//String reviewTitle=req.getParameter("reviewTitle");
//		vo = service.readAllReview(reviewTitle);
//		String json=new Gson().toJson(vo);
//		System.out.println(json);
//		return json;
//	}

//	@ResponseBody
//	@RequestMapping(value = "/reviewlist", method = RequestMethod.GET, produces = "application/json; charset=utf8")
//	public String readReview(HttpServletRequest req, HttpServletResponse resp) {
//		List<YbjReviewVO> vo = null;
//		String reviewTitle=req.getParameter("reviewTitle");
//		vo = service.readAllReview(reviewTitle);
//		String json=new Gson().toJson(vo);
//		System.out.println(json);
//		return json;
//		
//	}
//	@ResponseBody
//	@RequestMapping(value = "readreview", method = RequestMethod.GET)
//	public String readReview(HttpServletRequest req, HttpServletResponse resp) {
//		List<YbjReviewVO> vo = null;
//		String contentId=req.getParameter("ContentId");
//		vo = service.readAllReview(contentId);
//		String json=new Gson().toJson(vo);
//		System.out.println(json);
//		return json;
//		
//	}

	// 리뷰댓글목록
	@ResponseBody
	@RequestMapping(value = "review/{reviewIndex}", method = RequestMethod.GET, produces = "application/json; charset=utf8") // reviewTitle
																																// 게시판의
																																// reviewindex글의
																																// 댓글들을
																																// 불러온다.
	public List<YbjReviewReplyVO> readReviewReply(@PathVariable("reviewIndex") int reviewIndex, HttpServletRequest req,
			HttpServletResponse resp) {
		List<YbjReviewReplyVO> vo = null;
		// int reviewIndex=2;
		vo = service.readAllReview_reply(reviewIndex);
		System.out.println(vo.toString());
		return vo;
	}

	// 글 보기+조회수
	@RequestMapping(value = "/board/{index}", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String detail_count(@PathVariable("index") int index, HttpServletRequest req, HttpServletResponse resp) {
		List<YbjBoardVO> vo = null;
		vo = service.readDetailBoard(index);
		String json = new Gson().toJson(vo);
		System.out.println(json);
		return json;
	}

//	//글 수정
//	@ResponseBody
//	@RequestMapping(value = "/board/{index}", method = RequestMethod.PUT,produces = "application/json; charset=utf8")
//	public boolean updateBoard(HttpServletRequest req, HttpServletResponse resp) {
//		boolean flag=false;
//		boardVO.setBoardTitle("nojam2");
//		boardVO.setBoardBody("realnojam2");
//		boardVO.setIndex(3);
//		
//		flag = service.modBoard(boardVO);
//		if(flag==true) {
//			System.out.println("수정성공");
//		}
//		return flag;
//		}
	// 글 수정
	@ResponseBody
	@RequestMapping(value = "/board/{index}", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	public boolean updateBoard(@PathVariable("index") int index, HttpServletRequest req, HttpServletResponse resp) {
		boolean flag = false;

		boardVO.setBoardTitle(req.getParameter("boardTitle"));
		boardVO.setBoardBody(req.getParameter("boardBody"));
		boardVO.setIndex(index);

		flag = service.modBoard(boardVO);
		if (flag) {
			System.out.println("수정성공");
		}
		return flag;
	}

	// 글댓글수정
	@ResponseBody
	@RequestMapping(value = "updateboardreply", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	public boolean updateBoardReply(HttpServletRequest req, HttpServletResponse resp) {
		boolean flag = false;
		boardRPVO.setBoardIndex(1);
		boardRPVO.setReplyBody("nojam2");
		flag = service.modBoard_reply(boardRPVO);
		if (flag) {
			System.out.println("수정성공");
		}
		return flag;
	}

	// 리뷰 수정
	@ResponseBody
	@RequestMapping(value = "review", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	public boolean updateReview(HttpServletRequest req, HttpServletResponse resp) {
		boolean flag = false;
		reviewVO.setEval(4);
		reviewVO.setReviewBody("무지재밌다2");
		reviewVO.setIndex(1);
		flag = service.modReview(reviewVO);
		if (flag) {
			System.out.println("수정성공");
		}
		return flag;
	}

	// 리뷰댓글수정
	@ResponseBody
	@RequestMapping(value = "updatereviewreply", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	public boolean updateReviewReply(HttpServletRequest req, HttpServletResponse resp) {
		boolean flag = false;
		reviewRPVO.setReplyBody("realfun2");
		reviewRPVO.setReviewReplyIndex(1);
		flag = service.modReview_reply(reviewRPVO);
		if (flag) {
			System.out.println("수정성공");
		}
		return flag;
	}

	// 글삭제
	@ResponseBody
	@RequestMapping(value = "board", method = RequestMethod.DELETE, produces = "application/json; charset=utf8")
	public boolean deleteBoard(HttpServletRequest req, HttpServletResponse resp) {
		boolean flag = false;
		boardVO.setIndex(3);
		flag = service.eraseBoard(boardVO.getIndex());
		if (flag) {
			System.out.println("삭제성공");
		}
		return flag;
	}

	// 댓글삭제
	@ResponseBody
	@RequestMapping(value = "deleteboardreply", method = RequestMethod.DELETE, produces = "application/json; charset=utf8")
	public boolean deleteBoardReply(HttpServletRequest req, HttpServletResponse resp) {
		boolean flag = false;
		boardRPVO.setBoardIndex(1);
		flag = service.eraseBoard_reply(boardRPVO.getBoardIndex());
		if (flag) {
			System.out.println("삭제성공");
		}
		return flag;
	}

	// 리뷰삭제
	@ResponseBody
	@RequestMapping(value = "review", method = RequestMethod.DELETE, produces = "application/json; charset=utf8")
	public boolean deleteReview(HttpServletRequest req, HttpServletResponse resp) {
		boolean flag = false;
		reviewVO.setIndex(1);
		flag = service.eraseReview(reviewVO.getIndex());
		if (flag) {
			System.out.println("삭제성공");
		}
		return flag;
	}

	// 리뷰댓글삭제
	@ResponseBody
	@RequestMapping(value = "deletereviewreply", method = RequestMethod.DELETE, produces = "application/json; charset=utf8")
	public boolean deleteReviewReply(HttpServletRequest req, HttpServletResponse resp) {
		boolean flag = false;
		reviewRPVO.setReviewReplyIndex(1);
		flag = service.eraseReview_reply(reviewRPVO.getReviewReplyIndex());
		if (flag) {
			System.out.println("삭제성공");
		}
		return flag;
	}

//	@ResponseBody
//	@RequestMapping(value = "boardclick", method = RequestMethod.GET)
//	public String detail_count(HttpServletRequest req, HttpServletResponse resp) {
//		List<YbjBoardVO> vo = null;
//		int index=Integer.parseInt(req.getParameter("index"));
//		vo = service.readDetailBoard(index);
//		String json=new Gson().toJson(vo);
//		System.out.println(json);
//		return json;
//	}
	// 글상세보기 및 조회수
	// PathVariable을 사용
//	@RequestMapping(value = "/board/{index}", method = RequestMethod.GET)
//	@ResponseBody
//	public String detail_count(@PathVariable("index") int index,HttpServletRequest req, HttpServletResponse resp) {
//		List<YbjBoardVO> vo = null;
//		index = 8;/* Integer.parseInt(req.getParameter("index")); */
//		vo = service.readDetailBoard(index);
//		String json=new Gson().toJson(vo);
//		System.out.println(json);
//		return json;
//	}

	// @RequestParam사용 아마 RequsetParam은 index를 받아 오는 것 일듯??

}
