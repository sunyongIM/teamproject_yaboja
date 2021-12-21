package mc.sn.buyus.ybjVO;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("infoReVO")
public class InfoReviewVO {
	private YbjMemVO memVO;
	private List<YbjReviewVO> review;

	public InfoReviewVO() {

	}

	public InfoReviewVO(YbjMemVO memVO, List<YbjReviewVO> review) {
		this.memVO = memVO;
		this.review = review;
	}

	public YbjMemVO getMemVO() {
		return memVO;
	}

	public void setMemVO(YbjMemVO memVO) {
		this.memVO = memVO;
	}

	public List<YbjReviewVO> getReview() {
		return review;
	}

	public void setReview(List<YbjReviewVO> review) {
		this.review = review;
	}

}
