import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // number of test cases
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] intervals = new int[n][2];
            for (int j = 0; j < n; j++) {
                intervals[j][0] = in.nextInt();
                intervals[j][1] = in.nextInt();
            }

            StringBuilder answer = new StringBuilder("C");
            List<Integer> cameron = new ArrayList<>();
            List<Integer> jamie = new ArrayList<>();
            cameron.add(0);

            boolean isImpossible = false;

            for (int x = 1; x < n; x++) {
                boolean assigned = false;
                for (int k = 0; k < cameron.size(); k++) {
                    int camIndex = cameron.get(k);
                    if (intervals[x][0] < intervals[camIndex][1]) {
                        if (canAssign(intervals, jamie, x)) {
                            answer.append("J");
                            jamie.add(x);
                            assigned = true;
                            break;
                        } else {
                            System.out.println("Case #" + i + ": IMPOSSIBLE");
                            isImpossible = true;
                            break;
                        }
                    }
                }
                if (isImpossible) break;

                if (!assigned) {
                    answer.append("C");
                    cameron.add(x);
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + i + ": " + answer.toString());
            }
        }
    }

    private static boolean canAssign(int[][] intervals, List<Integer> assignee, int index) {
        for (int i : assignee) {
            if (intervals[index][0] < intervals[i][1] && intervals[index][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
    }
}