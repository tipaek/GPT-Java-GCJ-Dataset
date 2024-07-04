	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.util.*;
	import java.util.Scanner;
	
	public class Solution  {
		static Scanner sc;
	    // Driver method 
		public static void main(String args[]) 
		{ 
			sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			
			int t = sc.nextInt();
			for (int i = 1; i <= t; i++) {
				int C = sc.nextInt();
				int D = sc.nextInt();
				
				int[] before = new int[C];
				int[] checked = new int[C];
			
				ArrayList<ArrayList<Integer>> neigh = new ArrayList<ArrayList<Integer>>();
				int[][] connections = new int[C][C];
				neigh.add(new ArrayList<Integer>());
				for (int j = 1; j < C; j++) {
					neigh.add(new ArrayList<Integer>());
					before[j] = (-1)*sc.nextInt();
					checked[j] = -1;
				}
				checked[0] = 0;
				before[0] = Integer.MAX_VALUE;
				int[][] direct = new int[D][2];
				for (int j = 0; j < D; j++) {
					int a = sc.nextInt() - 1; int b = sc.nextInt() - 1;
					neigh.get(a).add(b); neigh.get(b).add(a);
					direct[j][0] = a;
					direct[j][1] = b;
				}
				
				int curmin = 1;
				int curtime = 1;
				int numcheck = 1;
				while (numcheck < C) {
					for (int j = 1; j < C; j++) {
						if (before[j] == curmin && checked[j] == -1) {
							for (int k = 0; k < neigh.get(j).size(); k++) {
								int c = checked[neigh.get(j).get(k)];
								if (c != -1) {
									connections[neigh.get(j).get(k)][j] = Math.max(curtime - c, 1);
									connections[j][neigh.get(j).get(k)] = Math.max(curtime - c, 1);
	
								}
							}
							numcheck++;
							checked[j] = curtime;
						} 
						if (j == C- 1) {
							curmin++;
							curtime++;
						}
					}
				}
				System.out.print("Case #" + i + ": ");

				for (int j = 0;j < D; j++) {
					System.out.print(connections[direct[j][0]][direct[j][1]] + " ");
				}
				System.out.println("");
			}
		}
		
	
	}
