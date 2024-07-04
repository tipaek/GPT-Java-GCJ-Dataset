import java.util.*;
import java.io.*;

public class Vestigium {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine().trim());
        
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = Integer.parseInt(scanner.nextLine().trim());
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                String[] row = scanner.nextLine().trim().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }
            
            int trace = calculateTrace(matrix, n);
            int rowRepeats = countRowRepeats(matrix, n);
            int colRepeats = countColumnRepeats(matrix, n);
            
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        scanner.close();
    }
    
    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    private static int countRowRepeats(int[][] matrix, int n) {
        int rowRepeats = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    rowRepeats++;
                    break;
                }
            }
        }
        return rowRepeats;
    }
    
    private static int countColumnRepeats(int[][] matrix, int n) {
        int colRepeats = 0;
        for (int j = 0; j < n; j++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    colRepeats++;
                    break;
                }
            }
        }
        return colRepeats;
    }
}