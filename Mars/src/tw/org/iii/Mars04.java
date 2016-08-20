package tw.org.iii;

public class Mars04 {

	public static void main(String[] args) {
		char a=128;
		final  int b=9;
		switch(b){
		case 1:
			System.out.println("A");
			break;
		case 10:
			System.out.println("B");
			break;
		case b:
		    System.out.println("B2");
		    break;
		case 127:
			System.out.println("C");
			break;
		default:
			System.out.println("X");
			break;
		}

	}

}
