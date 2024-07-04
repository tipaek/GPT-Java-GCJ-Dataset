import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static String findMatchingString(String curr, String newS) {
		if (curr.equals(""))
			return newS;
		if (newS.equals(""))
			return curr;
		if (curr.contains(newS))
			return curr;
		if (newS.contains(curr))
			return newS;
		return "";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for (int c = 1; c <= t; c++) {
			int n = Integer.parseInt(in.readLine());
			String l = "", r = "";
			for (int i = 0; i < n; i++) {
				String[] tmp = in.readLine().split("[\\*]");
				r = findMatchingString(r, tmp[0]);
				l = findMatchingString(l, tmp[1]);
			}
			String answ = r + l;
			if (answ.equals(""))
				System.out.println("Case #" + c + ":" + " *");
			else
				System.out.println("Case #" + c + ": " + r + l);
		}
	}
}