import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	public static void main(String[] args) {		
		int cases = in.nextInt();
		for(int i=0; i<cases; i++) solveCase(i+1);
		
	}
	private static void solveCase(int n) {
		LinkedList<Pair> tasklist = new LinkedList<>();
		LinkedList<Pair> c = new LinkedList<>();
		LinkedList<Pair> j = new LinkedList<>();
		
		String str = "";
		int tasks = in.nextInt();
		
		Map<Integer, Character> map = new HashMap<>();
		for(int i=0; i<tasks; i++) {
			tasklist.add(new Pair(i, in.nextInt(), in.nextInt()));
		}
		
		tasklist.sort((p1, p2) -> {
			int cmp = Integer.compare(p1.begin, p2.begin);
			if(cmp == 0) cmp = Integer.compare(p2.end, p1.end);
			
			return cmp;
		});
		
		boolean impossible = false;
		while(!tasklist.isEmpty()) {
			Pair task = tasklist.pop();
			
			if(c.isEmpty() || !c.peekLast().overlaps(task)) {
				c.add(task);
				map.put(task.idx, 'C');
			} else if(j.isEmpty() || !j.peekLast().overlaps(task)){
				j.add(task);
				map.put(task.idx, 'J');
			} else {
				tasklist = new LinkedList<>();
				impossible = true;
			}
		}
		
		if(impossible) str = "IMPOSSIBLE";
		else {
			for(int i=0; i<tasks; i++) {
				str += map.get(i);
			}
		}
		System.out.println("Case #" + n + ": " + str);
	}
	
	static class Pair {
		int begin;
		int end;
		int idx;
		
		//Always assume begin <= pair.begin
		public boolean overlaps(Pair pair) {
			if(end <= pair.begin) return false;
			
			return true;
		}

		public Pair(int idx, int begin, int end) {
			this.idx = idx;
			this.begin = begin;
			this.end = end;
		}
	}
}
