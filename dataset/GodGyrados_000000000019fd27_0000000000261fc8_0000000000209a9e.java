
import java.util.*;

public class Solution {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t=s.nextInt();
		int b=s.nextInt();
		for(int z=0;z<t;z++) {
			String str="";
			for(int i=0;i<10;i++) {
				System.out.println(i+1);
				System.out.flush();
				str.concat(""+s.nextLine().charAt(0));
			}
			System.out.println(str);
			System.out.flush();
			String verdict=s.nextLine();
			if(verdict=="N") {
				break;
			}
		}
		
	
	}
}
