import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			System.out.println("Case #" + i + ":");
			process(n);
		}
	}

	private static void process(int n) {
		List<Long> spl = split(n);
		int steps = 0;
		//System.out.println("Split " + spl.toString());
		int curR = 0;
		int curK = 0;
		System.out.println((curR + 1) + " " + (curK + 1));
		steps++;
		boolean left = true;
		int dir = 1;
		for (long r : spl) {
			//System.out.println("Down to " + r);
			while (curR < r) {
				curR++;
				curK = left ? 0 : curR;
				System.out.println((curR + 1) + " " + (curK + 1));
				steps++;
			}
			for (int i = 0; i < r; i++) {
				curK += dir;
				System.out.println((curR + 1) + " " + (curK + 1));
				steps++;
			}
			dir *= -1;
			left = !left;
		}
		long sum = 0;
		for (int i = 0; i < spl.size() - 1; i++) {
			sum += (1L << spl.get(i)) - 1;
		}
		long last = spl.get(spl.size() - 1);
		sum += (1L << last) + last;
		//System.out.println("Rest, sum " + sum);
		while(sum < n) {
			curR++;
			curK = left ? 0 : curR;
			System.out.println((curR + 1) + " " + (curK + 1));
			steps++;
			sum += 1;
		}
		//System.out.println("Steps " + steps);
	}

	private static List<Long> split(int n) {
		long i = 0;
		long c = i + (1L << i);
		while (c <= n) {
			i += 1;
			c = i + (1L << i);
		}
		i -= 1;
		c = i + (1L << i);
		List<Long> spl = new ArrayList<>();
		spl.add(i);
		while (i > 2) {
			i -= 1;
			long q = (1L << i) - 1;
			if (c + q <= n) {
				spl.add(i);
				c += q;
			}
		}
		Collections.reverse(spl);
		return spl;
	}
}
