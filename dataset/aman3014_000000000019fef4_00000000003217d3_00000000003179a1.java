import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		BigInteger ten = BigInteger.valueOf(10);
		BigInteger neg = BigInteger.valueOf(-1);

		for (int i = 0; i < t; ++i) {
			int u = in.nextInt(); // ???

			Map<Character, Range> map = new HashMap<>();
			for (int n = 0; n < 10000; ++n) {
				BigInteger q = in.nextBigInteger();
				String s = in.next();
				if (q.equals(neg)) {
					return;
				}
				for (int index = s.length() - 1; index >= 0; --index) {
					char c = s.charAt(index);
					int digit = q.mod(ten).intValue();
					Range r = map.getOrDefault(c, new Range());
					
					if (q.compareTo(ten) < 0) {
						r.end = Math.min(r.end, digit);
					}
					
					int length = q.toString().length();
					
					if (length > q.add(neg).toString().length() && index + 1 == length) {
						r.end = 0;
					}
					map.put(c, r);
					q = q.divide(ten);
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
}