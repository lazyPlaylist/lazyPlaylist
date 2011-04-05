package core;


public class Utils {
	public static String SecondsToString(long time){
		String result= "";
		if (time != 0){
				int seconds = (int)(time % 60);
			    int minutes = (int)((time/60) % 60);
			    int hours = (int)((time/3600) % 24);
			    String secondsStr = (seconds<10 ? "0" : "")+ seconds;
			    String minutesStr = (minutes<10 ? "0" : "")+ minutes;
			    String hoursStr = (hours<10 ? "0" : "")+ hours;
			    
			    if (hours != 0)
			    	result = hoursStr + ":";
			    if (minutes != 0)
			    	result += minutesStr + ":";
			    
			    result += secondsStr;
			    	
		}
		else
			result = "00 : 00 : 00";
		
	    return new String(result);
	  }
}
