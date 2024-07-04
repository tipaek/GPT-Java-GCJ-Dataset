import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int k = 1; k <= t; k++) {
			int x = s.nextInt();
			int y = s.nextInt();
			String str = s.next();
			long res = 0;
			res = func(0, 0, x, y, str, 0);
            if(res<Integer.MAX_VALUE) {
            	System.out.println("Case #" + k + ": " + res);
            }
            else
			System.out.println("Case #" + k + ": " +"IMPOSSIBLE");
		}

	}

	public static long func(int s, int e, int x, int y, String str, int i) {
		if(s==x && e==y ) {
			return 0;
		}
		if(i==str.length()) {
			if(s==x && e==y ) {
				return 0;
			}
			else {
				return Integer.MAX_VALUE;
			}
		}
		long max=Integer.MAX_VALUE;
		char c=str.charAt(i);
		int dir=0;
		if(c=='S')
			e+=1;
		else if(c=='N')
			e-=1;
		else if(c=='E')
			s+=1;
		else
			s-=1;
		max=1+Math.min(func(s,e,x,y,str,i+1),
				Math.min(func(s+1,e,x,y,str,i+1),
				Math.min(func(s-1,e,x,y,str,i+1), 
				Math.min(func(s,e+1,x,y,str,i+1), func(s,e-1,x,y,str,i+1)))));
		return max;
	}

}
