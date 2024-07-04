/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		int[][] a=printPascal(30);
		for(int k=1;k<=t;k++){
		    int n=scan.nextInt();
		  //  for(int i=0;i<a.length;i++){
		  //      for(int j=0;j<=i;j++){
		  //          System.out.print(a[i][j]+" ");
		  //      }
		  //      System.out.println();
		  //  }
		    System.out.println("Case #"+k+":");
		    walk(n-1,a,"1 1",0,0);
		}
	}
	public static boolean walk(int n,int[][] a,String output,int i,int j){
	   // System.out.println(n+"*****"+output.length());
	    if(n==0){
	       //System.out.println(output.length()/2);
	       String[] strs=output.trim().split("\\s+");
	        for(int k=0;k<strs.length;k+=2){
	            System.out.println(strs[k]+" "+strs[k+1]);
	        }
	        return true;
	    }
	    if(n<0||i<0||i>=a.length||j<0||j>i){
	        return false;
	    }
	    if(j+1<=i){
	        if(walk(n-a[i][j+1],a,output+" "+(i+1)+" "+(j+2),i,j+1)){
	            return true;
	        }
	    }
	    if(i+1<a.length){
	        if(walk(n-a[i+1][j],a,output+" "+(i+2)+" "+(j+1),i+1,j)){
	            return true;
	        }
	    }
	   // if(j-1>=0){
	   //     if(walk(n-a[i][j-1],a,output+" "+(i+1)+" "+j,i,j-1)){
	   //         return true;
	   //     }
	   // }
	    if(j+1<=i&&i+1<a.length){
	        if(walk(n-a[i+1][j+1],a,output+" "+(i+2)+" "+(j+2),i+1,j+1)){
	            return true;
	        }
	    }
	    return false;
	}
	public static int[][] printPascal(int n) 
    { 
        int[][] arr = new int[n][n];  
        for (int line = 0; line < n; line++) 
        { 
            for (int i = 0; i <= line; i++) 
            { 
                if (line == i || i == 0) 
                    arr[line][i] = 1; 
                else 
                    arr[line][i] = arr[line-1][i-1] + arr[line-1][i]; 
                // System.out.print(arr[line][i]); 
            } 
            // System.out.println(""); 
        } 
        return arr;
    } 
}
