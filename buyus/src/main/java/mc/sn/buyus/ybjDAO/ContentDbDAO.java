package mc.sn.buyus.ybjDAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import temp.ContentDbVO;

@Repository("ContentDbDao")
public class ContentDbDAO {
	@Autowired
	private SqlSession sqlSession;
	public int insertDB(String title) {
		int result = 0;
		result = sqlSession.insert("mapper.yaboard.insertDB", title);
		System.out.println(result);
		return result;
	}
	public int insertDB_real(ContentDbVO vo) {
		int result = 0;
		result = sqlSession.insert("mapper.yaboard.insertDB", vo);
		System.out.println(result);
		return result;
	}
}
