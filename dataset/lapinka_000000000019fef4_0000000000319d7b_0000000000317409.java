import java.util.*;

public class Solution {//Code Jam round 1C 2020, Overexcited Fan 
	Scanner sc;
	public int abs(int X) {
		if (X>0) return X;
		return -X;
	}
	public void findPoint(int X, int Y, String path) {
		path=path.trim();
		for (int i=0; i<path.length(); i++) {
			if (path.charAt(i)=='N') Y=Y+1;
			else if (path.charAt(i)=='S') Y=Y-1;
			else if (path.charAt(i)=='W') X=X-1;
			else if (path.charAt(i)=='E') X=X+1;
			//System.out.println("At "+(i+1)+" minutes we are at "+X+","+Y+" and distance is "+(abs(X)+abs(Y)));
			if (abs(X)+abs(Y)<=i+1) {
				System.out.println(i+1);
				return;
			}
		}
		System.out.println("IMPOSSIBLE");
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.sc = new Scanner(System.in);
		int T=sol.sc.nextInt();
		sol.sc.nextLine();
		for (int t=1; t<=T; t++) {
			int X=sol.sc.nextInt();
			int Y=sol.sc.nextInt();
			String path=sol.sc.nextLine();			
			System.out.print("Case #"+t+": ");
			sol.findPoint(X,Y,path);
		}
		
		 
	}
}
