import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test_cases = in.nextInt();
		for(int test = 1; test <= test_cases; test++) {
			String s = in.next();
			int opened = 0;
			String ans="";
			for(int i=0;i<s.length();i++) {
				int digit = s.charAt(i)-48;
				if(opened<digit) {
					while(opened!=digit) {
						ans+="(";
						opened++;
					}
				}
				else {
					while(opened!=digit) {
						ans+=")";
						opened--;
					}
				}
				ans+=digit;
			}
			while(opened!=0) {
				ans+=")";
				opened--;
			}
			System.out.println("Case #"+test+": "+ans);
		}
	}
}
