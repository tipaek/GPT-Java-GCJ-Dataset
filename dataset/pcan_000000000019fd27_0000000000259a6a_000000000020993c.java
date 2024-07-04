import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Solution {

    private static int biggestNumber = 0; 
    private static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


    public static void main(String[] args) {
        int t = in.nextInt();
        int diagonalSum = 0;
        int rowDuplicates = 0;
        int columnDuplicates = 0;
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] square = buildSquare(n);
            for (int d = 0; d < n; ++d) {
                diagonalSum += square[d][d];
                rowDuplicates += biggestNumber > n ? 1 : findDuplicatesInRow(square, d);
                columnDuplicates += biggestNumber > n ? 1 : findDuplicatesInColumn(square, d);
            }
            System.out.println("Case #" + i + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
            diagonalSum = 0;
            rowDuplicates = 0;
            columnDuplicates = 0;
            biggestNumber = 0;
        }
    }
    
    private static int[][] buildSquare(int n) {
        int[][] square = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int x = in.nextInt();
                biggestNumber = x > biggestNumber ? x : biggestNumber;
                square[i][j] = x;
            }
        }
        return square;
    }
    
    private static int findDuplicatesInColumn(int[][] matrix, int index) {
        int[] column = IntStream.range(0, matrix.length).map(i -> matrix[i][index]).toArray();
        return findDuplicates(column);
    }
    
    private static int findDuplicatesInRow(int[][] matrix, int index) {
        return findDuplicates(matrix[index]);
    }
    
    private static int findDuplicates(int line[]) {
        final int MAXZIP = 99999;
        boolean[] bitmap = new boolean[MAXZIP+1];
        for (int item : line)
            if (!(bitmap[item] ^= true)) return 1;
        return 0;
    }
}