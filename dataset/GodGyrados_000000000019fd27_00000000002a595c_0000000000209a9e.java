
import java.util.*;

public class Solution {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t=s.nextInt();
		int b=s.nextInt();
		for(int z=0;z<t;z++) {
			String str="";
			
			if(b==10)
			for(int i=0;i<10;i++) {
				System.out.println(i+1);
				System.out.flush();
				str=str.concat(""+s.next().charAt(0));
			}
			
			else if(b==20) {
				for(int i=0;i<30;i++) {
					System.out.println(i+1);
					System.out.flush();
					//str=str.concat(""+s.next().charAt(0));
				}
				for(int i=0;i<10;i++) {
					System.out.println(i+1);
					System.out.flush();
					str=str.concat(""+s.next().charAt(0));
				}
				for(int i=0;i<30;i++) {
					System.out.println(i+1);
					System.out.flush();
					//str=str.concat(""+s.next().charAt(0));
				}
				for(int i=10;i<20;i++) {
					System.out.println(i+1);
					System.out.flush();
					str=str.concat(""+s.next().charAt(0));
				}
				
			}
			else if(b==100) {
				for(int j=0;j<10;j++) {
					
				for(int i=0;i<30;i++) {
					System.out.println(i+1);
					System.out.flush();
					//str=str.concat(""+s.next().charAt(0));
				}
				for(int i=10*j;i<10*(j+1);i++) {
					System.out.println(i+1);
					System.out.flush();
					str=str.concat(""+s.next().charAt(0));
				}
			}
				
			}
			
			System.out.println(str);
			System.out.flush();
			String verdict=s.next();
			if(verdict=="N") {
				System.exit(0);
				break;
				
			}
			
		}
	}
}
