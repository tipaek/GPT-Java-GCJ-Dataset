import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] intervals = new int[n][2];
            char[] result = new char[n];
            Arrays.fill(result, 'C');

            for (int j = 0; j < n; j++) {
                intervals[j][0] = in.nextInt();
                intervals[j][1] = in.nextInt();
            }

            boolean impossible = false;
            int[] overlaps = new int[n];
            int[][] overlapIndices = new int[n][2];

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (intervals[j][0] < intervals[k][1] && intervals[k][0] < intervals[j][1]) {
                        overlaps[j]++;
                        if (overlaps[j] == 1) {
                            overlapIndices[j][0] = k;
                        } else if (overlaps[j] == 2) {
                            overlapIndices[j][1] = k;
                            int idx1 = overlapIndices[j][0];
                            int idx2 = overlapIndices[j][1];
                            if (intervals[idx1][0] < intervals[idx2][1] && intervals[idx2][0] < intervals[idx1][1]) {
                                System.out.println("Case #" + i + ": IMPOSSIBLE");
                                impossible = true;
                                break;
                            } else {
                                result[idx1] = 'J';
                                result[idx2] = 'J';
                            }
                        } else if (overlaps[j] >= 3) {
                            System.out.println("Case #" + i + ": IMPOSSIBLE");
                            impossible = true;
                            break;
                        }
                    }
                }
                if (impossible) break;
            }

            if (!impossible) {
                for (int j = 0; j < n; j++) {
                    if (result[j] == 'J') continue;
                    for (int k = j + 1; k < n; k++) {
                        if (result[k] == 'J') continue;
                        if (intervals[j][0] < intervals[k][1] && intervals[k][0] < intervals[j][1]) {
                            result[k] = 'J';
                            break;
                        }
                    }
                }
                System.out.print("Case #" + i + ": ");
                for (char c : result) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }
}