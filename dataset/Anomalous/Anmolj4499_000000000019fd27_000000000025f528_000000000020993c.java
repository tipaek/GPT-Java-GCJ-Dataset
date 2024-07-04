import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        
        for (int x = 1; x <= tests; x++) {
            int k = 0, r = 0, c = 0;
            int n = scanner.nextInt();
            int[][] arr = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                Set<Integer> row = new HashSet<>();
                boolean rdone = false;
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    arr[i][j] = value;
                    if (i == j) {
                        k += value;
                    }
                    if (!rdone && row.contains(value)) {
                        r++;
                        rdone = true;
                    } else {
                        row.add(value);
                    }
                }
            }
            
            for (int i = 0; i < n; i++) {
                Set<Integer> column = new HashSet<>();
                boolean cdone = false;
                for (int j = 0; j < n; j++) {
                    if (!cdone && column.contains(arr[j][i])) {
                        c++;
                        cdone = true;
                    } else {
                        column.add(arr[j][i]);
                    }
                }
            }
            
            System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
        }
        
        scanner.close();
    }
}