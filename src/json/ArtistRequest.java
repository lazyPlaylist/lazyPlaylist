package json;

public class ArtistRequest {
	private String artist;
	private String title;
	private Integer offset;
	
	public ArtistRequest(String artist, String title, Integer offset) {
		this.setArtist(artist);
		this.setTitle(title);
		this.setOffset(offset);
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getOffset() {
		return offset;
	}
	
	public String toString() {
		return artist + " - " + title + " - " + offset;
	}
	
	
}
