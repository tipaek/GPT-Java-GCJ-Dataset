import java.util.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for(int t=1;t<=test;t++){
			int n = Integer.parseInt(br.readLine());
			int M[][] = new int[n][n];
			for(int i=0;i<n;i++){
				String s[] = br.readLine().split(" ");
				for(int j=0;j<n;j++){
					M[i][j] = Integer.parseInt(s[j]);
				}
			}
			int dsum = 0, row[] = new int[n], col[] = new int[n], csum = 0, rsum=0;
			
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					row[j] = 0;
					col[j] = 0;
				}
				for(int j=0;j<n;j++){
					int irow = M[i][j] - 1;
					if(row[irow]==0){
						row[irow]=1;
					}
					else{
						rsum++;
						break;
					}
				}
				for(int j=0;j<n;j++){
					int icol = M[j][i] - 1;
					if(col[icol]==0){
						col[icol]=1;
					}
					else{
						csum++;
						break;
					}
				}
				dsum += M[i][i];
			}
			
			
			
			System.out.println("Case #"+t+": "+dsum+" "+rsum+" "+csum);
		}
	}
}