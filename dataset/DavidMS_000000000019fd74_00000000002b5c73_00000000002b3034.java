import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String findMatchingString(String curr, String newS, boolean first) {
		if (curr.equals(""))
			return newS;
		if (newS.equals(""))
			return curr;
		if (first && curr.startsWith(newS))
			return curr;
		if (first && newS.startsWith(curr))
			return newS;
		if (!first && curr.endsWith(newS))
			return curr;
		if (!first && newS.endsWith(curr))
			return newS;
		return null;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for (int c = 1; c <= t; c++) {
			int n = Integer.parseInt(in.readLine());
			String l = "", r = "";
			boolean possible = true;
			for (int i = 0; i < n; i++) {
				String[] tmp = in.readLine().split("[\\*]");
				if (possible) {
					r = findMatchingString(r, tmp.length > 0 ? tmp[0] : "", true);
					l = findMatchingString(l, tmp.length <= 1 ? "" : tmp[1], false);
					if (r == null || l == null)
						possible = false;
				}
			}
			String answ = r + l;
			if (!possible)
				System.out.println("Case #" + c + ":" + " *");
			else if (answ.equals(""))
				System.out.println("Case #" + c + ":" + " A");
			else
				System.out.println("Case #" + c + ": " + r + l);
		}
	}
}