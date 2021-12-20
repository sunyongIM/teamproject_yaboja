package mc.sn.buyus.ybjService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mc.sn.buyus.ybjDAO.CountDAO;
import mc.sn.buyus.ybjVO.CountVO2;

@Service("countService")

public class CountService {
	@Autowired
	private CountDAO dao;
	//하나씩
//	public int countGenre(String genre) {
//		int result = 0;
//		result = dao.selectCountGenre(genre);
//		
//		System.out.println(result);
//		return result;
//	}
	
	
	
	public CountVO2 countGenre() {
		CountVO2 vo=new CountVO2();
		vo.setAction(dao.countGenre("Action"));
		vo.setAdventure(dao.countGenre("Adventure"));
		vo.setAnimation(dao.countGenre("Animation"));
		vo.setComedy(dao.countGenre("Comedy"));
		vo.setCrime(dao.countGenre("Crime"));
		vo.setDocumentary(dao.countGenre("Documentary"));
		vo.setDrama(dao.countGenre("Drama"));
		vo.setFamily(dao.countGenre("Family"));
		vo.setFantasy(dao.countGenre("Fantasy"));
		vo.setHistory(dao.countGenre("History"));
		vo.setHorror(dao.countGenre("Horror"));
		vo.setMusic(dao.countGenre("Music"));
		vo.setMystery(dao.countGenre("Mystery"));
		vo.setRomance(dao.countGenre("Romance"));
		vo.setScience_Fiction(dao.countGenre("Science Fiction"));
		vo.setThriller(dao.countGenre("Thriller"));
		vo.setTV_Movie(dao.countGenre("TV Movie"));
		vo.setWar(dao.countGenre("War"));
		vo.setWestern(dao.countGenre("Western"));
		vo=new CountVO2(vo.getAction(),vo.getAdventure(),vo.getAnimation(),vo.getComedy(),vo.getCrime(),vo.getDocumentary(),vo.getDrama(),vo.getFamily(),vo.getFantasy(),vo.getHistory(),vo.getHorror(),vo.getMusic(),vo.getMystery(),vo.getRomance(),vo.getScience_Fiction(),vo.getThriller(),vo.getTV_Movie(),vo.getWar(),vo.getWestern());
		return vo;
	}
}
