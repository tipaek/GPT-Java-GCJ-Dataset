import java.util.Scanner;

class Solution {

	static String makeParens(int d, String s) {
		String res = "";
		for (int i=0; i < d; ++i) {
			res += "(";
		}
		res += s;
		for (int i=0; i < d; ++i) {
			res += ")";
		}
		return res;
	}

	static String solve(String str) {
			int i = 0;
			String res = "";
			while (i < str.length()) {
				String s = str.substring(i, i+1);
				String st = "";
				//System.out.println(s + " " + st);
				while (i < str.length() && str.substring(i, i+1).equals(s)) {
					//System.out.println(i);
					st += str.substring(i, i+1);
					i++;
				}
				int d = Integer.parseInt(s);
				res += makeParens(d, st);
			}
			//System.out.println(res);
			return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i=1; i <= n; ++i) {
			String str = sc.next();
			String res = solve(str);
			System.out.println("Case #" + i + ": " + res);
		}
	}
}