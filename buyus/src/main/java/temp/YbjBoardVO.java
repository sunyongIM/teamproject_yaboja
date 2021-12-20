package temp;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class YbjBoardVO {
	private int index;
	private String id;
	private String boardTitle;
	private String boardBody;
	private Date timestamp;
	private int viewCount;
	private int boardRecommend;
	private int boardNotRecommend;
	private int report;
	private String contentTitle;
	
	
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
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardBody() {
		return boardBody;
	}
	public void setBoardBody(String boardBody) {
		this.boardBody = boardBody;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getBoardRecommand() {
		return boardRecommend;
	}
	public void setBoardRecommand(int boardRecommend) {
		this.boardRecommend = boardRecommend;
	}
	
	public int getBoardNotRecommend() {
		return boardNotRecommend;
	}
	public void setBoardNotRecommend(int boardNotRecommend) {
		this.boardNotRecommend = boardNotRecommend;
	}
	public int getReport() {
		return report;
	}
	public void setReport(int report) {
		this.report = report;
	}
	public String getContentTitle() {
		return contentTitle;
	}
	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}
	@Override
	public String toString() {
		return "YbjBoardVO [index=" + index + ", id=" + id + ", boardTitle=" + boardTitle + ", boardBody=" + boardBody
				+ ", timestamp=" + timestamp + ", viewCount=" + viewCount + ", boardRecommend=" + boardRecommend
				+ ", boardNotRecommend=" + boardNotRecommend + ", report=" + report + ", contentTitle=" + contentTitle
				+ "]";
	}
	
	
}
