/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{ static int search(int a[],int ind,int b[],boolean bl[]){
    int ele=b[ind];
    int l=ind+1;
    int h=a.length-1;
    int ans=h+1;
    while(l<=h){
        int m=(l+h)/2;
        if((a[m]>=ele)&&(bl[m]==false)){
            ans=m;
            h=m-1;
        }
        else if(a[m]>=ele){
            int x=0;
            for(int i=m-1;i>=l;i--){
                if(a[i]>=ele&&bl[i]==false){
                    h=m-1;
                    x=1;
                    break;
                }
                else if(a[i]<ele){
                    l=m+1;
                    x=1;
                    break;
                }
                
            }
            if(x==0){
                l=m+1;
            }
        }
        else{
            l=m+1;
        }
    }
    //System.out.println(ans);
    return ans;
}
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int x=0;x<t;x++){
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    int b[]=new int[n];
		    int f[]=new int[n];
		    for(int j=0;j<n;j++){
		        a[j]=sc.nextInt();
		        b[j]=sc.nextInt();
		        f[j]=j;
		    }
		    int ans[]=new int[n];
		    boolean bl[]=new boolean[n];
		  for (int i = 0; i < n; i++) 
        {
            for (int j = i + 1; j < n; j++) 
            {
                if (a[i] > a[j]) 
                {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                    temp = f[i];
                    f[i] = f[j];
                    f[j] = temp;
                }
            }
        }
        int ind=0;
        bl[0]=true;
        while(ind<n){
            bl[ind]=true;
            ans[ind]=1;
            ind=search(a,ind,b,bl);
        }
        int st=0;
        for(int j=0;j<n;j++){
            if(bl[j]==false){
                st=j;
                break;
            }
        }
        if(st!=0){
             while(st<n){
            bl[st]=true;
            ans[st]=-1;
            st=search(a,st,b,bl);
        }
        }
        int d=0;
        String s="";
         for (int i = 0; i < n; i++) 
        {
            for (int j = i + 1; j < n; j++) 
            {
                if (f[i] > f[j]) 
                {  int temp = f[i];
                    f[i] = f[j];
                    f[j] = temp;
                    temp = ans[i];
                    ans[i] = ans[j];
                    ans[j] = temp;
                }
            }
        }
        for(int j=0;j<n;j++){
            if(ans[j]==0){
                d=1;
                break;
            }
            else{
                if(ans[j]==1){
                    s=s+"C";
                }
                else{
                    s=s+"J";
                }
            }
        }
        
        if(d==1){
            System.out.println("Case #"+(x+1)+": IMPOSSIBLE");
        }
        else{
            System.out.println("Case #"+(x+1)+": "+s);
        }
        
        
		}
	}
}
