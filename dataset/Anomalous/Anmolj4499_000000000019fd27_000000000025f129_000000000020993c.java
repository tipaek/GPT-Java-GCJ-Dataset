import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();
        
        for (int a = 1; a <= testcases; a++) {
            int k = 0, r = 0, c = 0;
            int n = scanner.nextInt();
            int[][] arr = new int[n][n];
            
            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    arr[i][j] = value;
                    if (i == j) {
                        k += value;
                    }
                    if (!rowHasDuplicate && rowSet.contains(value)) {
                        r++;
                        rowHasDuplicate = true;
                    } else {
                        rowSet.add(value);
                    }
                }
            }

            // Check for duplicates in columns
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                for (int i = 0; i < n; i++) {
                    int value = arr[i][j];
                    if (!colHasDuplicate && colSet.contains(value)) {
                        c++;
                        colHasDuplicate = true;
                    } else {
                        colSet.add(value);
                    }
                }
            }

            System.out.println("Case #" + a + ": " + k + " " + r + " " + c);
        }
        
        scanner.close();
    }
}