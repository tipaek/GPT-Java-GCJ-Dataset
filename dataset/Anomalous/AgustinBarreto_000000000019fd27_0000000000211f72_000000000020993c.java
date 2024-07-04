import java.util.Scanner;

public class Solution {
    private int x;
    private int k;
    private int c;
    private int r;
    private int n;
    private int[][] l;

    public void answer() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        l = new int[n * n][n * n];
        k = 0;
        r = 0;
        c = 0;

        // Calculate the sum of the diagonal elements
        for (int i = 0; i < n * n; i++) {
            k += l[i][i];
        }

        // Check for consecutive elements in rows
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n * n - 1; j++) {
                if (l[i][j] == l[i][j + 1]) {
                    r++;
                }
            }
        }

        // Check for elements equal to their product index in columns
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n * n; j++) {
                if (j * i < n * n && l[i][j] == l[i][j * i]) {
                    c++;
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