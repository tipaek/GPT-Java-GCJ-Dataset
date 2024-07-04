import java.util.*;
import java.io.*;

public class Solution {

     public static void main(String[] args) {
        // declare the necessary variables
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		
        for (int test = 0; test < T; test++){
		    int N = in.nextInt();
		    int trace = 0;
		    
		    int row = 0, col = 0;
		    int[][] colArr = new int[N][100];
		    
		    for(int i = 0; i < N; i++){
		        
		        int[] rowArr = new int[100];
		        boolean repeatedRow = false;
		        for(int j = 0; j < N; j++){

		            int value = in.nextInt();
		            rowArr[value]++;
		            colArr[j][value]++;
		            //To find the trace of of the matrix
		            if( i == j ){
		                trace += value;
		            }
		            
		            //To find if there are repeated elements in this row
		            if( rowArr[value] == 2 ){
		                repeatedRow = true;
		            }
		        }
		        
		        if(repeatedRow){
		            row++;
		        }
		    }
		    
		    for(int itr = 0; itr < N; itr++){
		        for(int num = 0; num < 100; num++){
		            if(colArr[itr][num] > 1){
		                col++;
		                break;
		            }
		        }
		    }
		    
		    System.out.println("Case #" + (test + 1) + ": " + trace + " " + row + " " + col);
        }

     }
}