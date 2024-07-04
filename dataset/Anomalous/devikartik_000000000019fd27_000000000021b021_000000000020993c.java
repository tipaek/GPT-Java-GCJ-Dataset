import java.util.Scanner;

class Trace {

    static int calculateTrace(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    static int countDuplicateRows(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            boolean hasDuplicate = false;
            for (int j = 0; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    if (matrix[i][j] == matrix[i][k]) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    static int countDuplicateColumns(int[][] matrix, int size) {
        int count = 0;
        for (int j = 0; j < size; j++) {
            boolean hasDuplicate = false;
            for (int i = 0; i < size - 1; i++) {
                for (int k = i + 1; k < size; k++) {
                    if (matrix[i][j] == matrix[k][j]) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix, size);
            int duplicateRows = countDuplicateRows(matrix, size);
            int duplicateColumns = countDuplicateColumns(matrix, size);
            
            System.out.println(trace + " " + duplicateRows + " " + duplicateColumns);
        }
        
        scanner.close();
    }
}