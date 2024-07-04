import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Solution {
	
	static String res = "";
	private static String nest(String S) {
		res = "";
		permuteNesting("", S, 0, 0);
		return res;
	}

	private static void permuteNesting(String ans, String S, int index, int openBracks) {
		if(index >= S.length() && openBracks == 0) {
			if(res =="" || ans.length() < res.length()){
				res = ans;
				return;
			}
		}
		if(openBracks < 0) return;
		//adding "(". only possible when opens are less than next digit
		int digit = 0;
		if(index < S.length()) digit = Character.getNumericValue(S.charAt(index));
		if(openBracks < digit && index < S.length()){
			permuteNesting(ans + "(", S, index, openBracks + 1);
		}
		
		//adding ")" only if there is a previous open bracket and is not immediately before in ans.
		if(openBracks > 0 && ans.charAt(ans.length() -1) != '(' ){
			permuteNesting(ans + ")", S, index, openBracks - 1);
		}
		//add digit
		if(index < S.length()){
			int nextDigit = Character.getNumericValue(S.charAt(index));
			if(openBracks == nextDigit) permuteNesting(ans + ""+nextDigit, S, index + 1, openBracks);
		}
		return;
	}
	
	public static void main( String args[]) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		for(int i = 1; i <= T; i++){
			String S = in.next();
			String s = nest(S);
			System.out.println("Case #" + i + ": "+ s);
		}
		in.close();
	}

}
