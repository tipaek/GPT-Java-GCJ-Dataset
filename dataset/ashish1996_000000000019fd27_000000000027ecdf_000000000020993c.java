

import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String...ss) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		int k=1;
		while(testCases--!=0){
			int n=s.nextInt();
			int[][] ar = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					ar[i][j]=s.nextInt();
				}	
			}
			int trace = 0, dr=0,dc=0;
			for(int i=0;i<n;i++) {
			trace = trace + ar[i][i];
			}
			for(int i=0;i<n;i++) {
				HashSet<Integer> h = new HashSet<Integer>();
				for(int j=0;j<n;j++) {
					//System.out.print(ar[i][j]+"**");
					if(!h.add(ar[i][j])) {
						dr++;
						break;
					}
				}
				//System.out.println(h.toString());
			}
			
			for(int i=0;i<n;i++) {
				HashSet<Integer> h = new HashSet<Integer>();
				for(int j=0;j<n;j++) {
					//System.out.print(ar[i][j]+"**");
					if(!h.add(ar[j][i])) {
						dc++;
						break;
					}
				}
				//System.out.println(h.toString());
			}
			///System.out.println();
			System.out.print("Case #"+k+++": "+ trace+" "+dr+" "+dc);
		}
	}
}
