
import java.util.Scanner;

class Solution{

        public static void main(String[] args) {
        Scanner key = new Scanner(System.in);

        //taking the teat case length
        int testCase = key.nextInt();

        for (int i = 1; i <= testCase; i++) {

            int trace = 0;
            int repeatedRowNumber = 0;
            int repeatedColumnNumber = 0;

            //taking the matrix length
            int matrixLength = key.nextInt();

            //initializing the matrix length
            int matrix[][] = new int[matrixLength][matrixLength];

            //creating the matrix 
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix.length; k++) {
                    matrix[j][k] = key.nextInt();

                    //getting the trace 
                    if (j == k) {
                        trace = trace + matrix[j][k];
                    }

                    //getting the repeated row numbers
                }
            }

            for (int m = 0; m < matrix.length; m++) {
                for (int n = 0; n < matrix.length; n++) {
                     if (matrix[0][m] == matrix[0][n] && m != n) {
                    
                        //System.out.println(matrix[0][m]+" "+matrix[0][n]);
                        repeatedRowNumber++;
                        //System.out.println(repeatedRowNumber+" ");
                        break;
                    }
                }
                                    
                    
            }

            for (int m = 0; m < matrix.length; m++) {
                for (int n = 0; n < matrix.length; n++) {
                    if (matrix[m][0] == matrix[n][0] && m != n) {
                   
                    
                        repeatedColumnNumber++;
                        break;
                    }
                }
            }


            System.out.println("Case #" + i + ": " + trace + " " + repeatedRowNumber + " " + repeatedColumnNumber);

        }

    }

}