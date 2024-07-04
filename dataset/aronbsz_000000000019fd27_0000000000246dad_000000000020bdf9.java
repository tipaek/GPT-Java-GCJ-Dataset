import java.util.*;
import java.util.Map.Entry;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < testCases; i++) {
			int num = Integer.parseInt(sc.nextLine());
			List<Node> origNodes = new ArrayList<>();
			for(int j = 0; j < num; j++) {
				String[] n = sc.nextLine().split(" ");
				origNodes.add(new Node(Integer.parseInt(n[0]), Integer.parseInt(n[1])));
			}
			List<Node> nodes = new ArrayList<>(origNodes);
			nodes.sort(new Comparator<Node>() {
				public int compare(Node n1, Node n2) {
					return Integer.valueOf(n1.x).compareTo(n2.x);
				}
			});
			boolean notpossible = false;
			String retVal = "";
			boolean person = false;
			Node c = null;
			Node jj = null;
			Map<Node, Character> m = new HashMap<>();
			for(int j = 0; j < num; j++) {
				Node todo = nodes.get(j);
				if(j == 0) {
					c = todo;
					m.put(todo, 'C');
				}else {
					if(todo.x < c.y) { // c is busy
						if(jj == null || jj.y <= todo.x) {
							jj = todo;
							m.put(todo, 'J');
						}
						else {
							notpossible = true;
							break;
						}
					}else {
						c = todo;
						m.put(todo, 'C');
					}
				}
			}
			if(notpossible) {
				System.out.println("Case #" + (i+1) + ": " + "IMPOSSIBLE");
			}else {
				for(int j = 0; j < origNodes.size(); j++) {
					retVal += m.get(origNodes.get(j));
				}
				System.out.println("Case #" + (i+1) + ": " + retVal);
			}
		}
	}
	public static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return this.x + " " + this.y;
		}
		
	}
}