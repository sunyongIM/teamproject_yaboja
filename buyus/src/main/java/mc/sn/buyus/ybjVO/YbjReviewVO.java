package mc.sn.buyus.ybjVO;

import org.springframework.stereotype.Component;
@Component
public class YbjReviewVO {
	private int index;
	private String id;
	private String ottName;
	private String reviewTitle;
	private int eval;
	private String reviewBody;
	private int reviewRecommend;
	private int reviewNotRecommend;
	private boolean spo;
	
	public YbjReviewVO() {
		
	}
	
	public YbjReviewVO(String id, String ottName, String reviewTitle, int eval, String reviewBody) {
		super();
		this.id = id;
		this.ottName = ottName;
		this.reviewTitle = reviewTitle;
		this.eval = eval;
		this.reviewBody = reviewBody;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOttName() {
		return ottName;
	}
	public void setOttName(String ottName) {
		this.ottName = ottName;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public int getEval() {
		return eval;
	}
	public void setEval(int eval) {
		this.eval = eval;
	}
	public String getReviewBody() {
		return reviewBody;
	}
	public void setReviewBody(String reviewBody) {
		this.reviewBody = reviewBody;
	}
	public int getReviewRecommend() {
		return reviewRecommend;
	}
	public void setReviewRecommand(int reviewRecommend) {
		this.reviewRecommend = reviewRecommend;
	}
	
	
	public int getReviewNotRecommend() {
		return reviewNotRecommend;
	}
	public void setReviewNotRecommend(int reviewNotRecommend) {
		this.reviewNotRecommend = reviewNotRecommend;
	}
	public boolean isSpo() {
		return spo;
	}
	public void setSpo(boolean spo) {
		this.spo = spo;
	}
	
	@Override
	public String toString() {
		return "YbjReviewVO [index=" + index + ", id=" + id + ", ottName=" + ottName + ", reviewTitle=" + reviewTitle
				+ ", eval=" + eval + ", reviewBody=" + reviewBody + ", reviewRecommend=" + reviewRecommend
				+ ", reviewNotRecommend=" + reviewNotRecommend + ", spo=" + spo + "]";
	}
	
	
}
