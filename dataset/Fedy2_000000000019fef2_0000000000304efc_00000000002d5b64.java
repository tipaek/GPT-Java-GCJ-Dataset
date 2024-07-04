/**
 * 
 */

import java.util.*;
import java.io.*;

/**
 * @author fedy2
 *
 */
public class Solution {
	
	static class Move {
		int[] stack;
		int a;
		int b;
		Move parent;
		String key;
		
		public Move(int[] stack, int a, int b, Move parent) {
			this.stack = stack;
			this.a = a;
			this.b = b;
			this.parent = parent;
			this.key = Arrays.toString(stack);
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(stack);
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
			Move other = (Move) obj;
			if (!Arrays.equals(stack, other.stack))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Move [stack=" + Arrays.toString(stack) + ", a=" + a + ", b=" + b + "] -> " + parent;
		}		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		//System.out.println("t: " + t);

		for (int tc = 1; tc <= t; tc++) {
			int r = in.nextInt();
			int s = in.nextInt();
			
			solve(tc, r, s);
		}
		in.close();
	}
	
	private static void solve(int tc, int r, int s) {
		//System.out.println("tc: " + tc);
		//System.out.println("r: " + r);
		//System.out.println("s: " + s);
		
		int[] stack = new int[r*s];
		int ri = 1;
		for (int i = 0; i < r*s; i++) {
			stack[i] = ri;
			ri++;
			if (ri > r) {
				ri = 1;
			}
		}
		
		List<Move> moves = find(stack);
		
		System.out.println("Case #" + tc + ": " + moves.size());
		for (int i = moves.size() - 1; i >= 0; i--) {
			Move move = moves.get(i);
			System.out.println(move.a + " " + move.b);
		}
	}
	
	private static List<Move> find(int[] stack) {
		Queue<Move> q = new LinkedList<Move>();
		q.add(new Move(stack, -1, -1, null));
		
		Set<String> saw = new HashSet<>();
		
		while(!q.isEmpty()) {
			Move m = q.poll();
			//System.out.println(m);
			
			if (ordered(m.stack)) {
				//System.out.println("FOUND IT: " + m);
				List<Move> moves = new ArrayList<>();
				Move c = m;
				while(c!=null) {
					if (c.a > 0) {
						moves.add(c);
					}
					c = c.parent;
				}
				return moves;
			}
			
			if (saw.contains(m.key)) continue;
			saw.add(m.key);
			
			for (int a = 1; a <= m.stack.length; a++) {
				for (int b = 1; b <= m.stack.length - a; b++) {
					int[] ns = swap(m.stack, a, b);
					Move nm = new Move(ns, a, b, m);
					q.add(nm);
				}
			}
		}
		
		//System.out.println("Not found");
		return Collections.emptyList();
	}
	
	private static int[] swap(int[] stack, int a, int b) {
		//System.out.println("a: " + a + " b: " + b);
		//System.out.println("stack: " + Arrays.toString(stack));
		
		int[] swap = new int[stack.length];
		
		// save a
		int[] tmp = new int[a];
		for (int i = 0; i < a; i++) {
			tmp[i] = stack[i]; 
		}
		
		// copy b
		for (int i = 0; i < b; i++) {
			swap[i] = stack[a + i];
		}
		
		// copy a
		for (int i = 0; i < a; i++) {
			swap[b + i] = tmp[i];
		}
		
		// copy remaining
		for (int i = 0; i < stack.length - a - b; i++) {
			swap[a + b + i] = stack[a + b + i];
		}
		
		//System.out.println("swap: " + Arrays.toString(swap));
		
		return swap;
	}
	
	private static boolean ordered(int[] stack) {
		int prev = 0;
		for (int card:stack) {
			if (card < prev) return false;
			prev= card;
		}
		return true;
	}

}
