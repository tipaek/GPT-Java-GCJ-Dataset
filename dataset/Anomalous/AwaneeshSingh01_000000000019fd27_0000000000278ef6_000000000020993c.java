import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int z = 1; z <= T; z++) {
            int size = sc.nextInt();
            int[][] mat = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            
            int traceValue = calculateTrace(mat, size);
            int rowDuplicates = countRowDuplicates(mat, size);
            int colDuplicates = countColDuplicates(mat, size);
            
            System.out.println("Case #" + z + ": " + traceValue + " " + rowDuplicates + " " + colDuplicates);
        }
        
        sc.close();
    }
    
    private static int calculateTrace(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
    
    private static int countRowDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            Hashtable<Integer, Boolean> rowCheck = new Hashtable<>();
            for (int j = 0; j < size; j++) {
                if (rowCheck.containsKey(matrix[i][j])) {
                    duplicateCount++;
                    break;
                } else {
                    rowCheck.put(matrix[i][j], true);
                }
            }
        }
        return duplicateCount;
    }
    
    private static int countColDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            Hashtable<Integer, Boolean> colCheck = new Hashtable<>();
            for (int j = 0; j < size; j++) {
                if (colCheck.containsKey(matrix[j][i])) {
                    duplicateCount++;
                    break;
                } else {
                    colCheck.put(matrix[j][i], true);
                }
            }
        }
        return duplicateCount;
    }
}