package mc.sn.buyus.ybjService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import mc.sn.buyus.ybjDAO.MemberDAO;
import mc.sn.buyus.ybjVO.YbjMemVO;
import mc.sn.buyus.ybjVO.YbjReviewVO;

@Service("memberService")
public class MemberService {

	boolean flag = false;

	@Autowired
	private MemberDAO memberDAO;

	// 회원가입
	public boolean addMember(YbjMemVO memberVO) throws DataAccessException {
		flag = memberDAO.insertMember(memberVO);
		return flag;
	}

	// 이메일 중복체크 result=0 이면 중복없음 result=>1이면 중복임
	public boolean compareEmail(String email) throws DataAccessException {
		flag = memberDAO.checkEmail(email);
		return flag;
	}

	// 아이디 중복체크 result=0 이면 중복없음 result=>1이면 중복임
	public boolean compareId(String id) throws DataAccessException {
		flag = memberDAO.checkId(id);
		return flag;
	}

	// 로그인
	public YbjMemVO login(YbjMemVO vo) {
		return memberDAO.loginByEmailPwd(vo);
	}

	// 이메일 찾기
	public String findEmail(String name) {
		String email = memberDAO.selectEmailByName(name);
		return email;
	}

	// 비밀번호 찾기
	public String findPwd(YbjMemVO vo) {
		String pwd = memberDAO.selectPwdByEmailPhNum(vo);
		return pwd;
	}

	// 회원탈퇴
	public boolean eraseMember(YbjMemVO memberVO) {
		flag = memberDAO.deleteMember(memberVO);
		return flag;
	}

	// 내 정보보기
	public YbjMemVO findInfoById(String id) {
		return memberDAO.selectInfoById(id);
	}
	
	// 내 정보보기(리뷰)
		public List<YbjReviewVO> findReviewById(String id) {
			return memberDAO.selectReviewById(id);
		}

	// 내 정보수정
	public boolean changeInfo(YbjMemVO memVO) {
		flag = memberDAO.updateIdInfo(memVO);
		return flag;
	}

	/*
	 * //레벨조회 public ybjMemVO readLevel() { ybjMemVO vo=null;
	 * 
	 * return vo; }
	 * 
	 * //포인트조회 public ybjMemVO readPoint() { ybjMemVO vo=null;
	 * 
	 * return vo; } //내가 구독하는 사람 조회 public ybjfollowVO readFollowing() { ybjfollowVO
	 * vo=null;
	 * 
	 * return vo; }
	 * 
	 * //나를 구독하는 사람 조회
	 * 
	 * public ybjfollowVO readFollowed() { ybjfollowVO vo=null;
	 * 
	 * return vo; }
	 */
}
