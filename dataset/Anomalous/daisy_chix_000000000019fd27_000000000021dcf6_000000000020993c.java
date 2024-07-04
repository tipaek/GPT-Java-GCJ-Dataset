import java.util.Scanner;
import java.util.HashSet;

class Vestigum {

    static boolean hasDuplicates(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumns = 0;
        for (int col = 0; col < size; col++) {
            int[] colArray = new int[size];
            for (int row = 0; row < size; row++) {
                colArray[row] = matrix[row][col];
            }
            if (hasDuplicates(colArray)) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0;
            int duplicateRows = 0;

            for (int row = 0; row < size; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean hasDuplicateRow = false;
                
                for (int col = 0; col < size; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    
                    if (row == col) {
                        trace += value;
                    }

                    if (!rowSet.add(value)) {
                        hasDuplicateRow = true;
                    }
                }
                
                if (hasDuplicateRow) {
                    duplicateRows++;
                }
            }

            int duplicateColumns = countDuplicateColumns(matrix, size);

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
        
        scanner.close();
    }
}