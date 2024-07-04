import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		for (int i = 1; i <= T; i++) {
			String base = reader.readLine();
			String s = "";
			for (int c = 0; c < base.length(); c++) {
				String o = base.substring(c, c + 1);
				String left = "";
				String right = "";
				int pairs = Integer.parseInt(o);
				for (int q = 0; q < pairs; q++) {
					left += "(";
					right += ")";
				}
				s += left + o + right;
			}
			String out = "";
			for (int c = 0; c < s.length() - 1; c++) {
				if (!s.substring(c, c + 2).equals(")("))
					out += s.substring(c, c + 1);
				else
					c++;
			}
			out += s.substring(s.length() - 1);
			System.out.println("Case #" + i + ": " + out);
		}
	}
}
