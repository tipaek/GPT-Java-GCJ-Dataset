import java.io.*;
import java.util.*;

class solution {
	public static void main(String [] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int i=1;i<=t;i++) {
			st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int [][] ls = new int [n][n];

			for(int j=0;j<n;j++) {
				st = new StringTokenizer(f.readLine());
				for(int k=0;k<n;k++)
					{
					    ls[j][k]=Integer.parseInt(st.nextToken());	
					}
			}
			int trace=0, r=0, c=0;
			for(int j=0;j<n;j++) trace=trace+ls[j][j];
			
			for(int j=0;j<n;j++) {
				int [] row = new int [n];
				for(int k=0;k<n;k++) {
					row[ls[j][k]-1]++;
				}
				for(int k=0;k<n;k++) if (row[k]!=1) {r++;break;}
			}
			
			for(int j=0;j<n;j++) {
				int [] col = new int [n];
				for(int k=0;k<n;k++) {
					col[ls[k][j]-1]++;
				}
				for(int k=0;k<n;k++) if (col[k]!=1) {c++;break;}
			}
			
			System.out.println("Case #"+i+": "+trace+" "+r+" "+c);
		}
	}
}