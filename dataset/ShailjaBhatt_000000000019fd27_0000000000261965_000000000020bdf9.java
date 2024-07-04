

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int t = Integer.parseInt(br.readLine());
		int t1 = t;
		
		while (t -- > 0) {
//			System.out.println(String.format("%0" + 3 + "d", 0).replace("0", "("));
			int n = Integer.parseInt(br.readLine());
			boolean[] vis = new boolean[n];
			boolean[] assign = new boolean[n];
			ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
			store[] st= new store[n];
			for (int i = 0;i<n;i++) {
				String[] temp = br.readLine().trim().split(" ");
				st[i] = new store(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
			}
//			Arrays.sort(st);
			//formation of graph
			for (int i = 0;i<n;i++) {
				graph.add(new ArrayList<Integer>());
//				graph.get(i) = new ArrayList<Integer>();
			}
			for (int i = 0;i<n;i++) {
				for (int j = 0;j<n;j++) {
					if (i != j) {
						if(st[i].end <= st[j].end && st[j].start < st[i].end) {
							graph.get(i).add(j);
						}
						else if(st[j].end <= st[i].end && st[i].start < st[j].end) {
							graph.get(i).add(j);
						}
					}
					
				}
			}
			boolean flag = false;
//			boolean[] parent = new boolean[n];
			for (int i = 0;i<n;i++) {
				if (flag) {
					break;
				}
//				boolean prev = false;
				if (!vis[i]) {
					Queue<Integer> q = new LinkedList<Integer>();
					q.add(i);
//					vis[i] = true;
//					assign[i] = !parent[i];
					while (!q.isEmpty()) {
						if (flag) {
							break;
						}
						int temp = q.remove();
//						vis[temp] = true;
//						assign[temp] = !parent[temp];
						for (int j = 0;j<graph.get(temp).size();j++) {
							
							if(vis[graph.get(temp).get(j)]) {
								if (assign[graph.get(temp).get(j)] == assign[temp]) {
//									System.out.println("IMPOSSIBLE");
									flag = true;
									break;
								}
							}
							else {
								q.add(graph.get(temp).get(j));
								assign[graph.get(temp).get(j)] = !assign[temp];
								vis[graph.get(temp).get(j)] = true;
							}
						}
					}
				}
				
				
			}
//			System.out.println("fkj");
			String ans = "";
			if (flag) {
				ans = "IMPOSSIBLE";
			}
			else {
				for (int i = 0;i<n;i++) {
					if(assign[i]) {
						ans = ans + "J";
					}
					else {
						ans = ans + "C";
					}
				}
			}
			
			System.out.println("Case #" + (t1-t) + ": "+ans );
		}
    }
}
class store implements Comparable<store>{
	int start;
	int end;
	store(int s,int e){
		start = s;
		end = e;
	}
	@Override
	public int compareTo(store arg0) {
		if (end > arg0.end) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
}