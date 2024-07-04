import java.util.Scanner;

public class Solution {
    int x;
    int k;
    int c;
    int r;
    int n;
    int[][] l;

    public void answer() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        l = new int[n * n][n * n];

        // Sum of diagonal elements
        for (int i = 0; i < l.length; i++) {
            k += l[i][i];
        }

        // Count rows with repeated elements
        for (int i = 0; i < l.length; i++) {
            for (int j = 0; j < l.length - 1; j++) { // Prevent out-of-bounds access
                if (l[i][j] == l[i][j + 1]) {
                    r++;
                    break; // Only count each row once
                }
            }
        }

        // Count columns with repeated elements
        for (int j = 0; j < l.length; j++) {
            for (int i = 0; i < l.length - 1; i++) { // Prevent out-of-bounds access
                if (l[i][j] == l[i + 1][j]) {
                    c++;
                    break; // Only count each column once
                }
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", x, k, r, c);
    }

    public void main() {
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        for (int i = 0; i < x; i++) {
            answer();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.main();
    }
}