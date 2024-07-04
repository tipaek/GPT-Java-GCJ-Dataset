import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

	class Digit {
		char c;
		int value = -1;
		Set<Integer> pos;

		public Digit(Character c) {
			this.c = c;
			pos = new HashSet<>();
			for (int i = 0; i < 10; i++) {
				pos.add(i);
			}
			digits.values().forEach(digit-> {
				if (digit.value != -1)
					pos.remove(digit.value);
			});
		}

		public void keepOnly(int newMin, int newMax) {
			pos = pos.stream()
					.filter(value-> value >= newMin && value <= newMax)
					.collect(Collectors.toSet());

			check();
		}

		public void check() {
			if (pos.size() == 1) {
				value = pos.iterator().next();
				found++;
				digits.forEach((k,digit)-> digit.exclude(value));
			}
		}

		public void exclude(int v) {
			pos.remove(v);
			check();
		}

		public int nonZeroValue() {
			if (value == -1) {
				return pos.stream().filter(v->v != 0).findFirst().orElse(-1);
			}
			else {
				return value;
			}
		}
	}

	static class QR {
		String qs;
		String r;
		boolean chunked;

		public QR(long q, String r) {
			this.r = r;
			this.qs = String.valueOf(q);
		}
	}

	HashMap<Character, Digit> digits = new HashMap<>();
	int found = 0;
	HashSet<Character> nonZero = new HashSet<>();

	void solve() {
		int U = scanner.nextInt();
		long M = (long) Math.pow(10, U) - 1;
		scanner.nextLine();

		ArrayDeque<QR> queue = new ArrayDeque<>();

		for (int i = 0; i < 10000; i++) {
			long q = scanner.nextLong();
			String r = scanner.nextLine().trim();
			if (q == -1) {
				q = M;
			}
			queue.add(new QR(q, r));
			nonZero.add(r.charAt(0));
			r.chars().forEach(c-> digits.computeIfAbsent((char)c, Digit::new));
		}

		while (!queue.isEmpty() && found < 9) {
			QR poll = queue.poll();
			//System.out.println(poll.qs + " <> " + poll.r);

			if (poll.qs.length() == poll.r.length()) {
				// aflu ceva despre prima cifra

				int left = poll.qs.charAt(0)-'0';
				char right = poll.r.charAt(0);

				Digit digit = digits.get(right);
				if (digit.value != -1) {
					// deja stiu ce e
					poll.qs = poll.qs.substring(1);
					poll.r = poll.r.substring(1);

					if (poll.qs.length() > 0) {
						if (digit.value == left) {
							poll.chunked = true;
							queue.add(poll);
						}
					}
					continue;
				}

				// deci 'right' este intre 1 si left
				if (poll.chunked)
					digit.keepOnly(0, left);
				else
					digit.keepOnly(1, left);

				if (poll.qs.length() > 1) {
					queue.add(poll);
				}
			} else {
				char right = poll.r.charAt(0);
				Digit digit = digits.computeIfAbsent(right, Digit::new);
				digit.exclude(0);
			}
		}


		String solution = digits.entrySet().stream()
				.sorted(Comparator.comparing(e -> e.getValue().nonZeroValue()))
				.filter(e->nonZero.contains(e.getKey()))
				.map(e -> String.valueOf(e.getValue().c))
				.collect(Collectors.joining());
		String zero = digits.keySet().stream()
				.filter(key->!nonZero.contains(key))
				.map(String::valueOf)
				.collect(Collectors.joining());
		System.out.println(zero + solution);
	}

	private static Scanner scanner;
	public static void main(String[] args) {
		scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = scanner.nextInt();
		scanner.nextLine();
		for (int i = 1; i <= testCases; i++) {
			System.out.print("Case #" + i + ": ");
			new Solution().solve();
		}
	}
}