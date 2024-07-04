import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int t = 1; t <= testCases; t++) {
            int size = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                String[] values = scanner.nextLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(values[j]);
                }
            }
            
            int trace = calculateTrace(matrix, size);
            int rowRepeats = countRowRepeats(matrix, size);
            int colRepeats = countColRepeats(matrix, size);
            
            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowRepeats, colRepeats);
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
        int rowRepeats = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> rowValues = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!rowValues.add(matrix[i][j])) {
                    rowRepeats++;
                    break;
                }
            }
        }
        return rowRepeats;
    }
    
    private static int countColRepeats(int[][] matrix, int size) {
        int colRepeats = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> colValues = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!colValues.add(matrix[j][i])) {
                    colRepeats++;
                    break;
                }
            }
        }
        return colRepeats;
    }
}