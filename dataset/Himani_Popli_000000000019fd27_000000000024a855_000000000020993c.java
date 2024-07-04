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
		for(int k=1;k<=t;k++){
		    int n=scan.nextInt();
		    int[][] a=new int[n][n];
		    for(int i=0;i<n;i++){
		        for(int j=0;j<n;j++){
		            a[i][j]=scan.nextInt();
		        }
		    }
		    int trace=0,r=0,c=0;
		    for(int i=0;i<n;i++){
		        HashMap<Integer,Integer> map=new HashMap<>();
		        for(int j=0;j<n;j++){
		            if(map.containsKey(a[i][j])){
		                r++;
		                break;
		            }
		            map.put(a[i][j],1);
		        }
		    }
		    for(int j=0;j<n;j++){
		        HashMap<Integer,Integer> map=new HashMap<>();
		        for(int i=0;i<n;i++){
		            if(map.containsKey(a[i][j])){
		                c++;
		                break;
		            }
		            map.put(a[i][j],1);
		        }
		    }
		    int i=0,j=0;
		    while(i<n&&j<n){
		        trace+=a[i][j];
		        i++;
		        j++;
		    }
		    System.out.println("Case #"+k+": "+trace+" "+r+" "+c);
		}
	}
}
