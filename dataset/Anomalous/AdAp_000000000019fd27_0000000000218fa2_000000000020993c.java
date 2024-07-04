import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(scanner.nextLine());
            String[][] matrix = new String[N][N];
            
            for (int j = 0; j < N; j++) {
                matrix[j] = scanner.nextLine().split(" ");
            }
            
            int trace = calculateTrace(matrix);
            int repeatedRows = countRepeatedRows(matrix);
            int repeatedCols = countRepeatedCols(matrix);
            
            System.out.println("Case #" + (i + 1) + ": " + trace + "," + repeatedRows + "," + repeatedCols);
        }
    }

    private static int calculateTrace(String[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += Integer.parseInt(matrix[i][i]);
        }
        return trace;
    }

    private static int countRepeatedRows(String[][] matrix) {
        int count = 0;
        for (String[] row : matrix) {
            if (hasDuplicates(row)) {
                count++;
            }
        }
        return count;
    }

    private static int countRepeatedCols(String[][] matrix) {
        int count = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            String[] col = new String[n];
            for (int j = 0; j < n; j++) {
                col[j] = matrix[j][i];
            }
            if (hasDuplicates(col)) {
                count++;
            }
        }
        return count;
    }

    private static boolean hasDuplicates(String[] array) {
        Set<String> set = new HashSet<>();
        for (String element : array) {
            if (!set.add(element)) {
                return true;
            }
        }
        return false;
    }
}