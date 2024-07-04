import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			char[] S = sc.next().toCharArray();
			StringBuilder result = new StringBuilder();
			int parenthesis = 0;
			for(int a=0;a<S.length;a++){
				while(parenthesis>S[a]-'0'){
					parenthesis--;
					result.append(")");
				}
				while(parenthesis<S[a]-'0'){
					parenthesis++;
					result.append("(");
				}
				result.append(S[a]-'0');
			}
			while(parenthesis>0){
				parenthesis--;
				result.append(")");
			}
			
			System.out.printf("Case #%d: %s%n", t, result.toString());
		}
	}
}
