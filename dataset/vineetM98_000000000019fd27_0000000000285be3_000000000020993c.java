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
			//Trace
			for(int i=0;i<n;i++){
				trace+=a[i][i];
			}
			//Rows
			for(int i=0;i<n;i++) {
				HashSet<Integer> hs=new HashSet<Integer>();
				for(int j=0;j<n;j++) {
					if(hs.contains(a[i][j])){
						rows++;
						break;
					}
					else
						hs.add(a[i][j]);
				}
			}
			//Cols
			for(int i=0;i<n;i++) {
				HashSet<Integer> hs=new HashSet<Integer>();
				for(int j=0;j<n;j++) {
					if(hs.contains(a[j][i])){
						cols++;
						break;
					}
					else
						hs.add(a[j][i]);
				}
			}
			System.out.println(trace+" "+rows+" "+cols);
		}
		//System.exit(0);
	}
}

