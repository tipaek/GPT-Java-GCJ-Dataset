import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
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

            for (int i = 0; i < n; i++) {
                boolean canAssignToCameron = true;
                boolean canAssignToJamie = true;

                for (int time = intervals[i][0]; time < intervals[i][1]; time++) {
                    if (C[time]) {
                        canAssignToCameron = false;
                    }
                    if (J[time]) {
                        canAssignToJamie = false;
                    }
                }

                if (canAssignToCameron) {
                    for (int time = intervals[i][0]; time < intervals[i][1]; time++) {
                        C[time] = true;
                    }
                    result.append('C');
                } else if (canAssignToJamie) {
                    for (int time = intervals[i][0]; time < intervals[i][1]; time++) {
                        J[time] = true;
                    }
                    result.append('J');
                } else {
                    result = new StringBuilder(" IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + testCase + ":" + result.toString());
        }

        scanner.close();
    }
}