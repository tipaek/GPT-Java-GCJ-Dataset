import java.util.*;

public class Solution {//Code Jam quals 2020, 
	Scanner sc;
	public boolean playGame(int B) {
		if (B==10) {
		   StringBuilder answer = new StringBuilder();
		   for (int i=0; i<B; i++) {
			   System.out.println(i+1);
			   answer.append(sc.nextInt());
			   sc.nextLine();
		   }
		   System.out.println(answer.toString());
		   String reply = sc.nextLine();
		   if (reply.equals("Y")) return true;
		   else return false;
		}
		return false;
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.sc = new Scanner(System.in);
		int T=sol.sc.nextInt();
		int B=sol.sc.nextInt();
		sol.sc.nextLine();
		for (int t=1; t<=T; t++) {
			boolean res = sol.playGame(B);
			if (!res) return;
		}
		
		 
	}
}
