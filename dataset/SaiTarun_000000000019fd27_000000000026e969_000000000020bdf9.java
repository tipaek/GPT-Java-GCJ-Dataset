import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int totalTestCases=in.nextInt();
		int count=0;
		while(count<totalTestCases) {
			count++;
			int N=in.nextInt();
			int[][] activities=new int[N][2];
			for(int i=0; i<N; i++) {
				int start=in.nextInt();
				int end=in.nextInt();
				activities[i]=new int[] {start, end};
			}
			String output=helper(activities);
			System.out.println("Case #"+count+": "+output);
		}
	}
	
	public static String helper(int[][] arrays) {
		int jEnd=Integer.MIN_VALUE, cEnd=Integer.MIN_VALUE;
		
		Arrays.sort(arrays, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if(a[0]>b[0]) return 1;
				else if(a[0]==b[0]) return a[1]-b[1];
				return -1;
			}
		});
		
		StringBuilder sb=new StringBuilder();
		for(int[] arr: arrays) {
			if(jEnd<=arr[0]) {
				sb.append('J');
				jEnd=arr[1];
			}
			else if(cEnd<=arr[0]) {
				sb.append('C');
				cEnd=arr[1];
			}
			else return "IMPOSSIBLE";
		}
		
		return sb.toString();
	}
}