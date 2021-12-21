package mc.sn.buyus.ybjVO;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class YbjBoardReplyVO {
	private int boardReplyIndex;
	private int boardIndex;
	private String id;
	private String replyBody;
	private Date timestamp;
	
	
	
	public int getBoardReplyIndex() {
		return boardReplyIndex;
	}
	public void setBoardReplyIndex(int boardReplyIndex) {
		this.boardReplyIndex = boardReplyIndex;
	}
	public int getBoardIndex() {
		return boardIndex;
	}
	public void setBoardIndex(int boardIndex) {
		this.boardIndex = boardIndex;
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
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "YbjBoardReplyVO [boardReplyIndex=" + boardReplyIndex + ", boardIndex=" + boardIndex + ", id=" + id
				+ ", replyBody=" + replyBody + ", timestamp=" + timestamp + "]";
	}

	
}
