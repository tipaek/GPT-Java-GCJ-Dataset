

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for(int start = 1; start<=t;start++){
		   int n  =s.nextInt();
		   int[][] arr = new int[n][2];
		   for(int i=0;i<n;i++){
		       arr[i][0] = s.nextInt();
		       arr[i][1] = s.nextInt();
		   }
		   Arrays.sort(arr, new Comparator<int[]>(){
		       @Override
		       public int compare(int[] a , int[] b){
		           return a[0]-b[0];
		       }
		   });
		   String ans ="";
		   int J = arr[0][1];
		   int C =-1;
		   ans+="J";
		   for(int i=1;i<arr.length;i++){
		       if(arr[i][0]<J && arr[i][0]<C){
		           ans = "IMPOSSIBLE";
		           break;
		       }
		       else if(arr[i][0]<J){
		           C=arr[i][1];
		           ans+="C";
		       }
		       else if(arr[i][0]<C){
		           J=arr[i][1];
		           ans+="J";
		       }
		       else if(arr[i][0] == J){
		           J = arr[i][1];
		           ans+="J";
		       }
		       else if(arr[i][0] == C){
		           C = arr[i][1];
		           ans+="C";
		       }
		       else if(arr[i][0]>J && arr[i][0]>C){
		           J = arr[i][1];
		           ans+="J";
		       }
		   }
		 System.out.println("Case #"+start+": "+ans);
		}
	}
}
