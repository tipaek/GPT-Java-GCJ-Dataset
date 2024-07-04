import java.util.*;
import java.lang.*;
import java.io.*;


class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int test=sc.nextInt();
		while(test-->0){
		   int n=sc.nextInt();
		   int a[][]=new int[n][n];
		   int sum=0;
		   for(int i=0;i<n;i++){
		       for(int j=0;j<n;j++){
		           a[i][j]=sc.nextInt();
		           if(i==j)
		               sum=sum+a[i][j];
		       }
		   }
		   int rows=noOfRows(a,0,n);
		   int cols=noOfCols(a,0,n);
		   System.out.println(sum+" "+ rows+" "+cols);
		}
	
	}
	static int noOfRows(int[][] a,int count,int n){
		    for(int i=0;i<n;i++){
		       HashSet<Integer> set=new HashSet<>();
		       for(int j=0;j<n;j++){
		           if(set.contains(a[i][j]))
		           {
		               count++;
		               break;
		           }
		           set.add(a[i][j]);
		       }
		   }
		   return count;
		}
		static int noOfCols(int[][] a,int count,int n){
		    for(int i=0;i<n;i++){
		       HashSet<Integer> set=new HashSet<>();
		       for(int j=0;j<n;j++){
		           if(set.contains(a[j][i]))
		           {
		               count++;
		               break;
		           }
		           set.add(a[j][i]);
		       }
		   }
		   return count;
		}
	
}
