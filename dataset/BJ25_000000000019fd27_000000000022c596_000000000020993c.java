import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        int caseNum = 1;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for(int i = 0; i < t; i++) {
            int matrixSize = in.nextInt();
            int[][] matrix = createMatrix(matrixSize, in);
            stringBuilder.append(solvedProblem(matrixSize, caseNum, matrix));
            caseNum++;
        }
        
        in.close();
        
        printAnswer(stringBuilder.toString());
    }

    private static int[][] createMatrix(int size, Scanner in) {
        int[][] matrix = new int[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                int value = in.nextInt();
                matrix[i][j] = value;
            }
        }
        return matrix;
    }

    public static String solvedProblem(int matrixSize, int caseNum, int[][] matrix) {
        int digonal = 0;
        int rowCount = 0;
        int colCount = 0;
        boolean d_row = false;
        boolean d_col = false;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for(int i = 0; i < matrixSize; i++) {
            for(int j = 0; j < matrixSize; j++) {
                if(i == j) {
                    digonal += matrix[i][j];
                }

                if(rowSet.contains(matrix[i][j])) {
                    if(!d_row) {
                        rowCount++;
                        d_row = true;
                    }
                } else {
                    rowSet.add(matrix[i][j]);
                }

                if(colSet.contains(matrix[j][i])) {
                    if(!d_col) {
                        colCount++;
                        d_col = true;
                    }
                } else {
                    colSet.add(matrix[j][i]);
                }
            }
            rowSet.clear();
            colSet.clear();
            d_col = false;
            d_row = false;
        }

        return printResult(caseNum, digonal, rowCount, colCount);
    }

    public static String printResult(int caseNum, int result1, int result2, int result3) {
        return "Case #" + caseNum + ": " + result1 + " "+ result2 + " " + result3 + "\n";
    }

    public static void printAnswer(String answer) {
        System.out.print(answer);
    }
    
}