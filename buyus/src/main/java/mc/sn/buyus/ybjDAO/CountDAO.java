package mc.sn.buyus.ybjDAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("CountDAO")
public class CountDAO {
	@Autowired
	private SqlSession sqlSession;
	// 하나씩
	//	public int selectCountGenre(String genre) {
//		int result = 0;
//		result = sqlSession.selectOne("mapper.count.countGenres", genre);
//		return result;
//	}
	
	 
		public int countGenre(String genre) {
		int result = 0;
		result = sqlSession.selectOne("mapper.count.countGenres", genre);
		return result;
	}
}
