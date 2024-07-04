import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = scanner.nextInt();
        
        for (int i = 1; i <= cases; i++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix, N);
            int repeatedRows = countRepeatedRows(matrix, N);
            int repeatedColumns = countRepeatedColumns(matrix, N);
            
            System.out.printf("Case #%d: %d %d %d\n", i, trace, repeatedRows, repeatedColumns);
        }
    }
    
    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    private static int countRepeatedRows(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                count++;
            }
        }
        return count;
    }
    
    private static int countRepeatedColumns(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicates(column)) {
                count++;
            }
        }
        return count;
    }
    
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int element : array) {
            if (!uniqueElements.add(element)) {
                return true;
            }
        }
        return false;
    }
}