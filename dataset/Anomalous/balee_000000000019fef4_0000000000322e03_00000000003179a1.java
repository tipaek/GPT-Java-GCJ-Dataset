import java.io.FileInputStream;
import java.util.*;

public class Solution {

	private static String process(Scanner in) {
		int U = in.nextInt();
		List<Set<Integer>> chars = new ArrayList<>();
		for (int i = 0; i < 16; i++) {
			chars.add(new HashSet<>());
		}
		int[] maxCharPos = new int[255];
		Arrays.fill(maxCharPos, 99);
		
		for (int i = 0; i < 4000; i++) {
			char[] qDigits = in.next().toCharArray();
			char[] rDigits = in.next().toCharArray();
			if (qDigits.length == rDigits.length) {
				int digit = qDigits[0] - '0';
				if (digit < maxCharPos[rDigits[0]]) {
					maxCharPos[rDigits[0]] = digit;
				}
			}
			for (char rDigit : rDigits) {
				if (maxCharPos[rDigit] > 10) {
					maxCharPos[rDigit] = 10;
				}
			}
		}
		
		char[] result = new char[10];
		for (char i = 'A'; i <= 'Z'; i++) {
			if (maxCharPos[i] <= 10) {
				if (maxCharPos[i] == 10) {
					result[0] = i;
				} else {
					result[maxCharPos[i]] = i;
				}
			}
		}
		return new String(result);
	}

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in.available() > 0 ? System.in : 
			new FileInputStream(Thread.currentThread().getStackTrace()[1].getClassName() + ".practice.in"));
		int T = in.nextInt();
		for (int i = 1; i <= T; i++) {
			System.out.format("Case #%d: %s\n", i, process(in));
		}
	}
}