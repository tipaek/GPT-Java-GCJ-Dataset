import java.util.Scanner;
import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) {

	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int Q = in.nextInt();
		for(int test = 1; test <= Q; test ++){
			System.out.printf("Case #%d: ", test);
			
			solve(in);
			
			System.out.println();
		}
	}
	
	public static void solve(Scanner in) {
		
		int n = in.nextInt();
		Interval[] tasks = new Interval[n];
		ArrayList<Integer>[] edges = new ArrayList[n+1];
		
		for(int i = 0; i < n; i ++) {
			tasks[i] = new Interval(in.nextInt(), in.nextInt());
			edges[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < n-1; i ++)
			for(int j = i+1; j < n ; j++)
				if(tasks[i].overlap(tasks[j])) {
					edges[i].add(j);
					edges[j].add(i);
				}
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int[] visited = new int[n];
		
		
		for(int i = 0 ; i < n; i ++)
			if(visited[i] == 0) {
				queue.add(i);
				visited[i] = 1;
				
				while(!queue.isEmpty()) {
					int id = queue.pop();
					for(int node : edges[id]) {
						if(visited[node] == 0) {
							visited[node] = visited[id] == 1 ? 2 : 1;
							queue.add(node);
						}
						else if(visited[node] == visited[id]) {
							System.out.print("IMPOSSIBLE");
							return;
						}
					}
				}
			}
		
		for(int i = 0; i < n; i ++)
			System.out.print( visited[i] == 1 ? 'C' : 'J');
		
	}

}

class Interval{
	public int start;
	public int end;
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public boolean overlap(Interval other) {
		
		if(!(this.start >= other.end || other.start >= this.end)) 
			return true;
		return false;
	}
}
