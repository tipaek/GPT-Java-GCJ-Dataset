//package round22020;
/*
ID: urd00m
LANG: JAVA
TASK: Security
 */
import java.io.*;
import java.util.*;

public class Solution {
	static int t; 
	static int c, d; 
	static int[] weight; 
	static int[][] edges; 
	static ArrayList<Integer>[] edgeList; 
	public static void main(String args[]) throws IOException { 
		//input 
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input; 
		t = Integer.parseInt(f.readLine()); 
		for(int cn = 1; cn < t+1; cn++) {
			input = new StringTokenizer(f.readLine()); 
			c = Integer.parseInt(input.nextToken()); 
			d = Integer.parseInt(input.nextToken()); 
			//c-1 
			weight = new int[c+1]; // 0 is null
			weight[1] = 0; 
			input = new StringTokenizer(f.readLine()); 
			for(int i = 2; i < c+1; i++) {
				weight[i] = Integer.parseInt(input.nextToken())*-1; 
			}
			edges = new int[d][3]; 
			edgeList = new ArrayList[c+1];
			Queue<Integer> next = new LinkedList<Integer>(); 
			for(int i = 0; i < c+1; i++) edgeList[i] = new ArrayList<Integer>(); 
			for(int i = 0; i < d; i++) {
				input = new StringTokenizer(f.readLine()); 
				int a = Integer.parseInt(input.nextToken()); int b = Integer.parseInt(input.nextToken()); 
				edges[i][0] = a; 
				edges[i][1] = b; 
				edgeList[a].add(i); 
				edgeList[b].add(i); 
				if(a == 1 || b == 1) next.add(i); 
			}
			
			boolean[] edgeUsed = new boolean[d];
			//bfs 
			int[] sum = new int[c+1]; 
			Arrays.fill(sum, -1);
			sum[1] = 0; 
			while(next.isEmpty() == false) {
				int cur = next.remove();
				if(edgeUsed[cur] == true) continue; 
				edgeUsed[cur] = true; 
				int a = edges[cur][0]; 
				int b = edges[cur][1]; 
				if(sum[a] == -1) {
					int ans = weight[a]-sum[b]; 
					if(ans < 0) {
						ans = 1000000; 
					}
					else {
						sum[a] = weight[a];
						for(int item : edgeList[a]) {
							if(edgeUsed[item] == false)
								next.add(item); 
						}
					}
					edges[cur][2] = ans; 
				}
				else if(sum[b] == -1) {
					int ans = weight[b]-sum[a]; 
					if(ans < 0) {
						ans = 100000000; 
					}
					else {
						sum[b] = weight[b];
						for(int item : edgeList[b]) {
							if(edgeUsed[item] == false)
								next.add(item); 
						}
					}
					edges[cur][2] = ans; 
				}
				else {
					edges[cur][2] = Math.max(weight[a], weight[b]) - Math.min(sum[a], sum[b]); 
				}
 			}
			
			//output
			System.out.print("Case #" + cn + ":");
			for(int[] item : edges) {
				if(item[2] <= 0) item[2] = 1000000; 
				System.out.print(" " + item[2]); 
			}
			System.out.println(); 
		}
	}
}
