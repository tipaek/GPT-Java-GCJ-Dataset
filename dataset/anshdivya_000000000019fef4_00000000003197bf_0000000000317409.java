import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for(int a=1;a<=t;a++) {
			
			int x = s.nextInt();
			int y = s.nextInt();
			String str = s.next();
			
			int ans = getMin(x, y, str, 0);
			
			if(ans == Integer.MAX_VALUE)
				System.out.println("Case #"+a+": IMPOSSIBLE");
			else
				System.out.println("Case #"+a+": "+ans);
		}

	}
	
	public static int getMin(int x, int y, String str, int time) {
		int ans = Integer.MAX_VALUE;
		
		if(Math.abs(x) + Math.abs(y) <= time)
			ans = time;
		
		if(str.length()==0)
			return ans;
		else {
			char ch = str.charAt(0);
			if(ch == 'N')
				y++;
			else if(ch == 'S')
				y--;
			else if(ch == 'E')
				x++;
			else
				x--;
		}
			return Math.min(ans, getMin(x, y, str.substring(1), time + 1));
	}

}
