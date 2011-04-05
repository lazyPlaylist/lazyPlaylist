package json;

public class TitleRequest {
	private String title;
	private Integer offset;
	
	public TitleRequest(String title, Integer offset) {
		this.setTitle(title);
		this.setOffset(offset);
	}
	
	public TitleRequest() {
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public int getOffset() {
		return offset;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
	public String toString() {
		return title + " - " + offset;
	}
	
	
	
}
