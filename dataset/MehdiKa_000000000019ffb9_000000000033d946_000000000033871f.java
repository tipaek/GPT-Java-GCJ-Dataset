import java.util.*;
import java.io.*;
public class Solution {

	static void solve(int c, int d, HashMap<Integer, Integer> order, int[][] path) {
		
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(order.entrySet());
		list.sort(Map.Entry.comparingByValue());
		for (Map.Entry<Integer, Integer> entry : list) {
		        int node1 = entry.getKey();
		        int cost1 = entry.getValue();
				for (Map.Entry<Integer, Integer> entry2 : list) {
			        int node2 = entry2.getKey();
			        int cost2 = entry2.getValue();
			        if (node2==node1) break;
			        if (path[node1][node2] > 0 || path[node2][node1]>0) {
			        	path[node1][node2] = cost1 - cost2;
			        	path[node2][node1] = cost1 - cost2;
			        }
		        }
		 }
	}

	public static void main(String[] args) {
		Scanner in;
		try {
			in = new Scanner(new BufferedReader(new FileReader("bin/myinput.txt")));
		} catch (IOException e) {
			// e.printStackTrace();
			 in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));			
		}
		
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int c = in.nextInt();
			int d = in.nextInt();
			int[][] path = new int[c+1][c+1];
			HashMap<Integer, Integer> order = new HashMap<Integer, Integer>();
			order.put(1, 0);
			for(int k=2; k<=c; k++) {
				order.put(k, Math.abs(in.nextInt()));
			}
			int[] a = new int[d];
			int[] b = new int[d];
			for(int k=0; k<d; k++) {
				int c1 = in.nextInt();
				int c2 = in.nextInt();
				path[c1][c2] = 1;
				path[c2][c1] = 1;
				a[k] = c1;
				b[k] = c2;
			}
			solve(c, d, order, path);
			System.out.print("Case #" + i + ": ");
			for(int k=0; k<d; k++) {
				if (path[a[k]][b[k]] > 0)
					System.out.print(path[a[k]][b[k]]);
				else
					System.out.print(1);
				if (k==d-1) {
					System.out.println();
				} else {
					System.out.print(" ");
				}			
			}
			
		}
		in.close();
	}

}
