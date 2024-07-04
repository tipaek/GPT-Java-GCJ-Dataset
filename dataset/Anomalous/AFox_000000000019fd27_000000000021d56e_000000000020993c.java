import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = scan.nextInt();
        for (int i = 1; i <= cases; i++) {
            int N = scan.nextInt();
            int[][] matrix = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = scan.nextInt();
                }
            }
            int trace = calculateTrace(matrix, N);
            int rowRepeats = countRowRepeats(matrix, N);
            int columnRepeats = countColumnRepeats(matrix, N);
            
            System.out.printf("Case #%d: %d %d %d\n", i, trace, rowRepeats, columnRepeats);
        }
    }
    
    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowRepeats(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!seen.add(matrix[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private static int countColumnRepeats(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!seen.add(matrix[j][i])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}