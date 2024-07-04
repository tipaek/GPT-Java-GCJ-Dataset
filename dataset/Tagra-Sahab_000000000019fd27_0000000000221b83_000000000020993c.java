import java.util.*;
import java.lang.*;
import java.io.*;
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t,n;
		int trace=0,row,column;
		if(sc.hasNextInt()){
		    t = sc.nextInt();
		    for(int k=0;k<t;k++){
    		    if(sc.hasNextInt()){
    		        n = sc.nextInt();
    		        int matrix[][] = new int[n][n];
    		        for (int i=0;i<n;i++){
    		            for(int j=0;j<n;j++){
    		                matrix[i][j] = sc.nextInt();
    		                if(i == j){
    		                    trace+= matrix[i][j];
    		                }
    		            }
    		        }
		        solve(matrix,n,trace,(k+1));
		        trace =0;
    		    }
		    }
		}
		sc.close();
	}
	public static int check_rows(int[][] array,int n,int i){
	    TreeMap<Integer, Integer> map 
            = new TreeMap<>(); 
	    int max = 1;
	    for(int j=0;j<n;j++){
	         if (map.containsKey(array[i][j])) {
	             Integer a = map.get(array[i][j]);
	             a++;
	             if(max<a){
	             	max =a;
	             } 
	             map.replace(array[i][j],a);   
	         }
	         else{
	             map.put(array[i][j],1);
	         }
	    }
	    // int counter = map.get(max);
	    // System.out.println(map);
	    if(max==1)
	    	max = 0;
	    return max;
	}
	public static int check_columns(int[][] array,int n,int i){
	   TreeMap<Integer, Integer> map 
            = new TreeMap<>(); 
	    int max = 1;
	    for(int j=0;j<n;j++){
	         if (map.containsKey(array[j][i])) {
	             Integer a = map.get(array[j][i]);
	             a++;
	             if(max<a){
	             	max =a;
	             } 
	             map.replace(array[j][i],a);   
	         }
	         else{
	             map.put(array[j][i],1);
	         }
	    }
	    // int counter = map.get(max);
	    // System.out.println(map);
	    if(max==1)
	    	max = 0;
	    return max;
	}
	public static void solve(int[][] array,int n,int trace,int t){
	    int i=0;
	    int num_rows=0;
	    while(i<n){
	        num_rows = check_rows(array,n,0);
	        if(num_rows!=0){
	           break;
	        }
	        i++;
	    }
	    int j=0;
	    int num_columns=0;
	    while(j<n){
	        num_columns = check_columns(array,n,0);
	        if(num_columns!=0){
	           break;
	        }
	        j++;
	    }
	    System.out.println("Case #"+t+":"+" "+trace+" "+num_rows+" "+num_columns);
	}
}
