/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++){
		    int n=sc.nextInt();
		    int a[][]=new int[n][n];
		    for(int j=0;j<n;j++){
		        for(int k=0;k<n;k++){
		            a[j][k]=sc.nextInt();
		        }
		    }
		    int tr=0;
		    for(int k=0;k<n;k++){
		        tr=tr+a[k][k];
		    }
		    int r=0;
		    int c1=0;
		    for(int k=0;k<n;k++){
		        int x=0;
		        int c[]=new int[n];
		        for(int j=0;j<n;j++){
		            c[a[j][k]-1]++;
		        }
		         for(int l=0;l<n;l++){
		            if(c[l]>1){
		                x++;
		                break;
		            }
		        }
		        if(x==1){
		            c1++;
		        }
		    }
		    for(int k=0;k<n;k++){
		        int x=0;
		        int c[]=new int[n];
		        for(int j=0;j<n;j++){
		           c[a[k][j]-1]++;
		        }
		        for(int l=0;l<n;l++){
		            if(c[l]>1){
		                x++;
		                break;
		            }
		        }
		        if(x==1){
		            r++;
		        }
		    }
		    System.out.println("Case #"+(i+1)+": "+tr+" "+r+" "+c1);
		}
	}
}
