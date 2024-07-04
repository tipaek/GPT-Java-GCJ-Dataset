import java.util.*;
class Solution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int[][] a=new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					a[i][j]=sc.nextInt();
				}
			}
			int rows=0,cols=0,trace=0;
			for(int i=0;i<n;i++) {
				int[] rhash=new int[n+1];
				int[] chash=new int[n+1];
				trace+=a[i][i];
				for(int j=0;j<n;j++) {
					rhash[a[i][j]]++;
					chash[a[j][i]]++;
				}
				for(int k=1;k<=n;k++) {
					if(rhash[k]>=2) {
						rows++;
						break;
					}
				}
				for(int k=1;k<=n;k++) {
					if(chash[k]>=2) {
						cols++;
						break;
					}
				}
			}
			System.out.println(trace+" "+rows+" "+cols);
		}
		System.exit(0);
	}
}

