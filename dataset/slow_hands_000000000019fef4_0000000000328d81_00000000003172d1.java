

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
	static long help(long n)  
	{  
	    // if divisible by 2  
	    if (n % 2 == 0)  
	        return 2;  
	  
	    // iterate from 3 to sqrt(n)  
	    for (int i = 3; i * i <= n; i += 2) {  
	        if (n % i == 0)  
	            return i;  
	    }  
	  
	    return n;  
	}  
	public static long solve(int n,int d,long[] arr) {
		long ans=Long.MAX_VALUE;
		TreeMap<Long,Integer> jj=new TreeMap<>();
		for(Long hj:arr) {
			if(hj==1 || hj%2==0) ans=2;
			jj.put(hj,jj.getOrDefault(hj, 0)+1);
			if(jj.get(hj)>=d) return 0;
		}
		if(d==2) {
			return 1;
		}
		if(d==3) {
			for(Long kk:jj.keySet()) {
				if(kk==1) continue;
				long fg=kk*2;
				if(jj.containsKey(fg)) {
					return 1;
				}
				if(jj.get(kk)>=3) return 0;
				if(jj.containsKey(kk/2) && kk%2==0)
					return 1;
				
			}
			return ans;
		}
		
		
		return 2;
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
		long ans=solve(n,d,arr);
		
		System.out.println("Case #"+(c)+":"+" "+ans);
		
		c++;
		}

	} 
} 
