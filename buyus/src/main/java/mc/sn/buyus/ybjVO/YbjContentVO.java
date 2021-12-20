package mc.sn.buyus.ybjVO;

import java.util.Date;

public class YbjContentVO {
	private String title;
	private String ottName;
	private String plot;
	private String main_actor;
	private String producer;
	private String produce_com;
	private Date write_time;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOttName() {
		return ottName;
	}
	public void setOttName(String ottName) {
		this.ottName = ottName;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getMain_actor() {
		return main_actor;
	}
	public void setMain_actor(String main_actor) {
		this.main_actor = main_actor;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getProduce_com() {
		return produce_com;
	}
	public void setProduce_com(String produce_com) {
		this.produce_com = produce_com;
	}
	public Date getWrite_time() {
		return write_time;
	}
	public void setWrite_time(Date write_time) {
		this.write_time = write_time;
	}
	@Override
	public String toString() {
		return "YbjContentVO [title=" + title + ", ottName=" + ottName + ", plot=" + plot + ", main_actor=" + main_actor
				+ ", producer=" + producer + ", produce_com=" + produce_com + ", write_time=" + write_time + "]";
	}
	

	
}
