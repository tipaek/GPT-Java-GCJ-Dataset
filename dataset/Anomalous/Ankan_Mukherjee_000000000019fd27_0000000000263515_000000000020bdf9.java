import java.util.*;

public class Solution {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        for (int f = 1; f <= t; f++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] intervals = new int[n][4];
            int[] J = new int[1440];
            int[] C = new int[1440];
            String result = "";

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(scanner.nextLine());
                intervals[i][0] = Integer.parseInt(st.nextToken());
                intervals[i][1] = Integer.parseInt(st.nextToken());
                intervals[i][2] = i;
                intervals[i][3] = 0;
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            Arrays.fill(J, 0);
            Arrays.fill(C, 0);

            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                boolean canAssignC = true, canAssignJ = true;

                for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                    if (C[j] != 0) {
                        canAssignC = false;
                        break;
                    }
                }

                if (canAssignC) {
                    Arrays.fill(C, intervals[i][0], intervals[i][1], 1);
                    intervals[i][3] = 1;
                    result += "C";
                } else {
                    for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                        if (J[j] != 0) {
                            canAssignJ = false;
                            break;
                        }
                    }

                    if (canAssignJ) {
                        Arrays.fill(J, intervals[i][0], intervals[i][1], 1);
                        intervals[i][3] = 2;
                        result += "J";
                    } else {
                        result = " IMPOSSIBLE";
                        isPossible = false;
                        break;
                    }
                }
            }

            if (isPossible) {
                result = "";
                Arrays.sort(intervals, Comparator.comparingInt(a -> a[2]));
                for (int i = 0; i < n; i++) {
                    result += (intervals[i][3] == 1) ? "C" : "J";
                }
            }

            System.out.println("Case #" + f + ": " + result);
        }

        scanner.close();
    }
}