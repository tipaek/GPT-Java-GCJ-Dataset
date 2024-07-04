import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.nextLine();
		for ( int test=0; test<t; test++) {
			String s = in.nextLine();
			String res = "";
			int prev = 0;
			for ( int i=0; i<s.length(); i++) {
				String append = s.charAt(i)+"";
				int cur =  Integer.parseInt(append);
				int diff = cur - prev;
				
				if ( diff > 0) {
					while (diff-- != 0 ) {
						res+= "(";
					}
				}
				else {
					diff = Math.abs(diff);
					while (diff-- != 0 ) {
						res+= ")";
					}
				}
				res+= append;
				prev = cur;
				if ( i== s.length()-1) {
					while ( cur-- !=0 ) {
						res+=")";
					}
				}
			}
			
			System.out.println("Case #"+test+": "+ res);
		}
	}

}
