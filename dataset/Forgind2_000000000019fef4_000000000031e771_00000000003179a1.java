import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int z = in.nextInt();
		in.nextLine();
		for (int y = 1; y <= z; y++) {
			int u = in.nextInt();
			in.nextLine();
			HashSet<Character> notZero = new HashSet<Character>();
			HashSet<Character> cs = new HashSet<Character>();
			HashMap<Character, Integer> le = new HashMap<Character, Integer>();
			boolean random = false;
			for (int a = 0; a < 10000; a++) {
				String[] inp = in.nextLine().trim().split(" ");
				notZero.add(inp[1].charAt(0));
				if (cs.size() < 10) {
					for (int b = 0; b < inp[1].length(); b++)
						cs.add(inp[1].charAt(b));
				}
				if (inp[0].equals("-1")) {
					random = true;
					le.putIfAbsent(inp[1].charAt(0), 0);
					le.put(inp[1].charAt(0), le.get(inp[1].charAt(0)) + 1);
				}
				else {
					le.putIfAbsent(inp[1].charAt(0), 9);
					if (inp[0].length() == inp[1].length())
						le.put(inp[1].charAt(0), Math.min(le.get(inp[1].charAt(0)), Integer.parseInt("" + inp[0].charAt(0))));
				}
			}
			StringBuilder sb = new StringBuilder();
			ArrayList<Node> al = new ArrayList<Node>();
			for (Character c: cs) {
				al.add(new Node(c, le.getOrDefault(c, 0)));
			}
			Collections.sort(al);
			if (random) {
				for (int a = 0; a < al.size(); a++)
					sb.append(al.get(al.size() - a - 1).c);
			}
			else {
				for (int a = 0; a < al.size(); a++)
					sb.append(al.get(a).c);
			}
			System.out.println("Case #" + y + ": " + sb.toString());
		}
		in.close();
	}
	private static class Node implements Comparable<Node> {
		private char c;
		private int count;
		public Node(char a, int b) {
			c = a;
			count = b;
		}
		@Override
		public int compareTo(Node arg0) {
			return count > arg0.count ? 1 : count < arg0.count ? -1 : 0;
		}
	}
}
