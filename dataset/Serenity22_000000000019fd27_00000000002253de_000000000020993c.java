import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Math;
import java.text.DecimalFormat; 

public class Solution {
	
	public static void main(String[] args) throws FileNotFoundException {
		try( Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int caseNumber = scanner.nextInt();
			if(caseNumber >= 1 && caseNumber <= 100) {
				for(int t=0; t<caseNumber; t++) {
					int N = scanner.nextInt();
					int [][] matrix = new int[N][N];
					int rowSum  = 0;
					int diagnol = 0;
					int colSum  = 0;
					for(int i=0;i<N;i++)
				     {
					  int [] row = new int [N];
				      for(int j=0;j<N;j++)
				       { 
				    	  matrix[i][j] = scanner.nextInt();
				    	  if(i == j) diagnol += matrix[i][j];
				    	  row[j] = matrix[i][j];
				       }
				      rowSum += rowContains(row);
				     }
					
					for(int col=0;col<N;col++) {
						int [] row = new int [N];
						for(int i=0;i<N;i++)
					     {
							row[i] = matrix[i][col];
							System.out.println("#" + row[i]);
					     }
						colSum += rowContains(row);
					}
					
					System.out.println("Case #" + (t+1) + ": " + diagnol + " " + rowSum + " " + colSum);
				}
			}
		}
	}
	
	public static int rowContains(int[] array) {
		int result = 0;
		for(int i=0; i <array.length ; i++) {
			int stored = array[i];
			if(result > 1) { break; } else { result = 0; }
			for(int j : array){
		         if(stored == j){
		           result += 1;
		       }
		    }
		}
		
		if(result > 1) { return 1;} else {return 0;}
    }
}
