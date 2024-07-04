import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	int x;
	int y;
	int val;
	int steps;
	Node parent;
	Node (int x, int y, int val, int steps, Node parent) {
		this.x = x;
		this.y = y;
		this.val = val;
		this.steps = steps;
		this.parent = parent;
	}
}

class Solution {
	private static int[][] matrix = new int[1001][1001];

	static void init() {
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i)
					matrix[i][j] = 1;
				else
					matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j];
			}
		}
	}
	
	static boolean isSafe(int r, int c, boolean[][] visited)
	{
		return r >= 0 && r < 1001 && c >= 0 && c < 1001 && !visited[r][c] && matrix[r][c] != 0;
	}
	
	static Node bfs(int N, boolean[][] visited)
	{
		// (ri - 1, ki - 1), (ri - 1, ki), (ri, ki - 1), (ri, ki + 1), (ri + 1, ki), (ri + 1, ki + 1)
		int[] xdir = {-1, -1, 0, 0, 1, 1};
		int[] ydir = {-1, 0, -1, 1, 0, 1};
		
		Queue<Node> qu = new LinkedList<>();
		qu.add(new Node(0, 0, 1, 1, null));
		visited[0][0] = true;
		
		while(!qu.isEmpty())
		{
			Node curr = qu.poll();
			if(curr.val == N) return curr;
			
			for(int i=0;i<xdir.length;i++)
			{
				int x = curr.x + xdir[i];
				int y = curr.y + ydir[i];
				if(isSafe(x, y, visited)) 
				{
					visited[x][y] = true;
					qu.add(new Node(x, y, curr.val + matrix[x][y], curr.steps + 1, curr));
				}
			}
		}
		
		return null;
	}
	
	static void printPath(Node node) {
		if(node == null) return;
		printPath(node.parent);
		System.out.println((node.x + 1) + " " + (node.y + 1));
	}
	
	public static void main(String[] args) throws Exception {
		init();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test; t++) {
			int N = Integer.parseInt(br.readLine());
			
			boolean[][] visited = new boolean[1001][1001];
			Node node = bfs(N, visited);
			
			System.out.println("Case #" + t + ":");
			printPath(node);
		}
	}

}