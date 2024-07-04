import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = input.nextInt();
		input.nextLine();
		for (int t = 1;t<=T;t++) {
			String S = input.nextLine();

			Solver s = new Solver(S);
			String ret = s.solve();

			System.out.println("Case #" + t + ": " + ret);
		}

		input.close();
	}

}

class Solver {
	String S;

	public Solver(String S){
		this.S = S;
	}

	public String solve(){
		String ret = "";
		int len = S.length();
		int depth = 0;

		for (int i=0;i<len;i++) {
			int d = (int)S.charAt(i) - 48;

			if (depth < d) {
				for (int j=0;j<d-depth;j++) {
					ret += "(";
				}
				ret += d;
				depth = d;
			} else if (depth == d) {
				ret += d;
			} else {
				for (int j=0;j<depth-d;j++) {
					ret += ")";
				}
				ret += d;
				depth = d;
			}
		}

		if (depth != 0) {
			for (int j=0;j<depth;j++) {
				ret += ")";
			}
		}

		return ret;
	}
}