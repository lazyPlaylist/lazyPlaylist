package core;

import java.io.IOException;
import java.util.ArrayList;

import json.MultipleSongRespond;
import json.SongRespond;
import json.TitleRequest;

import com.google.gdata.util.ServiceException;


public class Core {
	ArrayList<ListItem> inputList;
	ArrayList<SongRespond> outSongJSON;
	ArrayList<TitleRequest> inTitleJSON;
	MultipleSongRespond songArr;
	
	Core(){
		inputList = new ArrayList<ListItem>();
		outSongJSON = new ArrayList<SongRespond>();
		inTitleJSON = new ArrayList<TitleRequest>();
	}
	
	Core(RequestLoader loader){
		this();
		SetRequestList(loader.GetList());
	}

	public void SetInputList(ArrayList<ListItem> aList){
		this.inputList = aList;
	}
	
	public void Operation() throws IOException, ServiceException{
		SongRespond song;
		YTServiceSingletone service =  YTServiceSingletone.getInstance();
		
		for(TitleRequest item: inTitleJSON){
			item.toString();			
			try{
				song = service.GetSongRespong(item.getTitle());
				outSongJSON.add(song);
				System.out.println("song: " + song.toString());
			}
			catch(IndexOutOfBoundsException e){
				System.out.println("song: " + item.getTitle() + " not found");
				//���� ����� �� ������� - ������ �� ������
			}
		}
	}
	
	public void AddListItem(ListItem aitem){
		this.inputList.add(aitem);
	}
	
	public ArrayList<SongRespond> GetSongList(){
		return outSongJSON;
	}
	
	public void SetRequestList(ArrayList<TitleRequest> alist){
		this.inTitleJSON = alist;
	}
	
	public MultipleSongRespond GetSongs(){
		MultipleSongRespond smp = new MultipleSongRespond();
		SongRespond[] tracks = new SongRespond [outSongJSON.size()];
		int i = 0;
		for(SongRespond item: outSongJSON){
			tracks[i++] = item;
			
		}
		
		
		smp.setTracks(tracks);
		
		return smp;
	}
}
