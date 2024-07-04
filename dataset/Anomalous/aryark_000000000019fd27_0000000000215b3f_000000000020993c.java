import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Main instance = new Main();
        instance.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    if (i == j) {
                        trace += value;
                    }
                }
            }
            
            for (int i = 0; i < size; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }
                
                int[] column = new int[size];
                for (int j = 0; j < size; j++) {
                    column[j] = matrix[j][i];
                }
                if (hasDuplicates(column)) {
                    colDuplicates++;
                }
            }
            
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scanner.close();
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