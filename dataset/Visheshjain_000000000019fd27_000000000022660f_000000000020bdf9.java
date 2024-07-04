
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		long t = sc.nextLong();
		int k = 1;
		while (t-- > 0) {
			int n =sc.nextInt();
			Integer[][] arr = new Integer[n][2];
			for(int i = 0 ; i <  n ;i++) {
				arr[i][0] =sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			
			
			Arrays.sort(arr ,new com() );
			
			String ans ="";
			int end1 =0;
			int end2 = 0 ;
			for(int i = 0 ; i < n ; i++) {
				if(end1<=arr[i][0]) {
					end1 = arr[i][1];
					ans+="C";
				}else if(end2<=arr[i][0]) {
					end2 = arr[i][1];
					ans+="J";
				}
				else {
					ans = "IMPOSSIBLE";
					break;
				}
				
			}
			 System.out.println( "Case #"+k+": "+ans);
		       k++;
		}
	}
	public static class com implements Comparator<Integer[]>{
		public int compare(Integer[] o1  , Integer[] o2) {
			if(o1[0] == o2[0]) {
				return o1[0] - o2[0];				
			}else {
				return o1[0] - o2[0];
			}
		}

		
	}
}