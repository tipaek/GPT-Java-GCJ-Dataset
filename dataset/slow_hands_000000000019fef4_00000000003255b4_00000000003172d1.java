

import java.util.*;
import java.io.*;


class pair1{
	int x ;int y;
	public pair1(int a,int b){
		this.x=a;
		this.y=b;
	}}
//5
//4 4 SSSS
//3 0 SNSS
//2 10 NSNNSN
//0 1 S
//2 7 SSSSSSSS
//
//  
//Case #1: 4
//Case #2: IMPOSSIBLE
//Case #3: IMPOSSIBLE
//Case #4: 1
//Case #5: 5
public class Solution { 
	public static int solve(int n,int d,long[] arr) {
		int ans=0;
		TreeMap<Long,Integer> jj=new TreeMap<>();
		for(Long hj:arr) {
			jj.put(hj,jj.getOrDefault(hj, 0)+1);
			if(jj.get(hj)>=d) return 0;
		}
		if(d==2) {
			return 1;
		}
		if(d==3) {
			for(Long kk:jj.keySet()) {
				long fg=kk*2;
				if(jj.containsKey(fg)) {
					return 1;
				}
				
			}
			return 2;
		}
		
		
		return 0;
	}
	public static void main(String args[])throws IOException { 
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		int c=1;
		while(t-->0) {
			
		int n=s.nextInt();
		int d=s.nextInt();
		long[] arr=new long[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=s.nextLong();
		}
		int ans=solve(n,d,arr);
		
		System.out.println("Case #"+(c)+":"+" "+ans);
		
		c++;
		}

	} 
} 
