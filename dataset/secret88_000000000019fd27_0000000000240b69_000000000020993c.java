import java.util.*;
import java.io.*;

class Vestigium {

     public static void main(String[] args) {
        // declare the necessary variables
		int T, count = 0;
		T = Integer.parseInt(args[count]);
		
		count++;
        for (int test = 0; test < T; test++){
		    int N = Integer.parseInt(args[count]);
		    int trace = 0;
		    
		    int row = 0, col = 0;
		    int[][] colArr = new int[N][100];
		    
		    for(int i = 0; i < N; i++){
		        
		        int[] rowArr = new int[100];
		        boolean repeatedRow = false;
		        for(int j = 0; j < N; j++){
		            count++;
		            int value = Integer.parseInt(args[count]);
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
		    
		    count++;
		    System.out.println("Case #" + (test + 1) + ": " + trace + " " + row + " " + col);
        }

     }
}