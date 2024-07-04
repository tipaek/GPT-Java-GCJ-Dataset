import java.util.*;
public class Solution {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int T = stdIn.nextInt();
		
		for(int i = 0; i < T; i++) {
			String S = stdIn.next();
			char[] s = S.toCharArray();
			int[] num = new int[S.length()];
			for(int j = 0; j < S.length(); j++) {
				num[j] = s[j]-48;
			}
			
			String ans = "";
			for(int j = 0; j < num[0]; j++) {
				ans += "(";
			}
			ans += num[0];
			for(int j = 1; j < S.length(); j++) {
				if(num[j-1] < num[j]) {
					for(int k = 0; k < num[j]-num[j-1]; k++) {
						ans += "(";
					}
				}
				else if(num[j-1] > num[j]) {
					for(int k = 0; k < num[j-1]-num[j]; k++) {
						ans += ")";
					}
				}
				ans += num[j];
			}
			for(int j = 0; j < num[S.length()-1]; j++) {
				ans += ")";
			}
			
			System.out.println("Case #" +(i+1)+ ": " +ans);
		}

	}

}