
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.*;

public class Solution {
	static String ans = "IMPOSSIBLE";
	static boolean flag = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = scn.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scn.nextInt();
			int[][] arr = new int[n][3];
			for (int j = 0; j < n; j++) {
				int s = scn.nextInt();
				int e = scn.nextInt();
				arr[j][0] = s;
				arr[j][1] = e;
				// arr[j][2]=j;
			}
			// Arrays.sort(arr,new Comparator<int []>(){
			// @Override
			// public int compare(int []a,int []b){
			// if(a[1]>b[1]){
			// return 1;
			// }else if(a[1]<b[1])
			// return -1;
			// return 0;
			// }
			// });
			ans = "IMPOSSIBLE";
			flag = false;
			solve(arr, "C", 0, -1, 1);
			System.out.println("Case #" + (i + 1) + ": " + ans);
		}
	}

	public static void solve(int[][] arr, String str, int c, int j, int k) {
		//System.out.println(str + " " + k);
		if (k > arr.length)
			return;
		if (k == arr.length) {
			ans = str;
			flag = true;
			return;
		}
		if (!flag) {
			int c1 = c, j1 = j;
			while (c1 >= 0) {
				if (str.charAt(c1)=='C'&&arr[k][0] < arr[c1][1] && arr[k][1] > arr[c1][0]) {
					c1 = -2;
					break;
				}
				c1--;
			}
			if (c1 != -2)
				solve(arr, str + "C", k, j, k + 1);
			if(j1==-1) {
				if (!flag)
					solve(arr, str + "J", c, k, k + 1);
			}else {
				//System.out.println(j1+" bbbb");
				while (j1 >= 0) {
					if (str.charAt(j1)=='J'&&arr[k][0] < arr[j1][1] && arr[k][1] > arr[j1][0]) {
						j1 = -2;
						break;
					}
					j1--;
				}
				//System.out.println(j1);
				if (!flag && j1 != -2) {
					
					solve(arr, str + "J", c, k, k + 1);
				}
					
			}
			
		}

	}
}
