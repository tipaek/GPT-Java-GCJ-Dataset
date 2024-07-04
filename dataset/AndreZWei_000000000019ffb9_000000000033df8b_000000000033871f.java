import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	      int n = in.nextInt();
	      int e = in.nextInt();
	      int[] arr = new int[n-1];
	      for (int cnt = 0; cnt < n-1; cnt++) {
	      	arr[cnt] = in.nextInt();
	      }
	      int[][] edges = new int[e][2];
	      for (int cnt = 0; cnt < e; cnt++) {
	      	edges[cnt][0] = in.nextInt()-1;
	      	edges[cnt][1] = in.nextInt()-1;
	      }
	      System.out.println("Case #" + i + ": " + solve(n, arr, edges));
	    }
  	}

  	public static String solve(int n, int[] arr, int[][] edges){
  		/* for (int i = 0; i < arr.length; i++) {
  			System.out.print(arr[i] + " ");
  		}
  		System.out.println();
  		for (int i = 0; i < edges.length; i++) {
  			System.out.print(edges[i][0] + " " + edges[i][1] + " ");
  		} 
  		System.out.println(); */
  		Map<Integer, Set<Integer>> graph = new HashMap<>();
  		Map<String, Integer> edgeMap = new HashMap<>();
  		for (int i = 0; i < edges.length; i++) {
  			int[] e = edges[i];
  			if (!graph.containsKey(e[0])) {
  				graph.put(e[0], new HashSet<Integer>());
  			}
  			if (!graph.containsKey(e[1])) {
  				graph.put(e[1], new HashSet<Integer>());
  			}
  			graph.get(e[0]).add(e[1]);
  			graph.get(e[1]).add(e[0]);
  			edgeMap.put(e[0]+" "+e[1], 1000000);
  		}

  		Queue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
  			public int compare(int[] a, int[] b) {
  				return a[1]-b[1];
  			}
  		});

  		Map<Integer, Integer> dist = new HashMap<>();
  		// Map<Integer, Integer> rank = new HashMap<>();
  		for (int i = 0; i < n-1; i++) {
  			if (arr[i] < 0) {
  				dist.put(i+1, -arr[i]);
  			}
  		}
  		
  		Map<Integer, Integer> parent = new HashMap<>();
  		boolean[] visited = new boolean[n];
		dist.put(0, 0);
  		pq.offer(new int[]{0,0});
  		visited[0] = true;
  		while (!pq.isEmpty()) {
  			int s = pq.size();
  			for (int i = 0; i < s; i++) {
  				int node = pq.poll()[0];
  				for (int nei: graph.get(node)) {
  					if (!visited[nei]) {
  						visited[nei] = true;
  						String key = node+" "+nei;
  						if (edgeMap.containsKey(key)) {
  							edgeMap.put(key, dist.get(nei)-dist.get(node));
  						} else {
  							key = nei+" "+node;
  							edgeMap.put(key, dist.get(nei)-dist.get(node));
  						}
  						pq.offer(new int[]{nei, dist.get(nei)});
  					}
  				}

  			}
  		} 

  		StringBuilder sb = new StringBuilder();
  		for (int i = 0; i < edges.length; i++) {
  			int[] e = edges[i];
  			sb.append(edgeMap.get(e[0]+" "+e[1]));
  			if (i!=edges.length-1) sb.append(" ");
  		}
  		return sb.toString();
  	}
}
