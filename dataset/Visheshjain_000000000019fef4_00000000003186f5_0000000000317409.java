
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = s.nextInt();
		int cas = 1;
		while (t-- > 0) {
			long x = s.nextLong();
			long y = s.nextLong();
			String as = s.next();
			int ans =-1;
			for (int i = 0; i < as.length(); i++) {
				if (as.charAt(i) == 'N') {
					y++;
				} else if (as.charAt(i) == 'S') {
					y--;
				} else if (as.charAt(i) == 'E') {
					x++;
				} else if (as.charAt(i) == 'W') {
					x--;
				}
				
				if(i+1 >= (Math.abs(x)+Math.abs(y))) {
					
					ans = i+1;
					break;
				}
			}
			if(ans== -1)
			System.out.println("Case #" + cas + ": "+"IMPOSSIBLE");
			else 
				System.out.println("Case #" + cas + ": "+ans);

			cas++;
		}
	}
}
