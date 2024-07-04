import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 1; i <= n; i++) {
			String curr = nest(br.readLine());
			System.out.println("Case #" + i + ": " + curr);
		}
	}
	
	public static String nest(String input) {
		int parenthesesOpen = 0;
		String answer = "";
		for(int i = 0; i < input.length(); i++) {
			int currVal = Integer.parseInt(input.substring(i, i+1));
			while(currVal > parenthesesOpen) {
				answer += "(";
				parenthesesOpen++;
			}
			while(currVal < parenthesesOpen) {
				answer += ")";
				parenthesesOpen--;
			}
			answer += currVal;
		}
		while(parenthesesOpen > 0) {
			answer += ")";
			parenthesesOpen--;
		}
		return answer;
	}

}
