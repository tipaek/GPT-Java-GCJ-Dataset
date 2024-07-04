
import java.util.*;
import java.lang.*;
import java.io.*;

class CodeJam
{
	public static void main (String[] args) throws java.lang.Exception
	{
	Scanner sc =  new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int k = 1;k<=T;k++) {
			int x,y;
			String S;
			String inp1 = sc.nextLine();
			String[] inp = inp1.split(" ");
			x = Integer.parseInt(inp[0]);
			y = Integer.parseInt(inp[1]);
			S = inp[2];
			int curX= x;
			int curY = y;
			int ans = 5000;
			for (int i = 0; i<S.length(); i++) {
				if (S.charAt(i) == 'N') {
					curY++;
				}
				else if (S.charAt(i) == 'S') {
					curY--;
				}
				else if (S.charAt(i) == 'W') {
					curX--;
				}
				else if (S.charAt(i) == 'E') {
					curX++;
				}
				
				if(i+1 >= Math.abs(curX)+Math.abs(curY)) {
					if(i+1 < ans)
					{
						ans = i+1;
					}
				}
			}
			if (ans != 5000) {
				System.out.println("Case #"+k+": "+ans);
			}
			else {
				System.out.println("Case #"+k+": IMPOSSIBLE");
			}
			
		}
	}
}
