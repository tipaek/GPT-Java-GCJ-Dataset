import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int tests = s.nextInt();
		for(int i = 0; i < tests; i++) {
			System.out.print("Case #" + (i + 1) + ": ");
			solve(s);
		}
	}
	public static void solve (Scanner s) {
		String in = s.next();
		String out = "";
		int last = 0;
		
		for(int i = 0; i < in.length(); i++) {
			int current = Character.getNumericValue(in.charAt(i));
			int dif = current - last;
			if(dif > 0) {
				for(int j = dif; j > 0; j--) {
					out += "(";
				}
				out += current;
			} else if (dif < 0) {
				for(int j = dif; j < 0; j++) {
					out += ")";
				}
				out += current;
			} else {
				out += current;
			}
			last = current;
		}
		
		for(int i = 0; i < Character.getNumericValue(in.charAt(in.length() - 1)); i++) {
			out += ")";
		}
		System.out.println(out);
	}

}
