import java.util.*;

public class Solution {

	public static int ans(int x,int y,char c[]) {
		if(Math.abs(x) > c.length) return -1;
// 		if(Math.abs(y) > c.length) return -1;
//		if(Math.abs(x) == c.length && y == 0) return c.length;
		
		int min = c.length*3;
		int t = 0;
		for(int i=0;i<c.length;i++)
		{
			if(c[i] == 'N') y++; 
			else if(c[i] == 'S') y--;
			else if(c[i] == 'E') x++; 
			else x--;
			
			if(Math.abs(x) + Math.abs(y) <= i + 1) 
				min = Math.min(min, i + 1);
		}
		return min == c.length*3 ? -1 : min;
	}
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for(int qq=1;qq<=t;qq++) {
			int x = scn.nextInt(), y = scn.nextInt();
			char c[] = scn.next().toCharArray();
			int ans = ans(x,y,c);
			if(ans == -1) System.out.println("Case #" + qq + ": IMPOSSIBLE");
			else System.out.println("Case #" + qq + ": " + ans(x,y,c));
		}

	}

}
