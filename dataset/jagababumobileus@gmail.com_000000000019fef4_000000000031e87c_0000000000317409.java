import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;



public class Solution {
	
	public int retDirNS(char d) {
		if(d == 'S')
			return -1;
		if(d == 'N')
			return 1;
		return 0;
	}
	
	public int retDirEW(char d) {
		if(d == 'W')
			return -1;
		if(d == 'E')
			return 1;
		return 0;
	}
	public String process(int x, int y, String s) {
		int m = s.length();
		
		int xp[] = new int[m+1];
		int yp[] = new int[m+1];
		xp[0]=x;
		yp[0]=y;
		//System.out.print(s.charAt(0));
		for(int i=1;i<m+1;i++) {
			xp[i] = xp[i-1] + retDirEW(s.charAt(i-1));
			yp[i] = yp[i-1] +  retDirNS(s.charAt(i-1));
		}
		
		int matchVal = -1;
		for(int i=0;i<m+1;i++) {

			int tot = Math.abs(xp[i])+Math.abs(yp[i]);
			if(tot<=i) {
				matchVal=i;
				break;
			}
				
		}
		
		if(matchVal==-1)
			return "IMPOSSIBLE";
		else
			return matchVal+"";
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			int x = in.nextInt();
			int y = in.nextInt();
			String s = in.nextLine();
			s = s.trim();

			System.out.println("Case #" + i + ": " + sol.process(x,y,s));
		}
	}
}
