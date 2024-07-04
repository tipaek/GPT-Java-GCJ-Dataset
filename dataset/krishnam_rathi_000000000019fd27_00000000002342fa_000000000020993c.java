import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int T=1;T<=t;T++){
			int n=sc.nextInt();
			int[][] a=new int[n][n];
			int[] r=new int[n+1];
			int[] c=new int[n+1];
			int[] ar=new int[n];
			int[] ac=new int[n];
			int rows=0, cols=0, trace=0;
			for(int i=0;i<n;i++){
			    for(int j=0;j<n;j++) {
			        a[i][j]=sc.nextInt();
			        if(i==j) trace+=a[i][j];
			    }
			}
			for(int i=0;i<n;i++){
			    for(int j=0;j<n;j++){
			        if(r[a[i][j]]==1){
			            ar[i]++;
			        }else
			            r[a[i][j]]=1;
			        
			        if(c[a[j][i]]==1){
			            ac[i]++;
			        }else 
			            c[a[j][i]]=1; 
			    }
			    for(int j=0;j<=n;j++){
			        r[j]=0;
			        c[j]=0;
			    }
			}
			for(int i=0;i<n;i++){
			    if(ar[i]>0) rows++;
			    if(ac[i]>0) cols++;
			}
			System.out.println("Case #"+T+": "+ trace+" "+rows+" "+cols);
			
		}
	}
}
