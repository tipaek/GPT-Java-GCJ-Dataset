import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

// remove package and rename class to solution
public class Solution {

	public static String solution(Map<Integer, ArrayList<Integer>> map, Map<String, Character> ordered) {
		//String ans = "";

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
				//ans += "C";
				ordered.put(e.getKey()+ "-" + ends.get(0), 'C');

				if (ends.size() == 2) {
					minqJ.add(ends.get(1));
					//ans += "J";
					ordered.put(e.getKey()+ "-" + ends.get(1), 'J');
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
					//ans += "C";
					ordered.put(e.getKey()+ "-" + en, 'C');

					minqC.offer(en);
				} else if (minqJ.isEmpty() || st >= minqJ.peek()) {
					minqJ.poll();
					//ans += "J";
					ordered.put(e.getKey()+ "-" + en, 'J');

					minqJ.offer(en);
				} // else
					// System.out.println("a7aaaa");
			}

			// System.out.println(minqC);
			// System.out.println(minqJ);

		}
		
		String ans = "";
		for(Entry<String, Character> e : ordered.entrySet()) {
			ans += e.getValue();
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
			Map<String, Character> ordered = new LinkedHashMap<String, Character>();

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
				ordered.put(from + "-" + to, '-');
			}

			System.out.println("Case #" + caaa++ + ": " + solution(map, ordered));
		}

		
		/*Map<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
		Map<String, Character> ordered = new LinkedHashMap<String, Character>();
		map.put(99, new ArrayList<>(Arrays.asList(150)));
		ordered.put("99-150", '-');
		
		map.put(1, new ArrayList<>(Arrays.asList(100)));
		ordered.put("1-100", '-');

		map.put(100, new ArrayList<>(Arrays.asList(301)));
		ordered.put("100-301", '-');

		map.put(2, new ArrayList<>(Arrays.asList(5)));
		ordered.put("2-5", '-');

		map.put(150, new ArrayList<>(Arrays.asList(250)));
		ordered.put("150-250", '-');

		System.out.println(ordered);
		System.out.println(solution(map, ordered));*/
		 
	}
}
