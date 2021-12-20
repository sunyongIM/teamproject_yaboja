package mc.sn.buyus.ybjVO;

public class SecurityVO {
	private YbjMemVO memVO;
	private String jwt;

	public SecurityVO() {
	}

	public SecurityVO(YbjMemVO memVO, String jwt) {
		this.memVO = memVO;
		this.jwt = jwt;
	}

	public YbjMemVO getMemVO() {
		return memVO;
	}

	public void setMemVO(YbjMemVO memVO) {
		this.memVO = memVO;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[\"memVO\":\""+this.memVO+"\", \"jwt\":\""+this.jwt+"\"]";
	}
}
