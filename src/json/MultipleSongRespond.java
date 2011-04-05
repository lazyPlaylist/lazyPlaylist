package json;

public class MultipleSongRespond {
	private SongRespond[] tracks;

	public MultipleSongRespond() {
		
	}
	
	public void setTracks(SongRespond[] tracks) {
		this.tracks = tracks;
	}

	public SongRespond[] getTracks() {
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
