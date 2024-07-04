import java.util.*;

public class Solution {
	
	public static int n;
	
	public static int[][] connected;
	public static int e;
	public static int[] res;
	public static int[] data;
	
	public static void main(String[] args) {
	
		Scanner stdin = new Scanner(System.in);
		int nC = stdin.nextInt();
		
		for (int loop=1; loop<=nC; loop++) {
		
			n = stdin.nextInt();
			e = stdin.nextInt();
			data = new int[n];
			for (int i=1; i<n; i++)
				data[i] = stdin.nextInt();
			connected = new int[n][n];
			for (int i=0; i<n; i++) Arrays.fill(connected[i], -1);
			
			res = new int[e];
			Arrays.fill(res, 500000);
			
			for (int i=0; i<e; i++) {
				int u = stdin.nextInt()-1;
				int v = stdin.nextInt()-1;
				connected[u][v] = i;
				connected[v][u] = i;
			}
			
			// order of the nodes.
			ArrayList[] order = new ArrayList[n];
			for (int i=0; i<n; i++) order[i] = new ArrayList<Integer>();
			order[0].add(0);
			for (int i=1; i<n; i++) {
				order[-data[i]].add(i);
			}
			//for (int i=0; i<n; i++)
				//System.out.println(i+": "+order[i]);
			
			int[] dist = new int[n];
			Arrays.fill(dist, 1000000000);
			dist[0] = 0;
			int prevd = 0;
			boolean[] visited = new boolean[n];
			visited[0] = true;
			ArrayList<Integer> prevList = new ArrayList<Integer>();
			prevList.add(0);
			
			for (int i=1; i<n; i++) {
				ArrayList<Integer> nextList = (ArrayList<Integer>)order[i];
				//if (nextList.size() == 0) break;
				//System.out.println("connecting "+next);
				for (Integer next: nextList) {
					
					for (Integer prev: prevList) {
						//System.out.println("looking at edge "+prev+" to "+next);
						if (connected[prev][next] != -1) {
							//System.out.println("in");
							//System.out.println("connecting with edge "+connected[order[j]][order[i]]+" from "+order[j]+" to "+order[i]);
							int add = prevd+(i+1)-dist[prev];
							res[connected[prev][next]] = add;
							dist[next] = prevd+(i+1);
							break;
						}
					}
				}
				for (Integer next: nextList) prevList.add(next);
				prevd+= (i+1);
			}
			
			
			System.out.print("Case #"+loop+":");
			for (int i=0; i<e; i++)
				System.out.print(" "+res[i]);
			System.out.println();
		}
	}
}
