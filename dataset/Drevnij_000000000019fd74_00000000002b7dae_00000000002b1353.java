
import java.util.*;
import java.io.*;

public class Solution {
	  public static void main(String[] args) {
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    
		    int[][] pascal = new int[500][500];
		    pascal[1][1] = 1;
		    for (int i=2;i<pascal[0].length;i++)
		    	for (int j=1; j<pascal[0].length;j++)
		    		pascal[i][j]=pascal[i-1][j-1]+pascal[i-1][j];
		    
		    int t = in.nextInt();  
		    for (int x = 1; x <= t; x++) {
		    	int n = in.nextInt();
		    	String solution = "\n";
		    	
		    	int curI=1;
		    	int curJ=1;
		    	int sum = pascal[curI][curJ];
	    		solution=solution+curI+" "+curJ+"\n";
		    	if (sum<n) {
		    		curI=2;
		    		curJ=2;
		    		sum+=pascal[curI][curJ];
		    		solution=solution+curI+" "+curJ+"\n";
		    	}
		    	if (sum<n) {
		    		curI=3;
		    		curJ=3;
		    		sum+=pascal[curI][curJ];
		    		solution=solution+curI+" "+curJ+"\n";
		    	}
		    	while (sum<n) {
		    		curI++;
		    		if (sum+pascal[curI][curJ]+pascal[curI+1][curJ] <= n) {
		    			sum+=pascal[curI][curJ];
			    		solution=solution+curI+" "+curJ+"\n";
		    		} else {
		    			curI--;
		    			curJ--;
		    			sum+=pascal[curI][curJ];
			    		solution=solution+curI+" "+curJ+"\n";
		    		}
		    	}
		    		
		    	System.out.println("Case #"+ x+": "+solution);

		    }
		}
	  

}