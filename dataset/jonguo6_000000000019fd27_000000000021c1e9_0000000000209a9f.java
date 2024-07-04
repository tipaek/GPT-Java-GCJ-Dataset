import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = Integer.parseInt(in.nextLine());
		for(int test=1;test<=tests;test++) {
			String ret = "";
			String input = in.nextLine();
			int length = input.length();
			for(int i=0;i<length;i++) {
				int digit = input.charAt(i)-'0';
				for(int j=0;j<digit;j++) {
					ret = ret + "(";
				}
				ret = ret + digit;
				for(int j=0;j<digit;j++) {
					ret = ret + ")";
				}
			}
			int indexof = ret.indexOf(")(");
			while(indexof != -1) {
				ret = ret.substring(0,indexof)+ret.substring(indexof+2);
				indexof = ret.indexOf(")(");
			}
			System.out.println("Case #"+test+": "+ret);
		}
		in.close();
	}
}