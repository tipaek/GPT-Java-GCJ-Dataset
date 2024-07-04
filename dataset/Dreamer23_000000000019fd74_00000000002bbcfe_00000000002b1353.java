import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	private static void test() throws IOException {
		String s;
		BufferedReader read = new BufferedReader(new FileReader("data/testIn"));
		String total = "";
		while((s = read.readLine())!= null) total += s + "\n";
		InputStream testInput = new ByteArrayInputStream( total.getBytes("UTF-8") );
		System.setIn(testInput);
		read.close();
	}

	
	public static void main(String[] args) throws IOException {
//		test();
		final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		final int t = Integer.parseInt(in.nextLine());
		for (int c = 1; c <= t; ++c) {
			System.out.println("Case #" + c + ": " + getResult(Integer.parseInt(in.nextLine())));
		}
		in.close();
	}
	
	private static class Location {
		final int r, k;
		private Location(int r, int k) {
			this.r = r;
			this.k = k;
		}
		
		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Location)) return false;
			Location lo = (Location)o;
			return this.r == lo.r && this.k == lo.k;
		}
	}
	
	private static int[][] pregeneratePascal(int depth) {
		int[][] pascal = new int[depth][depth];
		for (int i = 0; i < depth; i++) {
			pascal[i][0] = 1;
			pascal[i][i] = 1;
		}
		for (int r = 2; r < depth; r++) for(int k = 1; k < r; k++) {
			pascal[r][k] = pascal[r-1][k-1] + pascal[r-1][k];
		}
		return pascal;
	}
	
	private static String listToString(List<Location> locs) {
		if(locs == null) return "ERROR";
		StringBuilder sb = new StringBuilder();
		for(Location l : locs) {
			sb.append("\n" + (l.r+1) + " " + (l.k+1));
		}
		return sb.toString();
	}
	
	private static class State {
		public State(int total, int currR, int currK, List<Location> steps) {
			super();
			this.total = total;
			this.currR = currR;
			this.currK = currK;
			this.steps = steps;
		}
		private int total;
		private int currR, currK;
		private List<Location> steps;
	}
	
	private static State maybeAddState(int r, int k, List<Location> prevList, int prevTotal, int[][] pascal, Queue<State> queue, final int target) {
		Location o = new Location(r, k);
		if(r < 0 || k < 0 || k > r || prevList.contains(o)) return null;
		int newTotal = prevTotal + pascal[r][k];
		if (newTotal > target) return null;
		List<Location> clonedList = new ArrayList<>(prevList.size()+1);
		for(Location l : prevList) clonedList.add(l);
		clonedList.add(new Location(r, k));
		State state = new State(newTotal, r, k, clonedList);
		if (newTotal == target) return state;
		queue.add(state);
		return null;
	}
	
	

	// Is this too large to kinda BFS? Let's find out :)
	// Test data indicates it is :(
	// Let's snatch small points, then revisit.
	private static String getResult(final int target) {
		final int[][] pascal = pregeneratePascal(Math.min(500, target));
		Queue<State> queue = new ArrayDeque<>();
		List<Location> startList = new ArrayList<>();
		startList.add(new Location(0,0));
		if (target == 1) return listToString(startList);
		queue.add(new State(1, 0, 0, startList));
		while(!queue.isEmpty()) {
			State state = queue.poll();
			int r = state.currR;
			int k = state.currK;
			State t = maybeAddState(r-1, k-1, state.steps, state.total, pascal, queue, target);
			if(t != null) return listToString(t.steps);
			t = maybeAddState(r-1, k, state.steps, state.total, pascal, queue, target);
			if(t != null) return listToString(t.steps);
			t = maybeAddState(r, k-1, state.steps, state.total, pascal, queue, target);
			if(t != null) return listToString(t.steps);
			t = maybeAddState(r, k+1, state.steps, state.total, pascal, queue, target);
			if(t != null) return listToString(t.steps);
			t = maybeAddState(r+1, k, state.steps, state.total, pascal, queue, target);
			if(t != null) return listToString(t.steps);
			t = maybeAddState(r+1, k+1, state.steps, state.total, pascal, queue, target);
			if(t != null) return listToString(t.steps);
		}
		return "ERROR";
	}

}
