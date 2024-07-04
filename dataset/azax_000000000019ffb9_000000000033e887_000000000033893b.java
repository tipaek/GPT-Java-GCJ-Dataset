import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.PriorityQueue;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = Integer.parseInt(sc.nextLine());
		for (int index = 0; index < numCases; index++) {
			String[] kq = sc.nextLine().split(" ");
			int k = Integer.parseInt(kq[0]);
			int q = Integer.parseInt(kq[1]);
			
			String program = sc.nextLine();
			String[] lefts = sc.nextLine().split(" ");
			String[] rights = sc.nextLine().split(" ");
			String[] edges = sc.nextLine().split(" ");
			
			int[] adjacency = new int[k];
			fillAdjacencyMatrix(adjacency, program);
			
			String[] essJays = sc.nextLine().split(" ");
			String[] eeJays = sc.nextLine().split(" ");
			int[] sjs = new int[q];
			int[] ejs = new int[q];
			for (int i = 0; i < q; i++) {
				sjs[i] = Integer.parseInt(essJays[i]) - 1; // I hate you, problem designers
				ejs[i] = Integer.parseInt(eeJays[i]) - 1;
			}
			
			System.out.println(
					"Case #" + (index + 1) + ": " +  solve(adjacency, sjs, ejs, k)
			);
		}
		sc.close();
		
	}
	
	private static long solve(int[] mat, int[] sjs, int[] ejs, int k) {
		long sum = 0;
		
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < sjs.length; i++) {
			int src = sjs[i];
			int target = ejs[i];
			
			if (map.containsKey(src)) {
				map.get(src).add(target);
			} else {
				Set<Integer> set = new HashSet<>();
				set.add(target);
				map.put(src, set);
			}
		}
		
		// Dijkstra
		for (Integer source : map.keySet()) {
			Set<Integer> targets = map.get(source);
			int targetsHit = 0;
			
			Set<Integer> finalized = new HashSet<Integer>();
			int[] distances = new int[k];
			for (int i = 0; i < distances.length; i++) {
				distances[i] = -1;
			}
			distances[source] = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(source, 0));
			for (int j = 0; j < k; j++) {
				Node n = pq.remove();
				finalized.add(n.value);
				distances[n.value] = n.weight;
				
				if (targets.contains(n.value)) {
					sum += n.weight;
					targetsHit++;
					if (targetsHit == targets.size()) {
						break;
					}
				}
				for (int i = 0; i < 3; i++) { // all 3 neighbors
					int neighbor, cost;
					if (i == 0) { // move left
						if (n.value == 0) {
							continue;
						} else {
							neighbor = n.value - 1;
						}
					} else if (i == 1) { // move right
						if (n.value == k - 1) {
							continue;
						} else {
							neighbor = n.value + 1;
						}
					} else { // teleport
						neighbor = mat[n.value];
					}
					if (!finalized.contains(neighbor)) {
						int weight = distances[n.value] + 1;
						if (distances[neighbor] == -1 || distances[neighbor] < weight) {
							distances[neighbor] = weight;
						}
						
						pq.add(new Node(neighbor, distances[neighbor]));
					}
				}
			}
		}
		
		return sum;
	}
	
	private static void fillAdjacencyMatrix(int[] adjacency, String program) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < program.length(); i++) {
			if (program.charAt(i) == '(') {
				stack.push(i);
			} else {
				int before = stack.pop();
				adjacency[before] = i;
				adjacency[i] = before;
			}
		}
	}
	
	private static class Node implements Comparable<Node> {
		int value;
		int weight;
		
		Node(int value, int weight) {
			this.value = value;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
}