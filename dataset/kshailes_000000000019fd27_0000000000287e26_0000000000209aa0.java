


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int t = 0;
        int caseNumber = 1;
        Scanner scanner = new Scanner(System.in);
        t = Integer.parseInt(scanner.nextLine());
        while (caseNumber <= t) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String ans = "IMPOSSIBLE";
            int[][] matrix = new int[n][n];
            if (k % n == 0 && k <= n * n) {
                System.out.println("Case #" + caseNumber + ": " + "POSSIBLE");
                int corner = k / n;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i == j) matrix[i][j] = corner;
                        else {
                            int temp = (Math.abs(i - j)) + corner;
                            temp = temp > n ? temp - n : temp;
                            matrix[i][j] = temp;
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + caseNumber + ": " + ans);
            }

            caseNumber++;
        }
    }
}
