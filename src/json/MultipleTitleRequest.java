package json;

public class MultipleTitleRequest {
	private TitleRequest[] tracks;

	public MultipleTitleRequest() {
		
	}
	
	public void setTracks(TitleRequest[] titles) {
		this.tracks = titles;
	}

	public TitleRequest[] getTracks() {
		return tracks;
	}
	
	public String toString() {
		String result = new String();
		for (int i = 0; i < tracks.length; i++) {
			result += tracks[i].toString() + ' ';
		}
		return result;
	}
}
