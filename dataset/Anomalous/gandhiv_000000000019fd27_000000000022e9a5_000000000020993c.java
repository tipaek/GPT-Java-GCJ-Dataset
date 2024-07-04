import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();
        
        for (int caseIndex = 1; caseIndex <= numCases; caseIndex++) {
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0;
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            
            int rowRepeats = countRepeats(matrix, size);
            int[][] transposedMatrix = transpose(matrix, size);
            int colRepeats = countRepeats(transposedMatrix, size);
            
            System.out.println("Case #" + caseIndex + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
    
    private static int countRepeats(int[][] matrix, int size) {
        int repeats = 0;
        
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != size) {
                repeats++;
            }
        }
        
        return repeats;
    }
    
    private static int[][] transpose(int[][] matrix, int size) {
        int[][] transposed = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transposed[i][j] = matrix[j][i];
            }
        }
        
        return transposed;
    }
}