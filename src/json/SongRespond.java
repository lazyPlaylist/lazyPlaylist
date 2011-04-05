package json;


public class SongRespond {
	private String title;
	private String id;
	private String duration;
	
	public SongRespond() {
		
	}
	
	public SongRespond(String title, String id, String duration) {
		this.setDuration(duration);
		this.setId(id);
		this.setTitle(title);
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDuration() {
		return duration;
	}
	
	public String toString() {
		return title + " - " + id + " - " + duration;
	}

}
