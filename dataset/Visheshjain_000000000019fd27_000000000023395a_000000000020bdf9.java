
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
			Integer[][] arr = new Integer[n][3];
			
			for(int i = 0 ; i <  n ;i++) {
				arr[i][0] =sc.nextInt();
				arr[i][1] = sc.nextInt();
				arr[i][2] = i;
			}
		
			
			Arrays.sort(arr ,new com() );
			char[] ans = new char[n];
//			for(int i = 0 ; i <  n ;i++) {
//				System.out.println(		arr[i][0] +" "+
//						arr[i][1] +" "+
//						arr[i][2] );
//					}
				
			int end1 =0;
			int end2 = 0 ;
			boolean ch = true;
			for(int i = 0 ; i < n ; i++) {
				if(end1<=arr[i][0]) {
					end1 = arr[i][1];
					ans[arr[i][2]]='C';
				}else if(end2<=arr[i][0]) {
					end2 = arr[i][1];
					ans[arr[i][2]]='J';
				}
				else {
					 ch = false;
					break;
				}
				
			}
			if(!ch) {
				 System.out.println( "Case #"+k+": "+"IMPOSSIBLE");

			}else {
				 System.out.print( "Case #"+k+": ");

				 for(char c : ans) {
					 System.out.print(c+"");
				 }
				 System.out.println();
			}
		       k++;
		}
	}
	public static class com implements Comparator<Integer[]>{
		public int compare(Integer[] o1  , Integer[] o2) {
			if(o1[0] == o2[0]) {
			//	System.out.println(o2[0] +" "+ o1[0]);
				return o1[1] - o2[1];				
			}else {
			//	System.out.println("Ss");
				return o1[0] - o2[0];
			}
		}

		
	}
}