import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Solution {

	static class Pair {
		int st;
		int end;

		public Pair(int st, int end) {
			this.st = st;
			this.end = end;
		}
	}

	public static String solution(ArrayList<Pair> pairs) {

		if (pairs.isEmpty())
			return "";

		String ans = "";
		Map<Character, ArrayList<Pair>> map = new HashMap<Character, ArrayList<Pair>>();

		map.put('J', new ArrayList<>());

		ArrayList<Pair> in = new ArrayList<>();
		in.add(new Pair(pairs.get(0).st, pairs.get(0).end));
		map.put('C', in);
		ans += "C";

		for (int i = 1; i < pairs.size(); i++) {
			Pair curr = pairs.get(i);

			ArrayList<Pair> cp = map.get('C');
			
			//System.out.println("curr " + curr.st + " : " + curr.end);
			
			boolean okc = true;
			for (int j = 0; j < cp.size(); j++) {
				if ((curr.st >= cp.get(j).st &&  curr.end <= cp.get(j).end) ||
						(curr.st >= cp.get(j).st &&  curr.st < cp.get(j).end) ||
						(curr.st <= cp.get(j).st	&& curr.end > cp.get(j).st)) {
					okc = false;
				}
			}
			if (okc) {
				cp.add(curr);
				map.put('C', cp);
				ans += "C";
				
				continue;
			}

			cp = map.get('J');
			boolean okj = true;
			for (int j = 0; j < cp.size(); j++) {
				if ((curr.st >= cp.get(j).st &&  curr.end <= cp.get(j).end) ||
						(curr.st >= cp.get(j).st &&  curr.st < cp.get(j).end) ||
						(curr.st <= cp.get(j).st	&& curr.end > cp.get(j).st)) {
					okj = false;
				}
			}
			if (okj) {
				cp.add(curr);
				map.put('J', cp);
				ans += "J";
			}
			//System.out.println("ff " + okc + " sf " + okj);
			//System.out.println("ans " + ans);
			if(!okj && !okc)
				return "IMPOSSIBLE";
		}

		return ans;
	}

	public static void main(String[] args) {


		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = in.nextInt();
		int caaa = 1;

		while (tests > 0) {
			tests--;

			ArrayList<Pair> pairs = new ArrayList<>();
			
			int n = in.nextInt();
			in.nextLine();

			for (int i = 0; i < n; ++i) {
				String line = in.nextLine(); // 2 1 3
				String[] sp = line.split(" ");
				int from = Integer.parseInt(sp[0]);
				int to = Integer.parseInt(sp[1]);

				pairs.add(new Pair(from, to));
			}

			System.out.println("Case #" + caaa++ + ": " + solution(pairs));
		}

		/*ArrayList<Pair> pairs = new ArrayList<>();
		pairs.add(new Pair(360, 480));
		pairs.add(new Pair(420, 540));
		pairs.add(new Pair(600, 660));


		System.out.println(solution(pairs));*/
}
	}