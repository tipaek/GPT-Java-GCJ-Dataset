import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();

		for (int i = 0; i < t; ++i) {
			int u = in.nextInt(); // ???

			Map<Character, Range> map = new HashMap<>();
			for (int n = 0; n < 10000; ++n) {
				int number = in.nextInt();
				String s = in.next();
				int q = number;
				if (q == -1) {
					return;
				}
				for (int index = s.length() - 1; index >= 0; --index) {
					char c = s.charAt(index);
					int digit = q % 10;
					Range r = map.getOrDefault(c, new Range());
					if (q < 10) {
						r.end = Math.min(r.end, digit);
					}
					
					if (Integer.toString(q).length() > Integer.toString(q - 1).length() && index + 1 == Integer.toString(q).length()) {
						r.end = 0;
					}
					map.put(c, r);
					q /= 10;
				}
			}
			
			char[] ans = new char[10];
			for (Map.Entry<Character, Range> entry : map.entrySet()) {
				ans[entry.getValue().end] = entry.getKey();
			}
			
			System.out.println("Case #" + (i + 1) + ": " + new String(ans));
		}
	}
}

class Range {
	int start = 0;
	int end = 9;

	@Override
	public String toString() {
		return start + " -> " + end;
	}
}