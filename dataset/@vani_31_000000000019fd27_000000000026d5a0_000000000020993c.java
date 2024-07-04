import java.util.Scanner;
import java.lang.*;
public class Solution {
	public static void main(String[] args) {
		Scanner ss=new Scanner(System.in);
		int t=ss.nextInt();
		int tt=0;
		while(tt<t) {
			int n=ss.nextInt();
			int a[][]=new int[n+1][n+1];
			int sum=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					a[i][j]=ss.nextInt();
					if(i==j)
						sum=sum+a[i][j];
				}
			} int r=0;
			for(int i=0;i<n;i++) {
				int k[]=new int[n+1];
				for(int j=0;j<n;j++) {
					int kk=a[i][j];
					if(k[kk]==0)
					{
						k[kk]=1;
					}
					else { r++;
					break;
					}
				}
			}
			int c=0;
			for(int i=0;i<n;i++) {
				int k[]=new int[n+1];
				for(int j=0;j<n;j++) {
					int kk=a[j][i];
					if(k[kk]==0)
					{
						k[kk]=1;
					}
					else { c++;
					break;
					}
				}
			}
			System.out.println("Case #"+(tt+1)+": "+sum+" "+r+" "+c);
			tt++;
		}
	}
}