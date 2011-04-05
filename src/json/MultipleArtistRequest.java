package json;

public class MultipleArtistRequest {
	private ArtistRequest[] tracks;

	public MultipleArtistRequest() {
		
	}
	
	public void setTracks(ArtistRequest[] tracks) {
		this.tracks = tracks;
	}

	public ArtistRequest[] getTracks() {
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
