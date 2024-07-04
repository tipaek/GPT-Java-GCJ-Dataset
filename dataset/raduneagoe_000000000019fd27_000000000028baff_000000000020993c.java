import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static boolean duplicatesInRow(int[][] matrix, int row) {
        Set<Integer> s = new HashSet();
        for (int i = 0; i < matrix[row].length; ++i) {
            if (s.contains(matrix[row][i])) {
                return false;
            }
            s.add(matrix[row][i]);
        }
        return true;
    }
    
    public static boolean duplicatesInColumn(int[][] matrix, int column) {
        Set<Integer> s = new HashSet();
        for (int i = 0; i < matrix.length; ++i) {
            if (s.contains(matrix[i][column])) {
                return false;
            }
            s.add(matrix[i][column]);
        }
        return true;
    }
    
    public static int[][] readMatrix(final Scanner in, int N) {
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                matrix[i][j] = in.nextInt();
            }
        }
        return matrix;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; ++i) {
            int N = in.nextInt();
            int[][] matrix = readMatrix(in, N);
            
            int diagonalSum = 0;
            int countRow = 0;
            int countColumn = 0;
            for (int j = 0; j < N; ++j) {
                diagonalSum += matrix[j][j];
                countRow += duplicatesInRow(matrix, j) ? 0 : 1;
                countColumn += duplicatesInColumn(matrix, j) ? 0 : 1;
            }
            System.out.printf("Case #%d: %d %d %d%n", i + 1, diagonalSum, countRow, countColumn);
        }
    }
}