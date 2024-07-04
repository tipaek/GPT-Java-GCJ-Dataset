import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int n = in.nextInt();
			ArrayList<Node> nodes = new ArrayList<Node>();
			boolean possible = true;
			
			// Preparing the di-graph
			for (int j = 0; j < n; ++j) {
				Node node = new Node(in.nextInt(), in.nextInt());
				for (Node a : nodes) {
					a.aic(node);
				}
				nodes.add(node);
			}
			
			for (Node node : nodes) {
				if (!mark(node)) {
					possible = false;
					break;
				}
			}
			
			System.out.print("Case #" + (i + 1) + ": ");
			if (!possible) {
				System.out.println("IMPOSSIBLE");
				continue;
			}
			
			for (Node node : nodes) {
				System.out.print(node.cam ? "C" : "J");
			}
			System.out.println();
		}
	}
	
	public static boolean mark(Node start) {
	    if (start.conflicts.isEmpty()) return true;
	    
		if (!start.visited) {
			start.cam = !start.conflicts.get(0).cam;
			start.visited = true;
		}
		
		boolean cam = start.cam;
		
		for (Node c : start.conflicts) {
			if (c.visited) {
				if (c.cam == cam) {
					return false;
				}
			} else {
				c.visited = true;
				c.cam = !cam;
			}
		}
		
		return true;
	}
}

class Node {
	ArrayList<Node> conflicts = new ArrayList<>();
	int start, finish;
	boolean cam;
	boolean visited;
	
	Node(int s, int f) {
		start = s;
		finish = f;
	}
	
	void aic(Node that) { // add if conflicting
		if (start < that.start && finish > that.start) {
			conflicts.add(that);
		}
		
		else if (start < that.finish && finish > that.finish) {
			conflicts.add(that);
		}
	}
}
