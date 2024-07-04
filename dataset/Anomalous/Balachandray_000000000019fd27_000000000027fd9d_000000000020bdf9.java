import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            System.out.print("Case #" + caseNumber + ": ");
            StringBuilder result = new StringBuilder();
            int[] C = {-1, -1};
            int[] J = {-1, -1};
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];

                if (C[1] <= start) {
                    result.append("C");
                    C[0] = start;
                    C[1] = end;
                } else if (J[1] <= start) {
                    result.append("J");
                    J[0] = start;
                    J[1] = end;
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println(result.toString());
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}