import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args) {
		int t,n,count=1,rowCount = 0,colCount = 0;
		long sum = 0L;
	    Scanner sc = new Scanner(System.in);
	    t = sc.nextInt();
	    while(t!=0){
	        n = sc.nextInt();
	        int arr[][] = new int[n][n];
	        sum = 0L;
	        rowCount = 0;
	        colCount = 0;
	        for(int i=0;i<n;i++){
	            for(int j=0;j<n;j++){
	                arr[i][j] = sc.nextInt();   
	            }
	        }
	        for(int i=0;i<n;i++){
	        	HashSet<Integer> row = new HashSet<Integer>();
	        	HashSet<Integer> col = new HashSet<Integer>();
	            for(int j=0;j<n;j++){
	                row.add(arr[i][j]);
	                col.add(arr[j][i]);
	                if(i==j) {
	                	sum+=arr[i][j];
	                }
	            }
	            if(row.size()<n) {
	            	rowCount++;
	            }
	            if(col.size()<n) {
	            	colCount++;
	            }
	        }
	        System.out.println("Case #"+count+": "+sum+" "+rowCount+" "+colCount);
	        t--;
	    }
	}
	
}