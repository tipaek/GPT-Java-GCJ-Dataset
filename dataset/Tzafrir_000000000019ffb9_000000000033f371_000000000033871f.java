import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.sun.org.apache.xalan.internal.xsltc.dom.MultiValuedNodeHeapIterator.HeapNode;

public class Solution {

	private DecimalFormat df = new DecimalFormat("#0.0000000");

	public static void main(String[] args) throws FileNotFoundException {
		new Solution().run();
	}

	private static class Edge {
		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", value=" + value + "]";
		}
		public Edge(int start, int end) {
			this.start = start;
			this.end = end;
			this.value = 1000000;
		}

		int start;
		int end;
		int value;
	}

	private static class Node {
		@Override
		public String toString() {
			return "Node [id=" + id + ", updateOrder=" + updateOrder + ", updateTime=" + updateTime + ", shortestPath="
					+ shortestPath + ", parentEdge=" + parentEdge + "]";
		}

		private int id;

		public Node(int id, int value) {
			this.id = id;
			if (value > 0)
				updateTime = value;
			else
				updateOrder = -value;
		}

		int updateOrder;
		int updateTime;
//		Node parent;
		int shortestPath;
		Edge parentEdge;
	}


	private void run() throws FileNotFoundException {
// 		tests();
		long before = System.nanoTime();
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		scan.nextLine();
		IntStream.range(1, T + 1).forEach(i -> {
			String res = solve(scan);
			System.out.printf("Case #%d: %s\n", i, res);
			System.err.printf("Case #%d: %s\n", i, res);
		});
		System.err.println("Took " + ((System.nanoTime() - before) / 1000000) + " ms");
		scan.close();
	}

	private String solve(Scanner scan) {
		int c = scan.nextInt();
		int d = scan.nextInt();
		List<Node> nodes = new ArrayList<>();
		nodes.add(new Node(0, 0));
		nodes.add(new Node(1, 0));
		for (int i = 0; i < c - 1; i++) {
			nodes.add(new Node(i + 2, scan.nextInt()));
		}
		Map<Integer, List<Edge>> connections = new HashMap<>();
		for (int i = 1; i <= 1000; i++) {
			connections.put(i, new ArrayList<Edge>());
		}
		List<Edge> edges =new ArrayList<>();
		for (int i = 0; i < d; i++) {
			int from = scan.nextInt();
			int to = scan.nextInt();
			Edge edge = new Edge(from, to);
			edges.add(edge);
			connections.get(from).add(edge);
		}
		
		PriorityQueue<Node> neighbours = new PriorityQueue<Solution.Node>((n1,n2) -> n1.updateOrder - n2.updateOrder);
		Set<Node> visited = new HashSet<>();
		Node parent = nodes.get(1);
		visited.add(parent);
		for (Edge e : connections.get(1)) {
			Node n = nodes.get(e.end);
			n.parentEdge = e;
			neighbours.add(n);
		}
		int t = 1;
		int updated = 1;
		while (!neighbours.isEmpty()) {
		    if (neighbours.peek().updateOrder > updated)
				throw new RuntimeException("Invalid");
			int addedItems = 0;
			while (!neighbours.isEmpty() && neighbours.peek().updateOrder == updated) {
				Node currentItem = neighbours.poll();
				currentItem.parentEdge.value = t - currentItem.shortestPath;
				visited.add(currentItem);
				for (Edge e : connections.get(currentItem.id)) {
					Node n = nodes.get(e.end);
					if (!visited.contains(n)) {
						n.parentEdge = e;
						n.shortestPath = t;
						neighbours.add(n);
					}
				}
				addedItems++;
			}
			updated += addedItems;
			t += 1;
		}
		return edges.stream().map(e -> String.valueOf(e.value)).collect(Collectors.joining(" "));
	}

	private void tests() {
		singleTest("4 4\n" + "-1 -3 -2\n" + "1 2\n" + "1 3\n" + "2 4\n" + "3 4\n" + "4 4", "1 3 1 1000000");
		singleTest("4 4 \n-1 -1 -1\n" + "		1 4\n" + "		1 2\n" + "		1 3\n" + "		2 3\n" + "		3 2",
				"1 1 1 1000000");
		singleTest("3 2 \n-2 -1\n" + "2 3\n" + "1 3", "1000000 1");
	}

	private void singleTest(String input, String expected) {
		String result = solve(new Scanner(new StringReader(input)));
		if (result.equals(expected))
			return;
		System.err.println("Wrong answer for:\n" + input);
		System.err.println("Got: " + result);
		System.err.println("Expected: " + expected);
		System.exit(1);
	}
// =================================================
	// Below are generic utility methods

	BigDecimal choose(final int N, final int K) {
		BigDecimal ret = BigDecimal.ONE;
		for (int k = 0; k < K; k++) {
			ret = ret.multiply(BigDecimal.valueOf(N - k)).divide(BigDecimal.valueOf(k + 1));
		}
		return ret;
	}
}
