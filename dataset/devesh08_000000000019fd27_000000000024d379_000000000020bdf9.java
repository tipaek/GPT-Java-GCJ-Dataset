import java.util.*;
import java.io.*;
public class Solution 
{ 
	public static void main(String[] args)throws IOException
	{ 
		Scanner in = new Scanner(System.in); 
		int t = in.nextInt(),i,j; 
		StringBuilder sb = new StringBuilder(); 
		start:for(int tt = 1; tt <= t; tt++) { 
			int n=in.nextInt();
			int a[][]=new int[n][2];
			int dp[]=new int[1441];
			for(i=0;i<n;i++) {
				a[i][0]=in.nextInt();
				a[i][1]=in.nextInt();
				dp[a[i][0]]++;
				dp[a[i][1]]--;
			}
			for(i=1;i<1441;i++)
				dp[i]+=dp[i-1];
			for(i=0;i<1441;i++) {
				if(dp[i]>2) {
					sb.append("Case #"+tt+": "+"IMPOSSIBLE\n");
					continue start;
				}
			}
			ArrayList<Integer> x[]=new ArrayList[2]; 
			for(i=0;i<2;i++)
				x[i]=new ArrayList<>(); 
			String s="";
			outer:for(i=0;i<n;i++) { 
				int l=a[i][0],r=a[i][1],k=0;
				for(j=0;j<x[0].size();j++){ 
					if(r>x[0].get(j) && l<x[1].get(j)) 
					k=-1; 
				} 
				if(k==0) { 
					x[0].add(l); 
					x[1].add(r); 
					s+="C"; 
					continue outer; 
				}  
				s+="J";
			} 
			sb.append("Case #"+ tt +": "+s+"\n"); 
		} 
	System.out.print(sb); 
	} 
}
