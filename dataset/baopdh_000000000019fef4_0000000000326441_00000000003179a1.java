import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt(), tmp;
		for (int k = 1; k <= t; ++k) {
			int u = scanner.nextInt();

			Map<Character, Character> map = new HashMap<>();
			Set<Character> notZero = new HashSet<>();
			Queue<String> queue = new LinkedList<>();

			for (int i = 0; i < 10000; ++i) {
				String s1 = scanner.next();
				String s2 = scanner.next();

				notZero.add(s2.charAt(0));
				for (char c: s2.toCharArray()) {
					if (map.get(c) == null)
						map.put(c, '9');
				}

				if (s1.length() == s2.length()) {
					char c = map.get(s2.charAt(0));

					if (s1.charAt(0) < c) {
						map.put(s2.charAt(0), s1.charAt(0));
					}

					if (s1.length() > 1) {
						queue.offer(s1);
						queue.offer(s2);
					}
				}
			}

			while (!queue.isEmpty()) {
				String s1 = queue.poll();
				String s2 = queue.poll();

				if (map.get(s2.charAt(0)) == s1.charAt(0)) {
					s1 = s1.substring(1);
					s2 = s2.substring(1);

					char c = map.get(s2.charAt(0));

					if (s1.charAt(0) < c) {
						map.put(s2.charAt(0), s1.charAt(0));
					}

					if (s1.length() > 1) {
						queue.offer(s1);
						queue.offer(s2);
					}
				}
			}

			char[] bucket = new char[10];
			map.forEach((key, v) -> bucket[v - '0'] = key);

			System.out.print("Case #" + k + ": ");
			for (int i = 0; i < 10; ++i)
				System.out.print(bucket[i]);

			System.out.println("");
		}
		scanner.close();
	}
}