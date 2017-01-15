package tw.mars.mytags;

public class MarsFunctions {
	public static String sayHello(String name){
		return "Hello,"+name;
	}
	public static String sayHello(String...  names){
		String ret="";
		for(String name:names){
			ret+=String.format("Hello,%s<br>",name);
		}
		return ret;
	}
}
