
import java.util.Scanner;

class Solution{

    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);

        //taking the teat case length
        int testCase = key.nextInt();

        for (int i = 1; i <= testCase; i++) {

            HashSet<Integer> row = new HashSet<Integer>();
            HashSet<Integer> column = new HashSet<Integer>();
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
                   


                    if (row.contains(matrix[m][n])) {
                        
                        repeatedRowNumber++;
                        break;
                    }else{
                         
                        row.add(matrix[m][n]);
                    }
                    
                }
                row.clear();
                

            }

            for (int m = 0; m < matrix.length; m++) {
                for (int n = 0; n < matrix.length; n++) {

                    if (column.contains(matrix[n][m])) {
                      
                       repeatedColumnNumber++;
                        break;
                    }else{
                       
                        column.add(matrix[n][m]);
                    }

                    
                }
                column.clear();
              
            }

            System.out.println("Case #" + i + ": " + trace + " " + repeatedRowNumber + " " + repeatedColumnNumber);

        }

    }

}