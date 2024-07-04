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
	String ans = "";
		char[] c = new char[1440 + 1];
		char[] j = new char[1440 + 1];

		for (int k = 0; k < pairs.size(); k++) {

			int st = pairs.get(k).st;
			int end = pairs.get(k).end;

			boolean cok = true;
			for (int i = st; i <= end; i++) {
				if (c[i] == 'C')
					cok = false;
				else if  (c[i] == 'E' && i > st && i < end) {
					cok = false;
				}
			}
			if (cok) {
				for (int i = st; i < end; i++) {
					c[i] = 'C';
				}
				c[end] = 'E';

				ans += "C";
				continue;
			}

			boolean jok = true;
			for (int i = st; i <= end; i++) {
				if (j[i] == 'J')
					jok = false;
				else if  (j[i] == 'E' && i > st && i < end) {
					jok = false;
				}
			}
			if (jok) {
				for (int i = st; i <= end; i++) {
					j[i] = 'J';
				}
				j[end] = 'E';

				ans += "J";
				continue;
			}
			

			if (!jok && !cok)
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

	}
}
