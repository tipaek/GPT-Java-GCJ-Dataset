/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		StringBuilder sb=new StringBuilder();
		for(int v=1;v<=x;v++){
			sb.append("Case #"+v+": ");
			int n = sc.nextInt();
			int[][] dp = new int[2000][n];
			for(int i=0;i<2000;i++)Arrays.fill(dp[i],-1);
			char[] ans = new char[n];
			int[] a=new int[2000];
		A:	for(int i=0;i<n;i++){
				int s=sc.nextInt(),e=sc.nextInt()-1;
				int res=-1;
				for(int c=s;c<=e;c++){
					res = Math.max(res,dp[c][i]);
				}
				// System.out.println(res+" res"+" v:"+v);
				if(res==-1)
					ans[i]='C';
				else{
					if(ans[res]=='J')
						ans[i]='C';
					else 
						ans[i]='J';
				}
    			// System.out.println(s+" "+e+" v:"+v);
				for(int c=0;c<2000;c++){
					if(c>=s&&c<=e){
						a[c]++;
						dp[c][i]=i;
						// dp[c][i+1]=i;
					}
					if(i+1<n)
						dp[c][i+1]=dp[c][i];
				}
										
			}
			boolean imp = false;
			for(int i=0;i<2000;i++){
				if(a[i]>2){
										// System.out.println(i+" c");

					imp = true;
					break;
				}
			}
			if(imp)sb.append("IMPOSSIBLE");
			else for(char c:ans)sb.append(c);
			sb.append('\n');
		}
		System.out.println(sb);
	}
}