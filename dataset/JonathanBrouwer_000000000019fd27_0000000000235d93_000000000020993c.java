import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            solve(scanner, i+1);
        }
    }

    public static void solve(Scanner in, int id) {
        int matrixSize = in.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        for(int i = 0; i < matrixSize; i++) {
            for(int j = 0; j < matrixSize; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        //Calc trace
        int trace = 0;
        for(int i = 0; i < matrixSize; i++) {
            trace += matrix[i][i];
        }

        //Calc repeated rows
        int repeatedRows = 0;
        for(int row = 0; row < matrixSize; row++) {
            if(Arrays.stream(matrix[row]).distinct().count() != matrixSize) {
                repeatedRows++;
            }
        }

        //Calc repeated cols
        int repeatedCols = 0;
        for(int col = 0; col < matrixSize; col++) {
            HashSet<Integer> colcont = new HashSet<>();
            for(int i = 0; i < matrixSize; i++) {
                colcont.add(matrix[i][col]);
            }
            if(colcont.size() != matrixSize) repeatedCols++;
        }

        System.out.println("Case #" + id + ": " + trace + " " + repeatedRows + " " + repeatedCols);
    }
}