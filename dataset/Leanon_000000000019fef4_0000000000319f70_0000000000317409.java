

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner c = new Scanner (System.in);
		int t = c.nextInt();
		int cnt=0;
		while (t>0) {
			int x = c.nextInt();
			int y = c.nextInt();
			String s=c.nextLine().substring(1);
			
			int t1=-1;
			for (int i=0;i<s.length();i++) {
				if (Math.abs(x)+Math.abs(y)<=i) {
					t1=i;break;
				}
				else {
					switch(s.charAt(i)) {
					case 'N':y++;break;
					case 'S':y--;break;
					case 'E':x++;break;
					case 'W':x--;break;
					}
				}
			}
			t--;cnt++;
			System.out.println("Case #"+cnt+": ");
			
			if (t1!=-1) {
				System.out.println(t1);
			}
			else {
				if (Math.abs(x)+Math.abs(y)<=s.length()) {
					System.out.println(s.length());
				}
				else{
					System.out.println("IMPOSSIBLE");
				}
			}
		}
	}

}
