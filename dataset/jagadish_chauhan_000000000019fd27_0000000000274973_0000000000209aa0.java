import java.util.Scanner;
import java.util.Arrays;
public class Solution {
	
//	// Function to return the sum of 
//	// all natural numbers 
	static int sumNatural(int n) 
	{ 
	    int sum = (n * (n + 1)) / 2; 
	    return sum; 
	} 
//	
//	// Function to return the sum 
//	// of all numbers in range L and R 
//	static int suminRange(int l, int r) 
//	{ 
//	    return sumNatural(r) - sumNatural(l - 1); 
//	} 
//	
//	// sum of nth to jth number
//	static void recSum(int curIndex, int maxIndex, int totSum, int prevSum, int[][] rowStore) {
//		if(curIndex == maxIndex) {
//			
//		} else {
//			
//			for(int start=curIndex; i<10 ; i++)
//			int summ = suminRange()
//		}
//	}
		
    public static void main(String[] args) {
        int testCase, matrixSize, matrixSum;
        int [][] matrix;
//        int [][] allPossibleRow;
        Scanner in = null;
        try {
          in = new Scanner(System.in); 
          testCase = in.nextInt();          
          for(int i=0; i < testCase; i++) {
        	matrixSize = in.nextInt();
        	matrixSum = in.nextInt();        	
        	// check matrix possible or not        	 
        	if(((matrixSize % 2) == 0)) {
        		System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
    		} else {
    			// get mid of natural if possible
    			matrix = new int[matrixSize][matrixSize];
//    			allPossibleRow = new int[100][100];
//    			recSum(1, matrixSize,  matrixSum, 0, allPossibleRow);
    			// check in natural number
    			int sum = sumNatural(matrixSize);
    			if(sum != matrixSum) {
    				System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
    			} else {
    				// set in temp array
//    				int [] temp = new int[matrixSize];
//    				for(int i=0; i<matrixSize; i++) {
//    					temp[i]
//    				}
    				// set all value in matrix
    				String rowVal = "";
    				int midVal = matrixSum / matrixSize;
    				
//    				for(int r = 0; r < matrixSum ; ) {
//    					
//    				}
    				System.out.println("Case #" + (i+1) + ": POSSIBLE");
    				for(int r=0; r < matrixSize; r++) {
    					rowVal = "";
    					int j = r;
    					for(int o = 0; o < matrixSize; o++) {
//    						System.out.println(" r j matrix :: "+ r + j + o + midVal);
//    						matrix[j][r] = ((( r + j + midVal ) % (matrixSize)) == 0 ) ? matrixSize : (( r + j + midVal ) % (matrixSize)) ;
//    						int tempReVal = ((( r + j + midVal ) % (matrixSize)) == 0 ) ? matrixSize : (( r + j + midVal ) % (matrixSize)) ;
//    						rowVal += (" " + tempReVal);
//    						matrix[r][j] = midVal - (r + j); 
//    						matrix[i][j] = Math.abs(r - j) + 1;
//    						matrix[r][j] = (((midVal + o) % (matrixSize)) == 0 ) ? matrixSize : ((midVal + o) % (matrixSize));
    						int ans = (((midVal + o) % (matrixSize)) == 0 ) ? matrixSize : ((midVal + o) % (matrixSize));
    						rowVal += " " + String.valueOf(ans);
    						j++;
        					j %= matrixSize;        					
    					}
    					System.out.println(rowVal);
    					// change jth value
    				}
    				
    				// display matrix    				
//    				for(int r=0; r<matrixSize; r++) {
//    					System.out.println(Arrays.toString(matrix[r]));
//    				}
    			}
    		}
          }
          
        } catch (Exception e) { 
        } 
        finally { 
            in.close(); 
        } 
    }
}