package core;

import java.util.ArrayList;

import json.ArtistRequest;
import json.TitleRequest;


public class RequestLoader {
	private ArrayList<TitleRequest> inTitleJSON;
	
	
	RequestLoader(){	
		inTitleJSON = new ArrayList<TitleRequest>();
	}
	
	public void Add(TitleRequest tr){
		inTitleJSON.add(tr);
	}
	
	public void Add(ArtistRequest ar){
		TitleRequest tr = new TitleRequest(ar.getArtist() + " - " + ar.getTitle(), ar.getOffset());
		inTitleJSON.add(tr);
	}
	
	public ArrayList<TitleRequest> GetList(){
		return inTitleJSON;
	}
	
	public void SetList(ArrayList<TitleRequest> alist){
		this.inTitleJSON = alist;
	}
	
	public void SetListAR(ArrayList<ArtistRequest> alist){
		for(ArtistRequest item: alist){
			this.Add(item);
		}
		
	}
	
	public void SetList(TitleRequest[] trList){
		
		for(int i = 0; i < trList.length; i++ ){
			Add(trList[i]);
		}
	}
	
	public void SetList(ArtistRequest[] trList){
		
		for(int i = 0; i < trList.length; i++ ){
			Add(trList[i]);
		}
	}

}
