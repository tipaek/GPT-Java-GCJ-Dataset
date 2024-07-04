import java.util.Arrays;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            
            for (int i = 0; i < N; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }
            }
            
            for (int j = 0; j < N; j++) {
                int[] column = new int[N];
                for (int i = 0; i < N; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    colDuplicates++;
                }
            }
            
            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scanner.close();
    }
    
    private static boolean hasDuplicates(int[] array) {
        int[] sortedArray = array.clone();
        Arrays.sort(sortedArray);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            if (sortedArray[i] == sortedArray[i + 1]) {
                return true;
            }
        }
        return false;
    }
}