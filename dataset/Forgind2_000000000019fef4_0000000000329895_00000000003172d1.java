import java.math.BigInteger;
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
			System.out.println("Case #" + y + ": " + solveLarger(sizes, d));
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
		BigInteger smallestDouble = null;
		for (BigInteger k : input.keySet()) {
			if (input.get(k).intValue() > 2)
				return 0;
			else if (input.containsKey(k.multiply(two))) {
				max = 1;
			}
			else if (input.get(k).intValue() > 1) {
				if (smallestDouble == null)
					smallestDouble = k;
				else
					smallestDouble = smallestDouble.min(k);
			}
		}
		if (max == 2 && smallestDouble != null) {
			for (BigInteger k : input.keySet()) {
				if (k.compareTo(smallestDouble) > 0)
					max = 1;
			}
		}
		return max;
	}
	private static int solveLarger(HashMap<BigInteger, Integer> input, int d) {
		// [factor][count of multiples with 0 == "larger"]
		int[][] lists = new int[301][301];
		BigInteger[] nums = new BigInteger[301];
		for (int a = 0; a < nums.length; a++)
			nums[a] = new BigInteger("" + a);
		for (BigInteger b : input.keySet()) {
			for (int a = 1; a < nums.length; a++) {
				BigInteger[] ret = b.divideAndRemainder(nums[a]);
				if (ret[1].equals(nums[0])) {
					lists[a][ret[0].intValue()] += input.get(b).intValue();
				}
				else
					lists[a][0] += ret[0].intValue() * input.get(b).intValue();
			}
		}
		int best = -1;
		for (int a = 1; a < 301; a++) {
			int cuts = numCuts(lists, d, a);
			if (best == -1)
				best = cuts;
			else if (cuts != -1)
				best = Math.min(best, cuts);
		}
		return best;
	}
	private static int numCuts(int[][] lists, int d, int ind) {
		int have = 0;
		int cuts = 0;
		for (int a = 1; a < lists.length; a++) {
			have += a * lists[ind][a];
			cuts += lists[ind][a] * (a - 1);
			if (have >= d) {
				while (have >= d + 2) {
					if (have >= d + a) {
						have -= a;
						cuts -= (a - 1);
					}
					else {
						cuts -= have - d - 1;
						have = d;
					}
				}
				return cuts;
			}
		}
		if (have + lists[ind][0] >= d) {
			return cuts + d - have;
		}
		return -1;
	}
}
