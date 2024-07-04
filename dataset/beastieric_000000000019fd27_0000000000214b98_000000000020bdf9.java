import java.util.*;

public class Solution {
	//0 means unvisited, 1 means J, -1 means C
	static int[] schedule;
	static boolean worked;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			schedule = new int[n];
			worked = true;
			Pair[] activitiesOrig = new Pair[n];
			Pair[] activities = new Pair[n];
			for(int j = 0; j < n; j++) {
				activitiesOrig[j] = new Pair(sc.nextInt(),sc.nextInt(),j);
				activities[j] = new Pair(activitiesOrig[j].a, activitiesOrig[j].b,j);
			}
			List<List<Integer>> adj = new ArrayList<List<Integer>>();
			for(int j = 0; j < n; j++) {
				adj.add(new ArrayList<Integer>());
			}
			for(int j = 0; j < n; j++) {
				for(int k = j+1; k < n; k++) {
					if(overlap(activities[j], activities[k])) {
						adj.get(j).add(k);
						adj.get(k).add(j);
					}
				}
			}
			for(int j = 0; j < n; j++) {
				if(schedule[j]==0) {
					schedule[j]=-1;
					dfs(adj, j);
				}
			}
			System.out.print("Case #" + (i+1)+": ");
			if(!worked) {
				System.out.println("IMPOSSIBLE");
			}else {
				StringBuilder ans = new StringBuilder();
				for(int a : schedule) {
					if(a == 1) {
						ans.append("J");
					}else {
						ans.append("C");
					}
				}
				System.out.println(ans.toString());
			}
			/*
			Arrays.sort(activities, new Comparator<Pair>() {
				@Override
				public int compare(Pair o1, Pair o2) {
					if(o1.a < o2.a) {
						return -1;
					}else if(o1.a>o2.a) {
						return 1;
					}else {
						return o1.b-o2.b;
					}
				}
			});
			int[] schedule = new int[n];
			schedule
			for(int j = 0; j < n; j++) {
				
			}
			*/
		}
		sc.close();
	}
	
	public static void dfs(List<List<Integer>> adj, int curr) {
		for(int next : adj.get(curr)) {
			if(schedule[next] == schedule[curr]) {
				worked = false;
				return;
			}
			if(schedule[next] == 0) {
				schedule[next] = -schedule[curr];
				dfs(adj, next);
			}
		}
	}
	
	public static boolean overlap(Pair a, Pair b) {
		if(a.a > b.a) {
			return overlap(b, a);
		}
		return a.b > b.a;
	}
	
	public static class Pair{
		int a, b, id;
		
		public Pair(int a, int b, int id) {
			this.a = a;
			this.b = b;
			this.id = id;
		}
		
		public String toString() {
			return a + " " + b;
		}
	}
	
}
