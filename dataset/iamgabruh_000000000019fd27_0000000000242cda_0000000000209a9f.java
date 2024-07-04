/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
     static int countset(int x)
{
    x ^= x>>16;
    x ^= x>>8;
    x ^= x>>4;
    x ^= x>>2;
    x ^= x>>1;

    return (x & 1);
}
     static int findmax(pair arr[],int n) {
    	 int ind=arr[0].val;
    	 int ii=0;
    	 for(int i=1;i<n;i++) {
    		 if(arr[i].val>ind) {
    			 ind=arr[i].val;
    			 ii=i;
    		 }
    	 }
    	 return ii;
     }
     static class pair{
    	 int val,o,c;
    	 pair(int a,int b,int c){
    		 val=a;
    		 o=b;
    		 c=c;
    	 }
     }
     static String ao(int tot) {
    	 String a="";
    	 for(int i=0;i<tot;i++) {
    		 a+="(";
    	 }
    	 return a;
     }
     static String ac(int tot) {
    	 String a="";
    	 for(int i=0;i<tot;i++) {
    		 a+=")";
    	 }
    	 return a;
     }
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		int test=1;
		while(t-->0)
		{
			String dig=br.readLine().trim();
			int n=dig.length();
			pair arr[]=new pair[n];
		    
		    for(int i=0;i<n;i++)
            {
		    	arr[i]=new pair(dig.charAt(i)-'0',0,0);
            }
		    
		    int max=findmax(arr,n);
		    arr[max].o=arr[max].val;
		    arr[max].c=arr[max].val;
		    for(int j=max-1;j>=0;j--) {
		    	int constribute=arr[j+1].o;
		    	int need=arr[j].val;
		    	if(constribute>=need) {
		    		arr[j+1].o=constribute-need;
		    		arr[j].o=need;
		    	}
		    	else{
		    		arr[j+1].o=0;
		    		arr[j].c=need-constribute;
		    		arr[j].o=need;
		    		
		    	}
		    }
		    for(int j=max+1;j<n;j++) {
		    	int constribute=arr[j-1].c;
		    	int need=arr[j].val;
		    	if(constribute>=need) {
		    		arr[j-1].c=constribute-need;
		    		arr[j].c=need;
		    	}
		    	else{
		    		arr[j-1].c=0;
		    		arr[j].o=need-constribute;
		    		arr[j].c=need;
		    		
		    	}
		    }
		    String ans="";
		    for(int i=0;i<n;i++) {
		    	ans+=ao(arr[i].o)+arr[i].val+ac(arr[i].c);
		    }
		    System.out.println("Case #"+test+++": "+ans);
        }
	}
}
