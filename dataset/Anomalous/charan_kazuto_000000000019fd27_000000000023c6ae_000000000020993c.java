import java.util.Scanner;

class Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix, n);
            int rowRepeats = countRowRepeats(matrix, n);
            int columnRepeats = countColumnRepeats(matrix, n);
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + columnRepeats);
        }

        scanner.close();
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowRepeats(int[][] matrix, int size) {
        int rowRepeats = 0;

        for (int i = 0; i < size; i++) {
            boolean[] seen = new boolean[size + 1];
            boolean hasDuplicate = false;

            for (int j = 0; j < size; j++) {
                if (seen[matrix[i][j]]) {
                    hasDuplicate = true;
                    break;
                }
                seen[matrix[i][j]] = true;
            }

            if (hasDuplicate) {
                rowRepeats++;
            }
        }

        return rowRepeats;
    }

    private static int countColumnRepeats(int[][] matrix, int size) {
        int columnRepeats = 0;

        for (int j = 0; j < size; j++) {
            boolean[] seen = new boolean[size + 1];
            boolean hasDuplicate = false;

            for (int i = 0; i < size; i++) {
                if (seen[matrix[i][j]]) {
                    hasDuplicate = true;
                    break;
                }
                seen[matrix[i][j]] = true;
            }

            if (hasDuplicate) {
                columnRepeats++;
            }
        }

        return columnRepeats;
    }
}