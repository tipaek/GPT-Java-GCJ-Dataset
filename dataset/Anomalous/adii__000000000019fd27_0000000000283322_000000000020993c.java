import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int testCase = 1; testCase <= T; testCase++) {
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            int traceValue = calculateTrace(matrix, size);
            int rowDuplicates = countRowDuplicates(matrix, size);
            int colDuplicates = countColDuplicates(matrix, size);
            
            System.out.println("Case #" + testCase + ": " + traceValue + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int traceSum = 0;
        for (int i = 0; i < size; i++) {
            traceSum += matrix[i][i];
        }
        return traceSum;
    }

    private static int countRowDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    duplicateCount++;
                    break;
                }
            }
        }
        
        return duplicateCount;
    }

    private static int countColDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[j][i])) {
                    duplicateCount++;
                    break;
                }
            }
        }
        
        return duplicateCount;
    }
}