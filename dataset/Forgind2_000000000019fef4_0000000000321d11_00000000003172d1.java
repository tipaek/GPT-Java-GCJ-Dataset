import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int z = in.nextInt();
		in.nextLine();
		for (int y = 1; y <= z; y++) {
			String[] inp = in.nextLine().trim().split(" ");
			int n = Integer.parseInt(inp[0]);
			int d = Integer.parseInt(inp[1]);
			inp = in.nextLine().trim().split(" ");
			HashMap<BigInteger, Integer> sizes = new HashMap<BigInteger, Integer>();
			for (int a = 0; a < inp.length; a++) {
				BigInteger key = new BigInteger(inp[a]);
				sizes.putIfAbsent(key, 0);
				sizes.put(key, sizes.get(key) + 1);
			}
			if (d == 2) {
				System.out.println("Case #" + y + ": " + solve2(sizes));
				continue;
			}
			else if (d == 3) {
				System.out.println("Case #" + y + ": " + solve3(sizes));
				continue;
			}
			System.out.println("Case #" + y + ": ");
		}
		in.close();
	}
	private static int solve2(HashMap<BigInteger, Integer> input) {
		for (Integer a: input.values()) {
			if (a.intValue() > 1)
				return 0;
		}
		return 1;
	}
	private static int solve3(HashMap<BigInteger, Integer> input) {
		int max = 2;
		BigInteger two = new BigInteger("2");
		for (BigInteger k : input.keySet()) {
			if (input.get(k).intValue() > 2)
				return 0;
			else if (input.containsKey(k.multiply(two))) {
				max = 1;
			}
		}
		return max;
	}
}
