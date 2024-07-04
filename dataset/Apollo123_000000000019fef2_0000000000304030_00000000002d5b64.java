import java.util.Scanner;

public class Solution {
	
	static StringBuilder solve(int r, int s){
		if(r == 1){
			return new StringBuilder();
		}
		StringBuilder ans = new StringBuilder();
		for(int i = 0; i<s-1; i++){
			ans.append("" +r +" " + (s*r-r-i-1) + "\n");
		}
		
		ans.append(solve(r-1, s));
		
		return ans;
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		
		for(int t= 1; t<=T; t++){
			int R = scan.nextInt();
			int S = scan.nextInt();
			StringBuilder ans = solve(R, S);
			System.out.println("Case #" + t + ": " + ((R-1)*(S-1)));
			System.out.println(ans);
			
		}
		
		
		
	}
}
