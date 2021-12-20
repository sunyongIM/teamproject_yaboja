package mc.sn.buyus.ybjDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import mc.sn.buyus.ybjVO.YbjMemVO;
import mc.sn.buyus.ybjVO.YbjReviewVO;

@Repository("memberDAO")
public class MemberDAO {

	boolean flag = false;

	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private YbjMemVO memvo;

	// 회원가입
	public boolean insertMember(YbjMemVO vo) throws DataAccessException {
		int affectedCount = sqlSession.insert("mapper.yamember.insertMember", vo);
		if (affectedCount > 0) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	// 이메일 중복체크 result=0 이면 중복없음 result=>1이면 중복임
	public boolean checkEmail(String email) throws DataAccessException {
		int affectedCount = sqlSession.selectOne("mapper.yamember.checkEmail", email);
		if (affectedCount > 0) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	// 아이디 중복체크 result=0 이면 중복없음 result=>1이면 중복임
	public boolean checkId(String id) throws DataAccessException {
		int affectedCount = sqlSession.selectOne("mapper.yamember.checkId", id);
		if (affectedCount > 0) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	// 로그인
	public YbjMemVO loginByEmailPwd(YbjMemVO vo) {
		return sqlSession.selectOne("mapper.yamember.selectByEmailPwd", vo);
	}

	// 이메일 찾기
	public String selectEmailByName(String name) {
		memvo = sqlSession.selectOne("mapper.yamember.selectEmailByName", name);
		return memvo.getYaEmail();
	}

	// 비밀번호 찾기
	public String selectPwdByEmailPhNum(YbjMemVO vo) {
		memvo = sqlSession.selectOne("mapper.yamember.selectPwdByEmailPhNum", vo);
		return memvo.getYaPwd();
	}

	// 회원탈퇴
	public boolean deleteMember(YbjMemVO vo) {
		int affectedCount = sqlSession.delete("mapper.yamember.deleteByEmailPwd", vo);
		if (affectedCount > 0) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	// 내 정보보기
	public YbjMemVO selectInfoById(String id) {
		memvo = sqlSession.selectOne("mapper.yamember.selectInfoById", id);
		return memvo;
	}
	
	// 내 정보보기(리뷰)
	public List<YbjReviewVO> selectReviewById(String id) {
		List<YbjReviewVO> list = null;
		list = sqlSession.selectList("mapper.yamember.selectReviewById", id);
		return list;
	}

	// 내 정보수정
	public boolean updateIdInfo(YbjMemVO memVO) {
		int affectedCount = sqlSession.update("mapper.yamember.updateInfo", memVO);
		if (affectedCount > 0) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	/*
	 * vo에 id,pwd값이 들어있는 객체를 전달받아서 이 두개가 db내용과 일치할 경우 그 정보를 memvo로 전달받아 리턴 public
	 * YbjMemVO loginByEmailPwd(Map<String,String> loginData) { YbjMemVO memvo=null;
	 * System.out.println("dao");
	 * memvo=sqlSession.selectOne("mapper.yamember.loginByEmail",loginData); return
	 * memvo; } 레벨조회 public ybjMemVO selectLevel() { ybjMemVO vo=null;
	 * 
	 * return vo; }
	 * 
	 * //포인트조회 public ybjMemVO selectPoint() { ybjMemVO vo=null;
	 * 
	 * return vo; }
	 * 
	 * //내가 구독하는 사람 조회 public ybjfollowVO selectFollowing() { ybjfollowVO vo=null;
	 * 
	 * return vo; }
	 * 
	 * //나를 구독하는 사람 조회
	 * 
	 * public ybjfollowVO selectFollowed() { ybjfollowVO vo=null;
	 * 
	 * return vo; }
	 */
}
