import java.util.*;
 
public class Main {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int h=scan.nextInt();
		int m=scan.nextInt();
		
		if (m>=45)
			m-=45;
		else if (h!=0) {
			h-=1;
			m=60-45+m;
		}
		else {
			h=23;
			m=60-45+m;
		}
		
		System.out.println(h+" "+m);
	}
 
}