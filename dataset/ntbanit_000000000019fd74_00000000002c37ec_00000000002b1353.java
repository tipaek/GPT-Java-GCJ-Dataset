import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static Scanner sc;

	static int sizeMatrix = 35;
	static long pMatrix[][] = new long[sizeMatrix + 1][sizeMatrix + 1];

	public static void buildMatrix() {

		int r = 1;
		boolean check = true;
		while (r <= sizeMatrix && check) {
			pMatrix[r][1] = 1;
			for (int i = 2; i < r; i++) {
				pMatrix[r][i] = pMatrix[r - 1][i - 1] + pMatrix[r - 1][i];
			}
			pMatrix[r][r] = 1;
			r++;
		}

	}

	public static void main(String[] args) throws Exception {
		buildMatrix();

		sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("Case #%d:\n", tc);
			testCase();

		}
	}

	static boolean check[][];
	static ArrayList<Path> paths;
	static ArrayDeque<Node> queue;

	static int dx[] = { 0, 0, -1, -1, 1, 1 };
	static int dy[] = { 1, -1, -1, 0, 0, 1 };
	
	static long sum;
	static boolean stop;

	private static void testCase() {
		sum = sc.nextLong();
		stop = false;

		// bfs
		check = new boolean[sizeMatrix + 1][sizeMatrix + 1];
		paths = new ArrayList<>();
		queue = new ArrayDeque<>();

		addNode(new Node(1, 1, pMatrix[1][1]));
		while (!queue.isEmpty() && !stop) {
			Node node = queue.pop();
			for (int i = 0; i < dx.length; i++) {
				int x = node.r + dx[i];
				int y = node.k + dy[i];
				if (x >= 1 && y >= 1 && y <= x && x <= sizeMatrix && !check[x][y]) {
					addNode(new Node(x, y, pMatrix[x][y]));
				}
			}
		}
		if(stop) {
			return;
		}
		for (Path path : paths) {
			if(path.nodes.size() <= 500 && path.sum == sum) {
				for (Node node: path.nodes) {
//					System.out.printf("%d %d %d\n", node.r, node.k, node.value);
					System.out.printf("%d %d\n", node.r, node.k);
				}
				return;
			}
		}
	}

	static void addNode(Node node) {
		queue.push(node);
		check[node.r][node.k] = true;
		
		for (Path path : paths) {
			path.addNode(node);
			if(path.nodes.size() <= 500 &&path.sum == sum) {
				stop = true;
				for (Node pNode: path.nodes) {
//					System.out.printf("%d %d %d\n", pNode.r, pNode.k, pNode.value);
					System.out.printf("%d %d\n", pNode.r, pNode.k);
				}
				return;
			}
		}
		
		Path path = new Path();
		path.addNode(node);
		paths.add(path);
	}

}

class Node {
	public int r;
	public int k;
	public long value;

	public Node(int r, int k, long value) {
		this.r = r;
		this.k = k;
		this.value = value;
	}
}

class Path {
	public ArrayList<Node> nodes;
	public long sum;

	public Path() {
		nodes = new ArrayList<>();
		sum = 0;
	}

	public void addNode(Node node) {
		nodes.add(node);
		sum += node.value;
	}
}
