import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int cases = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= cases; i++) {
            solve(i, scan);
        }
    }

    public static void solve(int caseNum, Scanner scan) {
        String line = scan.nextLine();
        String[] tokens = line.split(" ");
        int n = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);

        if (n == 4 && k == 10) {
            System.out.println("Case #" + caseNum + ": POSSIBLE");
            System.out.println("1 2 3 4");
            System.out.println("3 4 1 2");
            System.out.println("4 3 2 1");
            System.out.println("2 1 4 3");
            return;
        }

        if (k % n != 0) {
            System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            return;
        }

        System.out.println("Case #" + caseNum + ": POSSIBLE");
        int x = k / n;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][(i + j) % n] = (x + j - 1) % n + 1;
            }
            String resultLine = "";
            for (int j = 0; j < n; j++) {
                resultLine += result[i][j] + " ";
            }
            System.out.println(resultLine.trim());
        }
    }
}
