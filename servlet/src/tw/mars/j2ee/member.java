package tw.mars.j2ee;


/*
 * JavaBean
 * 1.implements Serializable
 * 2.public class
 * 3.屬性成員一定不可以是public
 * 4.=>getter,setter
 * 5.要有無傳參數之建構子
 * */
public class member {
	private String id;
	private String name;
	
	public member(){
		System.out.println("Member()");
	}
	public void setId(String id){
		this.id=id;
		System.out.println("setId()");
	}
	public void setName(String name){
		this.name=name;
		System.out.println("setName()");
	}
	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String toString(){
		return (name+"<br>"+id);
	}
}
