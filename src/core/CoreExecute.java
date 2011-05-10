package core;
import java.io.IOException;

import com.google.gdata.util.ServiceException;

import json.MultipleArtistRequest;
import json.MultipleTitleRequest;
import json.MultipleSongRespond;



public class CoreExecute {
	//TODO It's possible to inherit everything from one class like AbstractRequest, but problems with JSON could occure
	public static MultipleSongRespond Execute(MultipleArtistRequest tr){
		RequestLoader loader = new RequestLoader();
		
		loader.SetList(tr.getTracks());
		return ExecOperation(loader);		
	}
	
	public static MultipleSongRespond Execute(MultipleTitleRequest tr){
		RequestLoader loader = new RequestLoader();
		
		loader.SetList(tr.getTracks());
		return ExecOperation(loader);	
	}
	
	private static MultipleSongRespond ExecOperation(RequestLoader loader ){
		Core operation = new Core(loader);
		try{
			
			operation.Operation();			
		}
		catch (IOException e){
			e.printStackTrace();
		}
		catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return operation.GetSongs();
	}
	
}
