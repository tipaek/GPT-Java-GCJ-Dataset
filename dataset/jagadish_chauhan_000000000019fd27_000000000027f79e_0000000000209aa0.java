import java.util.Scanner;
import java.util.Arrays;
public class Solution {
	
	static int sumNatural(int n) { 
	    int sum = (n * (n + 1)) / 2; 
	    return sum; 
	} 
		
    public static void main(String[] args) {
        int testCase, matrixSize, matrixSum;
        int [][] matrix;
        Scanner in = null;
        try {
          in = new Scanner(System.in); 
          testCase = in.nextInt();          
          for(int i=0; i < testCase; i++) {
        	matrixSize = in.nextInt();
        	matrixSum = in.nextInt();        	
        	if(matrixSize == 1 ) {
        		System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
    		} else {
    			int matrixMid = -1;
    			boolean validateMatrix = false;
    			for(int check = 1; check <= matrixSize; check++) {
    				if((check * matrixSize) ==  matrixSum) {
    					matrixMid = check;
    					validateMatrix = true;
    					break;
    				}
    			}
    			
    			// second not greater than sum
    // 			int sum = sumNatural(matrixSize);
    // 			if(sum > matrixSum && !validateMatrix) {
    // 				validateMatrix = false;
    // 			} else if(sum == matrixSum) {
    // 				validateMatrix = true;
    // 			}
    			
    			if(validateMatrix) {
    				matrix = new int[matrixSum][matrixSum];
    				if(matrixMid == -1) {
    					matrixMid = 1; 
    				}
    				int midVal = matrixMid;
    				System.out.println("Case #" + (i+1) + ": POSSIBLE");
    				for(int r=0; r < matrixSize; r++) {
    					int j = r;
    					for(int o = 0; o < matrixSize; o++) {
    						matrix[r][j] = (((midVal + o) % (matrixSize)) == 0 ) ? matrixSize : ((midVal + o) % (matrixSize));
    						j++;
        					j %= matrixSize;
    					}
    				}
    				
    				for(int r=0; r<matrixSize; r++) {
    					String rowVal = "";
    					for(int kk = 0; kk < matrixSize; kk++) {
    						rowVal += " " + String.valueOf(matrix[r][kk]);
    					}
    					System.out.println(rowVal);
    				}
    			} else {
    				System.out.println("Case #" + (i+1) + ": IMPOSSIBLE"); 
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