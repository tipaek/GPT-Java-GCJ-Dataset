import java.util.*;
import java.io.*;
class Solution {
	public static void natural(int[][] arr, int n, int test) {
		int rows = 0;
		int trace = 0;
		int column = 0;
		boolean rowFlag = true;
		boolean colFlag = true;
		for(int i = 0;i<n;i++) {
			rowFlag = true;
			colFlag = true;
			trace+=arr[i][i];
			HashMap<Integer,Integer> rowMap = new HashMap<Integer,Integer>();
			HashMap<Integer,Integer> colMap = new HashMap<Integer,Integer>();
			for(int j = 0;j<n;j++) {
				if(rowFlag) {
					if(rowMap.containsKey(arr[i][j])) {
						rowFlag = false;
						rows++;
					}
					else {
						rowMap.put(arr[i][j], 1);
					}
				}
				if(colFlag) {
					if(colMap.containsKey(arr[j][i])) {
						colFlag = false;
						column++;
					}
					else {
						colMap.put(arr[j][i], 1);
					}
				}
				if(!rowFlag && !colFlag) break;
			}
		}
		System.out.println("Case #"+test+": "+trace+" "+rows+" "+column);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner (new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for(int i = 1;i<=t;i++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			for(int j = 0;j<n;j++) {
				for(int k = 0;k<n;k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			natural(arr,n,i);
		}
		sc.close();
	}

}
