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
	
	  /**
	   * <p>Checks if the String contains only whitespace.</p>
	   *
	   * <p><code>null</code> will return <code>false</code>.
	   * An empty String ("") will return <code>true</code>.</p>
	   *
	   * <pre>
	   * StringUtils.isWhitespace(null)   = false
	   * StringUtils.isWhitespace("")     = true
	   * StringUtils.isWhitespace("  ")   = true
	   * StringUtils.isWhitespace("abc")  = false
	   * StringUtils.isWhitespace("ab2c") = false
	   * StringUtils.isWhitespace("ab-c") = false
	   * </pre>
	   *
	   * @param str  the String to check, may be null
	   * @return <code>true</code> if only contains whitespace, and is non-null
	   * @since 2.0
	   */
	  public static boolean isWhitespace(String str) {
	      if (str == null) {
	          return false;
	      }
	      int sz = str.length();
	      for (int i = 0; i < sz; i++) {
	          if ((Character.isWhitespace(str.charAt(i)) == false)) {
	              return false;
	          }
	      }
	      return true;
	  }
}
