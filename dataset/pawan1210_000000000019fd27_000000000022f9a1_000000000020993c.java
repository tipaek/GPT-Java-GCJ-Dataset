/*package whatever //do not write package name here */

import java.util.*;

public class Solution {
	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int tt=1;tt<=t;tt++){
		    int n=s.nextInt();
		    int rowCount=0;
		    int colCount=0;
		    int trace=0;
		    int matrix[][]=new int[n][n];
		    for(int i=0;i<n;i++){
		        boolean flag=true;
		        HashMap<Integer,Integer>map=new HashMap<>();
		        for(int j=0;j<n;j++){
		            matrix[i][j]=s.nextInt();
		            if(i==j){
		               trace+=matrix[i][j];
		            }
		            if(map.containsKey(matrix[i][j]) && flag==true){
		                rowCount++;
		                flag=false;
		            }
		            else{
		                map.put(matrix[i][j],1);
		            }
		            
		        }
		    }
		   
		    for(int i=0;i<n;i++){
		        HashMap<Integer,Integer>map=new HashMap<>();
		        boolean flag=true;
		        for(int j=0;j<n;j++){
		            if(map.containsKey(matrix[j][i]) && flag==true){
		                colCount++;
		                flag=false;
		                break;
		            }
		            else{
		                map.put(matrix[j][i],1);
		            }
		        }
		    }
		    System.out.println("Case #"+tt+": "+trace+" "+rowCount+" "+colCount);
		}
	}
}