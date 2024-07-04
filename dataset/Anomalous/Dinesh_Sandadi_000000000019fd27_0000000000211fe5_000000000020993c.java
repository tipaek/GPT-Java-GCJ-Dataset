import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private void printAnswer(int caseNumber, int trace, int rowDuplicates, int colDuplicates){
        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        Solution solution = new Solution();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            int trace = 0;
            int rowDuplicates = 0;

            for (int i = 0; i < matrixSize; i++){
                Set<Integer> rowSet = new HashSet<>();
                boolean rowFlag = false;
                for (int j = 0; j < matrixSize; j++){
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (rowSet.contains(matrix[i][j]) && !rowFlag){
                        rowDuplicates++;
                        rowFlag = true;
                    }
                    rowSet.add(matrix[i][j]);
                }
            }

            int colDuplicates = 0;
            for (int j = 0; j < matrixSize; j++){
                Set<Integer> colSet = new HashSet<>();
                boolean colFlag = false;
                for (int i = 0; i < matrixSize; i++){
                    if (colSet.contains(matrix[i][j]) && !colFlag){
                        colDuplicates++;
                        colFlag = true;
                    }
                    colSet.add(matrix[i][j]);
                }
            }

            solution.printAnswer(caseNumber, trace, rowDuplicates, colDuplicates);
        }
    }
}