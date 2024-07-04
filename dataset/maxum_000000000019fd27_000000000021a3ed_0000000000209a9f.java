import java.util.*;
import java.io.*;


public class Solution {


	public static String transformString(String digitStr) {
		StringBuilder res = new StringBuilder();
		if (digitStr.length() == 0) {
			return "";
		}

		int curr = Integer.parseInt(String.valueOf(digitStr.charAt(0)));
		int pars = curr;
		for (int i = 0; i < curr; i++) {
			res.append('(');
		}
		res.append(curr);


		int prev = curr;
		for (int i = 1; i < digitStr.length(); i++) {
			curr = Integer.parseInt(String.valueOf(digitStr.charAt(i)));
			if (prev > curr) {
				for (int z = 0; z < prev-curr; z++) {
					res.append(')');
				}
				pars += (curr-prev);
			} else if (prev < curr) {
				for (int z = 0; z < curr-prev; z++) {
					res.append('(');
				}
				pars += (curr-prev);
			}

			res.append(curr);
			prev = curr;
		}

		for (int i = 0; i < pars; i++) {
			res.append(')');
		}

		return res.toString();

	}



	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(
					new InputStreamReader(System.in)));

		int T = in.nextInt(); in.nextLine();
		for (int i = 1; i <= T; i++) {
			String digitStr = in.nextLine();
			System.out.println("Case #" + i + ": " + transformString(digitStr));
		}

	}

}
