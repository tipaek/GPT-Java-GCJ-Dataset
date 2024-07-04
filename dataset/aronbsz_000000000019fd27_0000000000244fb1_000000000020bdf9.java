import java.util.*;
import java.util.Map.Entry;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < testCases; i++) {
			int num = Integer.parseInt(sc.nextLine());
			List<Node> nodes = new ArrayList<>();
			for(int j = 0; j < num; j++) {
				String[] n = sc.nextLine().split(" ");
				nodes.add(new Node(Integer.parseInt(n[0]), Integer.parseInt(n[1])));
			}
			nodes.sort(new Comparator<Node>() {
				public int compare(Node n1, Node n2) {
					return Integer.valueOf(n1.x).compareTo(n2.x);
				}
			});
			int overlap = 0;
			Node prev = null;
			String retVal = "";
			int overlapend = -1;
			boolean currPerson = false;
			boolean notpossible = false;
			for(int j = 0; j < num; j++) {
				if(j == 0) {
					retVal += "C";
					currPerson = !currPerson;
					prev = nodes.get(0);
				}else {
					Node curr = nodes.get(j);
					if(curr.x < prev.y) {
						overlap++;
						if(overlap > 1) {
							if(overlapend != -1 && curr.x >= overlapend) {
								retVal += "J";
								overlap = 0;
								overlapend = -1;
							}else {
								notpossible = true;
								break;
							}
						}else {
							retVal += "J";
							currPerson = !currPerson;
							overlapend = curr.y;
						}
					}else {
						retVal += "C";
						prev = curr;
						overlap = 0;
					}
				}
			}
			if(notpossible) {
				System.out.println("Case #" + (i+1) + ": " + "IMPOSSIBLE");
			}else {
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