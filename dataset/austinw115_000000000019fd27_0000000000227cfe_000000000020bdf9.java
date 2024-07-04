import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32768);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		//BufferedReader br = new BufferedReader(new FileReader("solution.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("solution.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] safeStorage = new int[N][2];
			int[][] storage = new int[N][2];
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				int time1 = Integer.parseInt(st.nextToken());
				int time2 = Integer.parseInt(st.nextToken());
				storage[j][0] = time1;
				storage[j][1] = time2;
				safeStorage[j][0] = time1;
				safeStorage[j][1] = time2;
			}
			
			ArrayList<String> al = new ArrayList<String>();
			int[][] s = sortByColumn(storage, 0);
			int[][] sortedSchedule = reSort(s);
			
			String slave = "C";
			boolean impossible = false;
			al.add(slave);
			for (int a = 0; a < N - 1; a++) {
					if (checkIfInterlapping(sortedSchedule[a], sortedSchedule[a+1])) {
						if (checkTriIntersection(sortedSchedule, a , a + 1, N)) {
							impossible = true;
						}
						if (slave == "J") {
							slave = "C";
						}
						else {
							slave = "J";
						}
					}
					al.add(slave);
			}
				
			
			StringBuffer sb = new StringBuffer();
			for (String a : al) {
				sb.append(a);
			}
			String unsortedAnswer = sb.toString();
			
			ArrayList<Character> newAl = new ArrayList<Character>();
			for (int w = 0; w < N; w++) {
				for (int x = 0; x < N; x++) {
					if (safeStorage[w][0] == sortedSchedule[x][0] &&
							safeStorage[w][1] == sortedSchedule[x][1]) {
							newAl.add(unsortedAnswer.charAt(x));
					}
				}
			}
			
			StringBuffer sb2 = new StringBuffer();
			for (char ab : newAl) {
				sb2.append(ab);
			}
			String answer = sb2.toString();
			
			if (impossible) {
				pw.println("Case #" + i + ": " + "IMPOSSIBLE");
			}
			else {
				pw.println("Case #" + i + ": " + answer);
			}
		}
		pw.close();
	}
	
	
	public static boolean checkTriIntersection(int[][] arr, int i, int h, int N) {
		for (int s = 0; s < N; s++) {
			if(arr[s] != arr[i] && arr[s] != arr[h]) {
				if (checkIfInterlapping(arr[s], arr[i]) && checkIfInterlapping(arr[s], arr[h])){
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean checkIfInterlapping(int[] arr1, int[] arr2) {
		if (arr1[0] < arr2[0])
			return arr1[1] > arr2[0];
		return arr2[1] > arr1[0];
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