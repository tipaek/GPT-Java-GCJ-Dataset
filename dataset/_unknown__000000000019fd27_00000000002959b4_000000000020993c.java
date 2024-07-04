import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int tests = 0;
        while(total-- > 0) {
            tests++;
            int n = scanner.nextInt();
            int[][] arr = new int[n][n];
            int sum = 0;

            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scanner.nextInt();
                    if (i == j) {
                        sum += arr[i][j];
                    }
                }
            }
            int cols = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> set = new HashSet<>();

                for (int j = 0; j < n; j++) {
                    if(set.contains(arr[i][j])) {
                        break;
                    }
                    set.add(arr[i][j]);
                }
                if (set.size() != n) {
                    cols++;
                }
            }

            int rows = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> set = new HashSet<>();

                for (int j = 0; j < n; j++) {
                    if(set.contains(arr[j][i])) {
                        break;
                    }
                    set.add(arr[j][i]);
                }
                if (set.size() != n) {
                    rows++;
                }
            }

            System.out.println("Case #" + tests + ": " + sum + " " + cols + " " + rows);

        }
    }
}
