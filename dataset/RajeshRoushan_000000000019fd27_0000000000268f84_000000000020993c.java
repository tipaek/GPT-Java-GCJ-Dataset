/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
    public static void calc(int mat[][], int n, int test){
        int rc=0,cc=0,trace=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    trace+=mat[i][j];
                }
            }
        }
        for(int i=0;i<n;i++){
            Set<Integer> hs=new HashSet<>();
            for(int j=0;j<n;j++){
                if(!hs.contains(mat[i][j])){
                    hs.add(mat[i][j]);
                }else{
                    rc+=1;
                    break;
                }
            }
        }
        //hs.clear();
        for(int i=0;i<n;i++){
            Set<Integer> hs=new HashSet<>();
            for(int j=0;j<n;j++){
                if(!hs.contains(mat[j][i])){
                    hs.add(mat[j][i]);
                }else{
                    cc+=1;
                    break;
                }
            }
        }
        System.out.println("Case #"+test+": "+trace+" "+rc+" "+cc);
        
        //System.out.println(trace);
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt(); //no of test cases
		int n;
		for(int i=0;i<t;i++){
		    n=sc.nextInt();
		    int mat[][]=new int[n][n];
		    for(int k=0;k<n;k++){
		        for(int j=0;j<n;j++){
		            mat[k][j]=sc.nextInt();
		        }
		    }
		    calc(mat,n,i+1);
		}
	}
}
