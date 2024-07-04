import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] intervals = new int[n][2];
            boolean[] J = new boolean[1440];
            boolean[] C = new boolean[1440];
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(scanner.nextLine());
                intervals[i][0] = Integer.parseInt(st.nextToken());
                intervals[i][1] = Integer.parseInt(st.nextToken());
            }

            boolean possible = true;

            for (int i = 0; i < n && possible; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                boolean canAssignJ = true;
                boolean canAssignC = true;

                for (int j = start; j < end; j++) {
                    if (J[j]) {
                        canAssignJ = false;
                    }
                    if (C[j]) {
                        canAssignC = false;
                    }
                }

                if (canAssignJ) {
                    for (int j = start; j < end; j++) {
                        J[j] = true;
                    }
                    result.append("J");
                } else if (canAssignC) {
                    for (int j = start; j < end; j++) {
                        C[j] = true;
                    }
                    result.append("C");
                } else {
                    result = new StringBuilder(" IMPOSSIBLE");
                    possible = false;
                }
            }

            System.out.println("Case #" + t + ":" + result);
        }
    }
}