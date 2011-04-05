package core;


public class ListItem {
	private int number;
	private String searchStr;
	
	ListItem(int anum, String astr){
		this.number = anum;
		this.searchStr = astr;
	}
	
	public void SetNumber(int aNumber){
		this.number = aNumber;		
	}
	
	public int GetNumber(){
		return this.number;
	}
	
	public void SetSearchStr(String aStr){
		this.searchStr = aStr;
	}
	
	public String GetSearchStr(){
		return this.searchStr;
	}
	
	public String toString(){
		String str = "List item: " + GetSearchStr() + " (" + GetNumber() + ")";
		System.out.println(str);
		return str; 		
	}
}
