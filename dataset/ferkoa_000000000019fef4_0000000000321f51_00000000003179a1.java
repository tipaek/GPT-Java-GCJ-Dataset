import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	//////////////////////////////////////////////////
	private static String solve(int u, long[] q, char[][] r) {
		Set<Character> charsAtStart = new HashSet<>(10);
		Map<Character, Integer> charsFreq = new HashMap<>(10);
		for (int i = 0, leni = q.length; i < leni; i++) {
			for (int j = 0, lenj = r[i].length; j < lenj; j++) {
				if (j == 0) {
					charsAtStart.add(r[i][0]);
				}
				charsFreq.merge(r[i][j], 1, (oldV, newV) -> oldV + 1);
			}
		}
		Set<Character> zeroChar = new HashSet<>(charsFreq.keySet());
		zeroChar.removeAll(charsAtStart);
		Character c0 = null;
		if (zeroChar.size() == 1) {
			c0 = zeroChar.iterator().next();
			charsFreq.remove(c0);
		}
		List<Character> chars = new ArrayList<>(charsFreq.keySet());
		chars.sort((c1, c2) -> {
			int f1 = charsFreq.get(c1);
			int f2 = charsFreq.get(c2);
			return f1 > f2 ? -1 : f1 == f2 ? 0 : 1;
		});
		StringBuilder sb = new StringBuilder(10);
		if (c0 != null) {
			sb.append(c0);
		}
		for (Character c : chars) {
			sb.append(c);
		}
		return sb.toString();
	}

	//////////////////////////////////////////////////
	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintStream out = System.out;

		int t = in.nextInt();
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			int u = in.nextInt();
			in.nextLine();
			long[] q = new long[10000];
			char[][] r = new char[10000][];
			for (int j = 0, len = q.length; j < len; j++) {
				q[j] = in.nextLong();
				r[j] = in.nextLine().trim().toCharArray();
			}
			out.println("Case #" + i + ": " + solve(u, q, r));
		}
		in.close();
	}
}