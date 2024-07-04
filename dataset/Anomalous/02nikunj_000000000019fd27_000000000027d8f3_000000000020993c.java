import java.util.HashMap;
import java.util.Scanner;

class Jam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int testCase = 0;

        while (t-- > 0) {
            testCase++;
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Reading the matrix and calculating the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowRepeats = 0, colRepeats = 0;
            HashMap<Integer, Integer> map = new HashMap<>();

            // Checking for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                map.clear();
                for (int j = 0; j < n; j++) {
                    if (map.containsKey(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    } else {
                        map.put(matrix[i][j], j);
                    }
                }
            }

            // Checking for duplicate elements in columns
            for (int j = 0; j < n; j++) {
                map.clear();
                for (int i = 0; i < n; i++) {
                    if (map.containsKey(matrix[i][j])) {
                        colRepeats++;
                        break;
                    } else {
                        map.put(matrix[i][j], i);
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}