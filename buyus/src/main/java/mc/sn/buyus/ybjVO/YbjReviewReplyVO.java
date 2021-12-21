package mc.sn.buyus.ybjVO;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class YbjReviewReplyVO {
	private int reviewIndex;
	private int reviewReplyIndex;
	private String id;
	private String replyBody;
	private int replyRecommend;
	private int replyNotRecommend;
	private Date timestamp;
	
	public int getReviewIndex() {
		return reviewIndex;
	}
	public void setReviewIndex(int reviewIndex) {
		this.reviewIndex = reviewIndex;
	}
	
	public int getReviewReplyIndex() {
		return reviewReplyIndex;
	}
	public void setReviewReplyIndex(int reviewReplyIndex) {
		this.reviewReplyIndex = reviewReplyIndex;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReplyBody() {
		return replyBody;
	}
	public void setReplyBody(String replyBody) {
		this.replyBody = replyBody;
	}
	public int getReplyRecommend() {
		return replyRecommend;
	}
	public void setReplyRecommand(int replyRecommend) {
		this.replyRecommend = replyRecommend;
	}
	public int getReplyNotRecommend() {
		return replyNotRecommend;
	}
	public void setReplyNotRecommand(int replyNotRecommend) {
		this.replyNotRecommend = replyNotRecommend;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "YbjReviewReplyVO [reviewIndex=" + reviewIndex + ", reviewReplyIndex=" + reviewReplyIndex + ", id=" + id
				+ ", replyBody=" + replyBody + ", replyRecommend=" + replyRecommend + ", replyNotRecommend="
				+ replyNotRecommend + ", timestamp=" + timestamp + "]";
	}

	
}
