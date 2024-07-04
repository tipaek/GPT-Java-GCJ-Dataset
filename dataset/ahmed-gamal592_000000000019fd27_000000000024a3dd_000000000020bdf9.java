
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	public static String solution(TreeMap<Integer, ArrayList<Integer>> map) {
		String ans = "";

		boolean fi = true;
		PriorityQueue<Integer> minqC = new PriorityQueue<>();
		PriorityQueue<Integer> minqJ = new PriorityQueue<>();

		for (Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
			ArrayList<Integer> ends = e.getValue();

			if (ends.size() > 2)
				return "IMPOSSIBLE";

			if (fi) {
				fi = false;
				minqC.add(ends.get(0));
				ans += "C";

				if (ends.size() == 2) {
					minqJ.add(ends.get(1));
					ans += "J";
				}

				continue;
			}

			int st = e.getKey();
			// System.out.println("st " + st);

			for (int en : ends) {

				if (!minqC.isEmpty() && !minqJ.isEmpty() && st < minqC.peek() && st < minqJ.peek()) {

					return "IMPOSSIBLE";
				}

				/*
				 * System.out.println("st " + st); System.out.println(" cpeek " + minqC.peek());
				 * System.out.println(" jpeek " + minqJ.peek());
				 */

				if (minqC.isEmpty() || st >= minqC.peek()) {
					minqC.poll();
					ans += "C";
					minqC.offer(en);
				} else if (minqJ.isEmpty() || st >= minqJ.peek()) {
					minqJ.poll();
					ans += "J";
					minqJ.offer(en);
				} // else
					// System.out.println("a7aaaa");
			}

			// System.out.println(minqC);
			// System.out.println(minqJ);

		}

		return ans;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = in.nextInt();
		int caaa = 1;

		while (tests > 0) {
			tests--;

			TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
			int n = in.nextInt();
			in.nextLine();

			for (int i = 0; i < n; ++i) {
				String line = in.nextLine(); // 2 1 3
				String[] sp = line.split(" ");
				int from = Integer.parseInt(sp[0]);
				int to = Integer.parseInt(sp[1]);

				ArrayList<Integer> toos = new ArrayList<>();
				if (map.containsKey(from)) {
					toos = map.get(from);
				}
				toos.add(to);
				map.put(from, toos);
			}

			System.out.println("Case #" + caaa++ + ": " + solution(map));
		}

		/*
		 * TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer,
		 * ArrayList<Integer>>(); map.put(99, new ArrayList<>(Arrays.asList(150)));
		 * map.put(1, new ArrayList<>(Arrays.asList(100))); map.put(100, new
		 * ArrayList<>(Arrays.asList(301))); map.put(2, new
		 * ArrayList<>(Arrays.asList(5))); map.put(150, new
		 * ArrayList<>(Arrays.asList(250))); System.out.println(solution(map));
		 */
	}
}
