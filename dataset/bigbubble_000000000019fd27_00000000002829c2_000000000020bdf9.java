import java.io.*;
import java.util.*;

class Solution {
	static Scanner sc;

	public static void main(String[] args) throws IOException{
		sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//sc = new Scanner(new BufferedReader(new InputStreamReader(ves.txt)));
		
		
		int t = sc.nextInt(); 
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int[][] times = new int[n][4];
			
			for (int j = 0; j < n; j++) {
				times[j][0] = sc.nextInt();
				times[j][1] = sc.nextInt();
				times[j][2] = j;
				times[j][3] = 0;
			}
			//sort by start
			java.util.Arrays.sort(times, new java.util.Comparator<int[]>() {
			    public int compare(int[] a, int[] b) {
			        return Integer.compare(a[0], b[0]);
			    }
			});
			
			int clast = 0;
			int jlast = 0;
			String toret = "";
			for (int j = 0; j < n; j++) {
				if (clast <= times[j][0]) {
					times[j][3] = 0;
					clast = times[j][1];
				} else if (jlast <= times[j][0]) {
					times[j][3] = 1;
					jlast = times[j][1];
				} else {
					toret = "IMPOSSIBLE";
					break;
				}
			}
			
			java.util.Arrays.sort(times, new java.util.Comparator<int[]>() {
			    public int compare(int[] a, int[] b) {
			        return Integer.compare(a[2], b[2]);
			    }
			});
			if (toret.equals("IMPOSSIBLE")) {
				
			} else {
				for (int j = 0; j < n; j++) {
					if (times[j][3] == 0) {
						toret = toret + "C";
					} else {
						toret = toret + "J";
					}
				}
			}
			
			
			
			System.out.println("Case #" + i + ": " + toret);
			
			
		}

	}
}
