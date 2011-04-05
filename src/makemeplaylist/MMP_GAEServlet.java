package makemeplaylist;
import json.MultipleSongRespond;
import json.SongRespond;
import json.TitleRequest;

import com.google.gson.Gson;

import core.CoreExecute;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.*;

import json.*;



@SuppressWarnings("serial")
public class MMP_GAEServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		
		String json = req.getParameter("json");
		String type = req.getParameter("type");

		if (type.equals("multiple_titles")) {
			MultipleTitleRequest titleRequest = new Gson().fromJson(json, MultipleTitleRequest.class);
			MultipleSongRespond result = CoreExecute.Execute(titleRequest);
			json = new Gson().toJson(result);
		} 
		else if (type.equals("multiple_artists")) {
			MultipleArtistRequest titleRequest = new Gson().fromJson(json, MultipleArtistRequest.class);
			MultipleSongRespond result = CoreExecute.Execute(titleRequest);
			json = new Gson().toJson(result);
		} 
		else if (type.equals("title")) {
			TitleRequest titleRequest = new Gson().fromJson(json, TitleRequest.class);
			SongRespond result = new SongRespond();
			json = new Gson().toJson(result);
			
		}

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.write(json);
		out.flush();
		out.close();
		
	}
	
	
	
}
