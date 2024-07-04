import java.util.*;
import java.io.*;
class Solution {
	
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int[] pow = new int[31];
		for(int tt=1;tt<=t;tt++)
		{
			int x = s.nextInt();
			int y = s.nextInt();
			String str = s.next();
			int dist = Math.abs(x) + Math.abs(y);
			if(dist==0)
			{
				System.out.println(0);
				continue;
			}
			boolean flag = false;
			for(int i=1;i<=str.length();i++) {
				if(str.charAt(i-1)=='N')
				{
					y++;
				} else if(str.charAt(i-1)=='S') {
					y--;
				} else if(str.charAt(i-1)=='E') {
					x++;
				} else if(str.charAt(i-1)=='W') {
					x--;
				}
				dist = Math.abs(x) + Math.abs(y);
				if(dist<=i) {
					System.out.println("CASE #" + tt + ": "+i);
					flag = true;
					break;
				}
			}
			if(flag==false)
			{
				System.out.println("CASE #" + tt + ": "+"IMPOSSIBLE");
			}
		}
	}

}
