package mc.sn.buyus.ybjVO;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.stereotype.Component;

@Component("ContentDbVO")

public class ContentDbVO {
	
	//genre가 JSONArray
//	private String title;
//	private JSONArray genres;
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public JSONArray getGenres() {
//		return genres;
//	}
//	public void setGenres(JSONArray genres) {
//		this.genres = genres;
//	}
//	
//	public ContentDbVO() {
//		
//	}
//	public ContentDbVO(String title, JSONArray genres) {
//		
//		this.title = title;
//		this.genres = genres;
//	}
//	@Override
//	public String toString() {
//		return "ContentDbVO [title=" + title + ", genres=" + genres + "]";
//	}
	
	
	//genre가 스트링
	private int id;
	private String title;
	private String genres;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ContentDbVO() {
		
	}
	
	public ContentDbVO(int id, String title, String genres) {
		this.id = id;
		this.title = title;
		this.genres = genres;
	}
	@Override
	public String toString() {
		return "ContentDbVO [id=" + id + ", title=" + title + ", genres=" + genres + "]";
	}

	
	//genre가 list	
//	private int id;
//	private String title;
//	private List<String> genres;
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public List<String> getGenres() {
//		return genres;
//	}
//	public void setGenres(List<String> genres) {
//		this.genres = genres;
//	}
//	public ContentDbVO(int id, String title, List<String> genres) {
//		this.id = id;
//		this.title = title;
//		this.genres = genres;
//	}
//	public ContentDbVO() {
//	
//	}
//	@Override
//	public String toString() {
//		return "ContentDbVO [id=" + id + ", title=" + title + ", genres=" + genres + "]";
//	}
	
	
	


}
