import java.util.Scanner;

public class Solution {
	static String ss = "";
	static void fun(int n) {
		for(int i = 0; i < Math.abs(n); i++) {
			if(n > 0) ss += "(";
			else ss += ")";
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s;
		int n;
		n = in.nextInt();
		int cnt = 1;
		while(n != 0) {
			ss = "";
			s = in.next();
			int t2 = 0;
			int t1 = Character.getNumericValue(s.charAt(0));
			fun(t1);
			for(int i = 0; i < s.length(); i++) {
				t2 = Character.getNumericValue(s.charAt(i));
				fun(t2 - t1);
				t1 = t2;
				ss += s.charAt(i);
			}
			for(int i = 0; i < t2; i++) {
				ss += ")";
			}
			n--;
			System.out.println("Case #" + cnt + ": " + ss);
			cnt++;
		}
		in.close();
	}
}
