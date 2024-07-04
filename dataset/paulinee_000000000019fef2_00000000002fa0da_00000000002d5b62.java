import java.util.*;
public class Solution {
	static ArrayList<String> solutions;
	static int destx, desty;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		for(int i = 0; i < n; i++) {
			destx = kb.nextInt();
			desty = kb.nextInt();
			solutions = new ArrayList<>();
			solve("", 0, 0, 0);
			int shortest = Integer.MAX_VALUE;
			String ans = "";
			for(String s : solutions) {
				if(s.length()<shortest) {
					ans = s;
					shortest = s.length();
				}
			}
			System.out.print("Case #"+(i+1)+": ");
			if(ans.length()==0) 
				System.out.println("IMPOSSIBLE");
			else
				System.out.println(ans);
		}
	}
	public static void solve(String str, int x, int y, int t) {
		if(destx == x && desty == y) {
			solutions.add(str);
		}
		if(str.length() > 5) return;
	//	System.out.println(str + " "+x+" "+y);
		String[] dir = {"N","E","S","W"};
		int[] dx = {1,1,-1,-1};
		for(int i = 0; i < 4; i++) {
			if(i%2==1)
				solve(str+dir[i], (int)(x+dx[i]*Math.pow(2,t)), y, t+1);
			else
				solve(str+dir[i], x, (int)(y+dx[i]*Math.pow(2, t)), t+1);
		}
			
	}
}
