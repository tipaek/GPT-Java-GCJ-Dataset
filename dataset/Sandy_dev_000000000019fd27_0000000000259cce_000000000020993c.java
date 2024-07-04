import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for(int i=1;i<=t;i++) {
			int n = Integer.parseInt(in.readLine());
			int a[][] = new int[n][n];
			for(int j=0;j<n;j++) {
				String[] l = (in.readLine()).split(" ");
				for(int k=0;k<n;k++) {
					a[j][k] = Integer.parseInt(l[k]);
				}
			}
			int sum = 0;
			for(int j=0;j<n;j++) {
				sum+=a[j][j];
			}
			
			int rc=0,cc=0;
			
			for(int j=0;j<n;j++) {
				int[] f = new int[n+1];
				for(int k=0;k<n;k++) {
					int num = a[j][k];
					if(f[num]!=0) {
						rc++;
						break;
					} else
						f[num]++;
						
				}
			}
			
			for(int j=0;j<n;j++) {
				int[] f = new int[n+1];
				for(int k=0;k<n;k++) {
					int num = a[k][j];
					if(f[num]!=0) {
						cc++;
						break;
					} else
						f[num]++;
						
				}
			}
			
			System.out.println("Case #"+i+": "+sum+" "+rc+" "+cc);
		}
	}
}
