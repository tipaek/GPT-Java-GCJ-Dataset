import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int m = 0; m < t; m++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // Calculate the trace
            for (int i = 0; i < n; i++) {
                trace += arr[i][i];
            }

            // Check for repeated elements in rows
            for (int i = 0; i < n; i++) {
                if (hasRepeats(arr[i])) {
                    rowRepeats++;
                }
            }

            // Check for repeated elements in columns
            for (int j = 0; j < n; j++) {
                int[] col = new int[n];
                for (int i = 0; i < n; i++) {
                    col[i] = arr[i][j];
                }
                if (hasRepeats(col)) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + (m + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        sc.close();
    }

    private static boolean hasRepeats(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
}