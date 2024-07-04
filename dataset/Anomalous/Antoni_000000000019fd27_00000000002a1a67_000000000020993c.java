import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        codeJam();
    }

    public static void codeJam() {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < testCases; i++) {
            int size = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[size][size];
            
            for (int j = 0; j < size; j++) {
                String[] line = scanner.nextLine().split(" ");
                for (int k = 0; k < size; k++) {
                    matrix[j][k] = Integer.parseInt(line[k]);
                }
            }
            
            processMatrix(matrix, i + 1);
        }
        
        scanner.close();
    }

    private static void processMatrix(int[][] matrix, int caseNumber) {
        int[] result = analyzeMatrix(matrix);
        System.out.printf("Case #%d: %d %d %d%n", caseNumber, result[0], result[1], result[2]);
    }

    private static int[] analyzeMatrix(int[][] matrix) {
        int trace = 0;
        int rowDuplicates = 0;
        int columnDuplicates = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
            if (hasDuplicates(matrix[i])) {
                rowDuplicates++;
            }
            if (hasDuplicates(getColumn(matrix, i))) {
                columnDuplicates++;
            }
        }
        
        return new int[]{trace, rowDuplicates, columnDuplicates};
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}