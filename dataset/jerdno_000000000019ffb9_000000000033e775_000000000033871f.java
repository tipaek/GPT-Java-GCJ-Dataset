import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//javac Solution.java
//python interactive_runner.py python.exe testing_tool.py 0 -- java Solution

public class Solution {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int i = 1; i <= T; i++) {
			int c = input.nextInt();
			int d = input.nextInt();
			List<NodeN> negatives = new ArrayList<>();
			List<NodeP> positives = new ArrayList<>();
			List<Route> routesList = new ArrayList<>();
			Map<Integer, List<Integer>> routes = new HashMap<>();
			boolean visited[] = new boolean[c];
			for (int ii = 1; ii < c; ii++) {
				int pom = input.nextInt();
				if (pom < 0) {
					negatives.add(new NodeN(ii, pom));
				} else {
					positives.add(new NodeP(ii, pom));
				}
				visited[ii] = false;
			}
			Collections.sort(negatives);
			Collections.sort(positives);
			for (int ii = 0; ii < d; ii++) {
				int pom = input.nextInt() - 1;
				int pom2 = input.nextInt() - 1;
				if (routes.get(pom) == null) {
					routes.put(pom, new ArrayList<>());
				}
				if (routes.get(pom2) == null) {
					routes.put(pom2, new ArrayList<>());
				}
				routes.get(pom).add(ii);
				routes.get(pom2).add(ii);
				routesList.add(new Route(pom, pom2, -1));
			}
			int maxP = positives.size();
			int maxN = negatives.size();
			int indexP = 0;
			int indexN = 0;
			int actCount = 1;
			int actMin = 1;
			visited[0] = true;
			Map<Integer, Integer> values = new HashMap<>();
			values.put(0, 0);
			while (indexN < maxN || indexP < maxP) {
				int actP = indexP < maxP ? positives.get(indexP).value : 1000000009;
				int actN = indexN < maxN ? negatives.get(indexN).value : -1000000009;
				if (Math.abs(actN) == actCount) {
					while(true) {
						if (indexN == maxN || negatives.get(indexN).value != actN) {
							break;
						}
//						for (int ii : routes.get(indexN)) {
//							Route r = routesList.get(ii);
//							int to = r.to == negatives.get(indexN).index ? r.from : r.to;
//							if (r.value == -1 && visited[to] == true) {
//								routesList.get(ii).value = actMin;
//							}
//						}
						values.put(negatives.get(indexN).index, actMin);
						visited[negatives.get(indexN).index] = true;
						indexN++;
						actCount++;
					}
					actMin++;
				} else {
//					for (int ii : routes.get(indexP)) {
//						Route r = routesList.get(ii);
//						int to = r.to == positives.get(indexP).index ? r.from : r.to;
//						if (r.value == -1 && visited[to] == true) {
//							routesList.get(ii).value = actP;
//						}
//					}
					values.put(positives.get(indexP).index, actP);
					visited[positives.get(indexP).index] = true;
					actCount++;
					indexP++;
					actMin = actP + 1;
				}
			}
			for (int ii = 0; ii < d; ii++) {
				Route r = routesList.get(ii);
				int pom = Math.abs(values.get(r.to) - values.get(r.from));
				if (pom == 0) {
					pom = 900000;
				}
				routesList.get(ii).value = pom;
			}
			System.out.print("Case #" + i + ": ");
			for (int ii = 0; ii < d - 1; ii++) {
				System.out.print(routesList.get(ii).value + " ");
			}
			System.out.println(routesList.get(d - 1).value);
		}
	}

	private static class Route {
		int from;
		int to;
		int value;

		public Route(int from, int to, int value) {
			this.from = from;
			this.to = to;
			this.value = value;
		}
	}

	private static class NodeP implements Comparable<NodeP> {
		int index;
		int value;

		public NodeP(int index, int value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(NodeP o) {
			return this.value - o.value;
		}
	}

	private static class NodeN implements Comparable<NodeN> {
		int index;
		int value;

		public NodeN(int index, int value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(NodeN o) {
			return o.value - this.value;
		}
	}
}