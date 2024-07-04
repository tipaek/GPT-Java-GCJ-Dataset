import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
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
		
		for(int i=0; i<tasks; i++) {
			tasklist.add(new Pair(in.nextInt(), in.nextInt()));
		}
		
		tasklist.sort((p1, p2) -> {
			int cmp = Integer.compare(p1.begin, p2.begin);
			if(cmp == 0) cmp = Integer.compare(p2.end, p1.end);
			
			return cmp;
		});
		
		while(!tasklist.isEmpty()) {
			Pair task = tasklist.pop();
			
			if(c.isEmpty() || !c.peekLast().overlaps(task)) {
				c.add(task);
				str+='C';
			} else if(j.isEmpty() || !j.peekLast().overlaps(task)){
				j.add(task);
				str+='J';
			} else {
				tasklist = new LinkedList<>();
				str="IMPOSSIBLE";
			}
		}
		
		System.out.println("Case #" + n + ": " + str);
	}
	
	static class Pair {
		int begin;
		int end;
		
		//Always assume begin <= pair.begin
		public boolean overlaps(Pair pair) {
			if(end <= pair.begin) return false;
			
			return true;
		}

		public Pair(int begin, int end) {
			this.begin = begin;
			this.end = end;
		}
	}
}
