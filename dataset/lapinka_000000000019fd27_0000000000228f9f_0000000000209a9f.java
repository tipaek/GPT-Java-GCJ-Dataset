import java.util.*;

public class Solution {//Code Jam quals 2020, Nesting Depth
	Scanner sc;
	public String makePar(String S) {
		StringBuilder res= new StringBuilder();
		int k=0;
		for (int i=0; i<S.length(); i++) {
			int curdigit=Character.getNumericValue(S.charAt(i));
			if (k<curdigit) {
				for (int j=0; j<curdigit-k; j++) res.append('(');
				k=curdigit;
			}
			if (k>curdigit) {
				for (int j=0; j<k-curdigit; j++) res.append(')');
				k=curdigit;
			}
			res.append(S.charAt(i));
		}
		for (int j=0; j<k; j++)  res.append(')');
		return res.toString();
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.sc = new Scanner(System.in);
		int T=sol.sc.nextInt();
		sol.sc.nextLine();
		for (int t=1; t<=T; t++) {
			String S=sol.sc.nextLine();
			System.out.println("Case #"+t+": "+sol.makePar(S));			
		}
		
		 
	}
}
