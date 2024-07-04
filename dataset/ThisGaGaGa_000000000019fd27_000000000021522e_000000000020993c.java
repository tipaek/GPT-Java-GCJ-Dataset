import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		String[] s = new String[T];
		for(int i = 0; i<T; i++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for(int j = 0; j<N; j++) {
				for(int x = 0; x<N; x++) {
					arr[j][x] = sc.nextInt();
				}
			}
			int k = trace(arr);
			int r = row(arr);
			int c = column(arr);
			int index = i+1;
			s[i] = ("Case #"+index+": "+k+" "+r+" "+c);
		}
		for(String str:s) {
			System.out.println(str);
		}
	}
	public static int trace(int[][]arr) {
		int sum = 0;
		for(int i = 0; i<arr.length; i++) {
			sum+=arr[i][i];
		}
		return sum;
	}
	public static int row(int[][]arr) {
		int l = arr.length;
		int cnt = 0;
		for(int i = 0; i<arr.length; i++) {
			String str = "";
			for(int j = 0; j<arr.length; j++) {
				if(!str.contains(""+arr[i][j])) str+=arr[i][j];
			}
			if(str.length()!=l) cnt++;
		}
		return cnt;
	}
	public static int column(int[][]arr) {
		int l = arr.length;
		int cnt = 0;
		for(int i = 0; i<arr.length; i++) {
			String str = "";
			for(int j = 0; j<arr.length; j++) {
				if(!str.contains(""+arr[j][i])) str+=arr[j][i];
			}
			if(str.length()!=l) cnt++;
		}
		return cnt;
	}

}
