import java.util.*;
import java.util.Map.Entry;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(" ");
		int testCases = Integer.parseInt(s[0]);
		for(int i = 0; i < testCases; i++) {
			String[] line = sc.nextLine().split(" ");
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);
			Set<Node> attainable = new HashSet<Node>();
			String str = recursive(0, 0, x, y, 1, "", 0);
			System.out.println("Case #" + (i+1) + ": " + str);
		}
	}
	
	public static String recursive(int currX, int currY, int toX, int toY, int power, String sol, int cnt) {
		if(currX == toX && currY == toY) {
			return sol;
		}else if(cnt == 1){
			return "IMPOSSIBLE";
		}
		LinkedList<Node> list = new LinkedList<>();
		LinkedList<String> strs = new LinkedList<>();
		LinkedList<Integer> powers = new LinkedList<>();
		list.add(new Node(currX, currY));
		strs.add("");
		powers.add(power);
		while(!list.isEmpty()) {
			Node n = list.poll();
			String path = strs.poll();
			int pw = powers.poll();
			if(n.x == toX && n.y == toY) {
				return path;
			}
			list.add(new Node(n.x + (int)Math.pow(2, pw-1), n.y));
			strs.add(path + "E");
			powers.add(pw+1);
			list.add(new Node(n.x - (int)Math.pow(2, pw-1), n.y));
			strs.add(path + "W");
			powers.add(pw+1);
			list.add(new Node(n.x, n.y + (int)Math.pow(2, pw-1)));
			strs.add(path + "N");
			powers.add(pw+1);
			list.add(new Node(n.x, n.y - (int)Math.pow(2, pw-1)));
			strs.add(path + "S");
			powers.add(pw+1);
		}
		return "IMPOSSIBLE";
	}
	
	public static class Node{
		int x;
		int y;;
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
		public boolean equals(Object obj) { //REFERRENCE
			if (this == obj)
				return true;
			return false;
			/*if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;*/
		}
		
		@Override
		public String toString() {
			return this.x + " " + this.y;
		}
		
	}
	}
