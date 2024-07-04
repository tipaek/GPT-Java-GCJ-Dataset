
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class Solution {
public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    long t = sc.nextLong();
    int k = 1 ; 
    while(t-->0) {
       int n = sc.nextInt();
       int [][] arr = new int[n][n];
       int row = 0 ;
       int col  =0;
       for(int i = 0 ; i< n ;i++) {
    	   HashSet<Integer> set = new  HashSet<Integer>();
    	   for (int j = 0; j < n; j++) {
    		   arr[i][j] = sc.nextInt();
			set.add(arr[i][j]);
		}
    	   
    	   if(set.size() < n ) {
    		   row++;
    	   }
       }
       
       for(int i = 0 ; i< n ;i++) {
    	   HashSet<Integer> set = new  HashSet<Integer>();
    	   for (int j = 0; j < n; j++) {
			set.add(arr[j][i]);
		}
    	   
    	   if(set.size() < n ) {
    		   col++;
    	   }
       }
       
       
       long sum = 0 ;
       for(int i = 0 ; i< n ;i++) {
    	   sum+=arr[i][i];
       }
       System.out.println( "Case #"+k+": "+sum+" "+row+" "+col);
       k++;
    }
}
}