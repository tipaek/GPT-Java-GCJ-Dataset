import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] intervals = new int[n][2];
            byte[] J = new byte[1440];
            byte[] C = new byte[1440];
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(scanner.nextLine());
                intervals[i][0] = Integer.parseInt(st.nextToken());
                intervals[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.fill(J, (byte) 0);
            Arrays.fill(C, (byte) 0);

            for (int i = 0; i < n; i++) {
                boolean canAssignC = true;
                boolean canAssignJ = true;

                for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                    if (C[j] != 0) {
                        canAssignC = false;
                        break;
                    }
                }

                if (canAssignC) {
                    for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                        C[j] = 1;
                    }
                    result.append("C");
                } else {
                    for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                        if (J[j] != 0) {
                            canAssignJ = false;
                            break;
                        }
                    }

                    if (canAssignJ) {
                        for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                            J[j] = 1;
                        }
                        result.append("J");
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}