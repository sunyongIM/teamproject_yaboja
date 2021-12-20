package mc.sn.buyus.ybjController;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import mc.sn.buyus.ybjService.MemberService;
import mc.sn.buyus.ybjService.SecurityService;
import mc.sn.buyus.ybjService.SecurityServiceImpl;
import mc.sn.buyus.ybjVO.InfoReviewVO;
import mc.sn.buyus.ybjVO.SecurityVO;
import mc.sn.buyus.ybjVO.YbjMemVO;
import mc.sn.buyus.ybjVO.YbjReviewVO;

//	@ResponseBody 모두 생략가능 <== RestController 어노테이션 사용시 모두에게 적용 
@RestController("memberController")
//@RequestMapping("/member/*")
public class MemberController {
	boolean flag = false;

	@Autowired
	private MemberService memberService;
	@Autowired
	private YbjMemVO memVO;
	@Autowired
	private SecurityService securityService;

	// 아이디 중복확인
	@RequestMapping(value = "join/checkId", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public void checkId(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//	public void checkId(@RequestParam("id") String id, HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		flag = memberService.compareId(id);
		if (flag) {
//			System.out.println("Already exist id : "+id);
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		} else {
//			System.out.println("Available id : "+id);
			resp.sendError(HttpServletResponse.SC_OK);
		}
	}

	// 이메일 중복확인
	@RequestMapping(value = "join/checkEmail", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public void checkEmail(@RequestParam("email") String email, HttpServletResponse resp) throws IOException {
		flag = memberService.compareEmail(email);
		if (flag) {
//			System.out.println("Already exist email : "+email);
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		} else {
//			System.out.println("Available email : "+email);
			resp.sendError(HttpServletResponse.SC_OK);
		}
	}

	// 회원가입
	@RequestMapping(value = "join", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public void join(@RequestBody String json, HttpServletResponse resp) throws IOException {
//		System.out.println(json);
		try {
			memVO = new ObjectMapper().readValue(json, YbjMemVO.class);
			flag = memberService.addMember(memVO);
		} catch (Exception e) {
//			System.out.println("회원가입 실패");
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		if (flag) {
//			System.out.println("회원가입 성공");
			resp.sendError(HttpServletResponse.SC_OK);
		}
//		System.out.println(memVO);
	}

	// 로그인
	@RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public SecurityVO logIn(@RequestBody String json, HttpServletResponse resp) throws IOException {
//		System.out.println(json);
		securityService = new SecurityServiceImpl();
		String token = null;
		SecurityVO securityVO = null;
		YbjMemVO resultVO = new YbjMemVO();
		
		memVO = new ObjectMapper().readValue(json, YbjMemVO.class);
		resultVO = memberService.login(memVO);
		if (resultVO != null) {
//			System.out.println("success! " + resultVO);
			token = securityService.createJWT(resultVO.getYaId(), (2 * 1000 * 60 * 60));
			securityVO = new SecurityVO(resultVO, token);
		} else {
//			System.out.println("fail");
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
//		System.out.println("{resultVO:" + resultVO + ", jwt:[" + token + "]}");
		return securityVO;
	}

	// 이메일 찾기
	@RequestMapping(value = "login/findEmail", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public HashMap<String, String> findEmail(@RequestBody HashMap<String, String> json, HttpServletResponse resp)
			throws IOException {
		String name = json.get("yaName");
		String email = null;
		HashMap<String, String> result = new HashMap<String, String>();
		
		try {
			email = memberService.findEmail(name);
			result.put("yaEmail", email);
		} catch (Exception e) {
//			System.out.println("fail");
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
//		System.out.println(result);
		return result;
	}

	@RequestMapping(value = "login/findPwd", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public HashMap<String, String> findPwd(@RequestBody String json, HttpServletResponse resp) throws IOException {
		String pwd = null;
		HashMap<String, String> result = new HashMap<String, String>();
		
		memVO = new ObjectMapper().readValue(json, YbjMemVO.class);
		try {
			pwd = memberService.findPwd(memVO);			
		} catch (Exception e) {
//			System.out.println("fail");
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		result.put("yaPwd", pwd);
//		System.out.println(result);
		return result;
	}

	// 회원탈퇴
	@RequestMapping(value = "signout", method = RequestMethod.DELETE, produces = "application/json; charset=utf8")
	public void eraseMember(@RequestBody String json, HttpServletResponse resp) throws IOException {
		memVO = new ObjectMapper().readValue(json, YbjMemVO.class);
		flag = memberService.eraseMember(memVO);
		if (flag) {
			System.out.println("delete success!");
			resp.sendError(HttpServletResponse.SC_OK);
		} else {
			System.out.println("fail");
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	// 내 정보보기
	@RequestMapping(value = "me/info", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public InfoReviewVO checkJWTId(@RequestBody HashMap<String, String> json, HttpServletResponse resp)
			throws IOException {
		String jwtId = null;
		List<YbjReviewVO> review = null;
		
		String jwt = json.get("jwt");
		try {
//			System.out.println("토큰 확인 완료");
			jwtId = securityService.verifyJWT(jwt);
		} catch (Exception e) {
//			System.out.println("토큰 확인 실패");
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		memVO = memberService.findInfoById(jwtId);
		review = memberService.findReviewById(jwtId);
		InfoReviewVO result = new InfoReviewVO(memVO, review);
//		System.out.println(result);
		return result;
	}

	// 내 정보수정
	@RequestMapping(value = "me/rewrite", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	public void fixInfo(@RequestBody String json, HttpServletResponse resp) throws IOException {
		YbjMemVO memVO = new ObjectMapper().readValue(json, YbjMemVO.class);
		flag = memberService.changeInfo(memVO);
		if (flag) {
//			System.out.println("수정완료");
			resp.sendError(HttpServletResponse.SC_OK);
		} else {
//			System.out.println("수정실패");
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

/////////////////////////////////////////////////////////////////////////////////////	

	@RequestMapping("/CJWT")
	public Map<String, Object> genToken() {
		securityService = new SecurityServiceImpl();
		String token = securityService.createJWT("테스트", (2 * 1000 * 60 * 60)); // 토큰 유효시간:2시간
		System.out.println(token);
		String result = securityService.verifyJWT(token);
		System.out.println(result);
//		System.out.println("[\"result\":\"" + result + "\", \"jwt\":\"" + token + "\"]");
//		System.out.println("[result:" + result + ", jwt:" + token + "]");
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("jwt", token);
		return map;
	}

}

/*
 * BackEnd 테스트용 페이지 호출 코드
 * 
 * @RequestMapping(value = "main", method = RequestMethod.GET) public
 * ModelAndView home(HttpServletRequest req, HttpServletResponse resp) {
 * ModelAndView mav = new ModelAndView(); String url = "main";
 * mav.setViewName(url); return mav; }
 * 
 * @RequestMapping(value = "/main", method = RequestMethod.GET) public
 * ModelAndView main(HttpServletRequest req, HttpServletResponse resp) {
 * ModelAndView mav = new ModelAndView(); String url = "/App";
 * mav.setViewName(url); return mav; }
 * 
 * @RequestMapping(value = "view_join", method = RequestMethod.GET) public
 * ModelAndView viewJoin(HttpServletRequest req, HttpServletResponse resp) {
 * ModelAndView mav = new ModelAndView(); String url = "join";
 * mav.setViewName(url); return mav; }
 * 
 * @RequestMapping(value = "signout", method = RequestMethod.POST) public
 * ModelAndView signout(HttpServletRequest req, HttpServletResponse resp) {
 * ModelAndView mav = new ModelAndView(); String url = "signOut";
 * mav.setViewName(url); return mav; }
 */

//@RequestMapping(value = "login", method = RequestMethod.POST)
//public String logIn(@RequestBody String memVo, HttpServletResponse resp) {
//	YbjMemVO vo = new YbjMemVO();
//	try {
//		vo = new ObjectMapper().readValue(memVo, YbjMemVO.class);
//	} catch (JsonMappingException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (JsonProcessingException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	System.out.println("controller : " + vo);
//	System.out.println(memberService.login(vo));
//	return memberService.login(vo).getYaId();
//}

//JWT참고용 코드
//public Map<String, Object> genToken(@RequestParam(value="subject") String subject) {
//    String token = securityService.createJWT(subject, (2 * 1000 * 60 * 60)); //토큰 유효시간:2시간
//    System.out.println(token);
//    Map<String, Object> map = new LinkedHashMap<String, Object>();
//    map.put("jwt", token);
//    return map;
//}
//
//public Map<String, Object> getSubject(@RequestParam(value="token") String token) {
//    String subject = securityService.verifyJWT(token);
//    Map<String, Object> map = new LinkedHashMap<String, Object>();
//    map.put("jwt", subject);
//    return map;
//}
