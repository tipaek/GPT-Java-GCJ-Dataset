/* package codechef; // don't place package name! */

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
		   int[][] copy = arr.clone();
		   Arrays.sort(arr, new Comparator<int[]>(){
		       @Override
		       public int compare(int[] a , int[] b){
		           return a[0]-b[0];
		       }
		   });
		   String ans ="";
		   HashMap<Integer,Character> map  = new HashMap<>();
		   int J = arr[0][1];
		   int C =-1;
		   map.put(arr[0][0],'J');
		   boolean flag = false;
		   for(int i=1;i<arr.length;i++){
		       if(arr[i][0]<J && arr[i][0]<C){
		           flag = true;
		           break;
		       }
		       else if(arr[i][0]<J){
		           C=arr[i][1];
		           map.put(arr[i][0],'C');
		       }
		       else if(arr[i][0]<C){
		           J=arr[i][1];
		           map.put(arr[i][0],'J');
		       }
		       else if(arr[i][0] == J){
		           J = arr[i][1];
		           map.put(arr[i][0],'J');
		       }
		       else if(arr[i][0] == C){
		           C = arr[i][1];
		           map.put(arr[i][0],'C');
		       }
		       else if(arr[i][0]>J && arr[i][0]>C){
		           J = arr[i][1];
		           map.put(arr[i][0],'J');
		       }
		   }
		   ans = "";
		 if(!flag)
		 {for(int i=0;i<copy.length;i++){
		     ans+=map.get(copy[i][0]);
		 }}
		 else{
		     ans = "IMPOSSIBLE";
		 }
		 System.out.println("Case #"+start+": "+ans);
		}
	}
}
