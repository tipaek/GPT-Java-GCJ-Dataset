import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
public class Solution3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32768);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] storage = new int[N][2];
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				int time1 = Integer.parseInt(st.nextToken());
				int time2 = Integer.parseInt(st.nextToken());
				storage[j][0] = time1;
				storage[j][1] = time2;			
			}
			ArrayList<String> al = new ArrayList<String>();
			int[][] s = sortByColumn(storage, 0);
			int[][] sortedSchedule = reSort(s);
			
			String slave = "J";
			int intersections = 0;
			for (int a = 0; a < N; a++) {
				for (int b = 1; b < N - 1; b++) {
					al.add(slave);
					if (checkIfInterlapping(sortedSchedule[a], sortedSchedule[b])) {
						slave = "C";
						intersections++;
					}
				}
			}
			
			if (intersections == sortedSchedule.length) {
				pw.println("Case #" + i + ": " + "IMPOSSIBLE");
			}
			else {
				StringBuffer sb = new StringBuffer();
				for (String a : al) {
					sb.append(a);
				}
				String output = sb.toString();
				pw.println("Case #" + i + ": " + output);
			}
		}
		pw.close();
	}
	
	public static boolean checkIfInterlapping(int[] arr1, int[] arr2) {
		return arr1[1] > arr2[0];
	}

	
		public static int[][] sortByColumn(int arr[][], int col) 	{ 
			Arrays.sort(arr, new Comparator<int[]>() { 
			@Override			
			public int compare(final int[] entry1, final int[] entry2) { 
				if (entry1[col] > entry2[col]) 
					return 1; 
				else
					return -1; 
			} 
			}); 
			return arr;
		}
		
		public static int[][] reSort(int arr[][]) {
			for (int i = 1; i < arr.length; i++) {
				if (arr[i][0] == arr[i-1][0]) {
					if (arr[i-1][1] > arr[i][1]) {
						int temp = arr[i][1];
						arr[i][1] = arr[i-1][1];
						arr[i-1][1] = temp;
					}
				}
			}
			return arr;
		}
}