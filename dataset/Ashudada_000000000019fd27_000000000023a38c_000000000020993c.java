import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Solution {
	public static int[] RepeatedRowsAndColumns(int[][] arr,int n) {
		int r=0,c=0;
		for(int i=0;i<n;i++) {
			Set<Integer> s=new HashSet<>();
			Set<Integer> s1=new HashSet<>();
			for(int j=0;j<n;j++){
			    s.add(arr[i][j]);
			    s1.add(arr[j][i]);
			}
			if(s.size()!=n) {
				r++;
			}
			if(s1.size()!=n) {
				c++;
			}
		}
		int ans[]= {r,c};
		return ans;
	}
        public static void main(String[] args) {
			Scanner sc;
			sc=new Scanner(System.in);
			int t=sc.nextInt();
			int n=0;
			int ans[][]=new int[t][3]; 
			for(int i=0;i<t;i++) {
				n=sc.nextInt();
				int arr[][]=new int[n][n];
				for(int j=0;j<n;j++) {
					for(int k=0;k<n;k++) {
						arr[j][k]=sc.nextInt();
					}
				}
				int sum=0;
				for(int l=0;l<n;l++) {
					sum+=arr[l][l];
				}
				int[] ret=RepeatedRowsAndColumns(arr, n);
				ans[i][0]=sum;
				ans[i][1]=ret[0];
				ans[i][2]=ret[1];
				
			}
			for(int i=0;i<n;i++) {
				System.out.print("Case #"+(i+1)+": ");
				for(int j=0;j<n;j++) {
				System.out.print(ans[i][j]+" ");
				}
				System.out.println();
			}
			sc.close();
		}
}
