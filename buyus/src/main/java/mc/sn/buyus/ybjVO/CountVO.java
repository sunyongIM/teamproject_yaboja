package mc.sn.buyus.ybjVO;

public class CountVO {
	private String genre;

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public CountVO(String genre) {
		
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "CountVO [genre=" + genre + "]";
	}
	
	
}
