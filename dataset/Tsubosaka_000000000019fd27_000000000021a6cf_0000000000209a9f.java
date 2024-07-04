import java.util.Scanner;

public class Solution {
	static String solve(String S){
		StringBuilder result = new StringBuilder();
		int currentDepth = 0;
		for(char c : S.toCharArray()){
			int d = c - '0';
			if(currentDepth > d){
				while(currentDepth > d){
					result.append(')');
					currentDepth--;
				}
			}else if(currentDepth < d){
				while(currentDepth < d){
					result.append('(');
					currentDepth++;
				}
			}
			result.append(d);
		}
		while(currentDepth > 0){
			result.append(')');
			currentDepth--;
		}
		return result.toString();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; ++t){
			String S = sc.next();
			System.out.printf("Case #%d: %s\n", t, solve(S));
		}
	}
}
