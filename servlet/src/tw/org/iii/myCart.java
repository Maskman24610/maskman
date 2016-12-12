package tw.org.iii;

import java.util.HashMap;

public class myCart {
	private String name;
	private HashMap<String,Integer> buylist;
	public myCart(String name){
		this.name=name;
		buylist=new HashMap<>();
	}
	
	public void addItem(String itemname,int num){
		buylist.put(itemname, num);
	}
	
	public HashMap<String,Integer> getBuyList(){
		return buylist;
	}
}
