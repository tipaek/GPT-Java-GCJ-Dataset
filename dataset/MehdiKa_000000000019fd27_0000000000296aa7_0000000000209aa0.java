import java.util.*;
import java.io.*;
public class Solution {
	static boolean debug = false;
	static Set<Integer> set = new HashSet<Integer>();
	static int l = 0;
	static List<Set<Integer>> colSetList = new ArrayList<Set<Integer>>();
	static List<Set<Integer>> rowSetList = new ArrayList<Set<Integer>>();
	
	static boolean fill(int[][] arr, int row, int col, int trace) {
		int n = arr.length;
		if (row < n) {
			Set<Integer> rowSet = rowSetList.get(row);
			Set<Integer> colSet = colSetList.get(col);
			Set<Integer> intersection = new HashSet<Integer>(rowSet);
			intersection.retainAll(colSet);
					
			for (Integer k : intersection) {
				arr[row][col] = k;
				rowSet.remove(k);
				colSet.remove(k);
				int newCol = col+1;
				int newRow = row;
				if (newCol>=n) {
					newRow++;
					newCol = 0;
				}
				if (fill(arr, newRow, newCol, trace))
					return true;
				rowSet.add(k);
				colSet.add(k);
			}
			arr[row][col] = 0;
		} else {
			int sum = 0;
			for(int i=0; i<n; i++) {
				sum += arr[i][i];
			}
			if (sum == trace) {
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						System.out.print(arr[i][j]);
						if (j<n-1) {
							System.out.print(" ");
						}
					}
					System.out.println("");
				}
				return true;
			}
		}
		return false;
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
		for (int cnt=1; cnt<=t; cnt++) {
			int n = in.nextInt();
			int trace = in.nextInt();
			
			int[][] arr = new int[n][n];
			for(int i=0; i<n; i++) {
				Set<Integer> rowSet = new HashSet<Integer>();
				for (int j=1; j<=n; j++)
					rowSet.add(j);
				rowSetList.add(rowSet);
	
				Set<Integer> colSet = new HashSet<Integer>();
				for (int j=1; j<=n; j++)
					colSet.add(j);
				colSetList.add(colSet);
			}
			if ((n==3) && ((trace == 5) || (trace == 7))) {
				System.out.println("Case #" + cnt + ": IMPOSSIBLE");
			} else if ((trace<n) || (trace == n+1) || (trace == n*n-1)) {
				System.out.println("Case #" + cnt + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + cnt + ": POSSIBLE");
				fill(arr, 0, 0, trace);
			}	
		}
		in.close();
	}

}
