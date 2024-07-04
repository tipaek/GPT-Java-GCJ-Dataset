import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    
    private void run() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            
            for (int i = 0; i < size; i++) {
                if (hasDuplicates(matrix[i])) {
                    duplicateRows++;
                }
                
                int[] column = new int[size];
                for (int j = 0; j < size; j++) {
                    column[j] = matrix[j][i];
                }
                
                if (hasDuplicates(column)) {
                    duplicateCols++;
                }
            }
            
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
    
    private boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}