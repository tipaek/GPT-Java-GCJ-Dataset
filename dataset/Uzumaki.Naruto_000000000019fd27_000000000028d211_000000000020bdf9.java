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
			int[] ans = new int[n];
			Arrays.fill(ans,-1);
			int[] s = new int[n], e= new int[n];
			for(int i=0;i<n;i++){
				s[i]=sc.nextInt();e[i]=sc.nextInt();
			}
			boolean imp=false;
	A:		for(int i=0;i<n;i++){
				for(int j=i+1;j<n;j++){
					if((s[j] >= e[i] || e[j]<=s[i]) && !(s[j]==s[i] && e[j] == e[i])){
						if(ans[i]>-1 && ans[j]>-1)continue;
						if(ans[i]==1 || ans[j]==1){
							ans[i]=1;
							ans[j]=1;
						} else if(ans[i]==2 || ans[j]==2){
							ans[i]=2;
							ans[j]=2;
						} else {
							
						}
					} else {
						if(ans[i]>-1 && ans[j]>-1 && ans[i]==ans[j]){
							sb.append("IMPOSSIBLE");
							imp=true;
							break A;
						}
						if(ans[i]==1){
							ans[j]=2;
						} else if(ans[i]==2){
							ans[j]=1;
						} else{
							if(ans[j] == 1){
								ans[i]=2;
							} else if(ans[j]==2){
								ans[i]=1;
							} else{
								ans[i]=1;
								ans[j]=2;
							}
						}
					}
					// System.out.println(Arrays.toString(ans)+" c:"+v);
				}
			}
			if(!imp)
				for(int t:ans){
					if(t<=1)sb.append('C');
					else sb.append('J');
				}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}