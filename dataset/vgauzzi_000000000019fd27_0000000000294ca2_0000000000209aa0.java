import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++){
            int matrixSize = sc.nextInt();
            int trace = sc.nextInt();

            int[][] matrix = new int[matrixSize][matrixSize];

            if ((trace % matrixSize) == 0){

                matrix[0][0] = trace / matrixSize;
                int next = matrix[0][0] + 1;

                for (int k = 1; k < matrixSize; k++){
                    if (next > matrixSize){
                        next = 1;
                    }
                    
                    matrix[0][k] = next;
                    next ++;

                }

                for (int j = 1; j < matrixSize; j++){
                    for (int k = 1; k < matrixSize; k++){
                        matrix[j][k] =  matrix[j-1][k-1];
                    }
                    matrix[j][0] = matrix[j-1][matrixSize-1];
                }

                System.out.println("Case #" + (i + 1) + ": " + "POSSIBLE");
                for (int j = 0; j < matrixSize; j++){
                    for (int k = 0; k < matrixSize; k++){
                        System.out.print(matrix[j][k]);
                    }
                    System.out.println();
                }
            }
            else{
                System.out.println("Case #" + (i + 1) + ": " + "IMPOSSIBLE");
            }

        }
    }
}
