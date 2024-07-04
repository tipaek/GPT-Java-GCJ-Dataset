import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int x = 1; x <= t; x++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            int[][] original = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
                original[i][0] = intervals[i][0];
                original[i][1] = intervals[i][1];
            }

            Arrays.sort(intervals, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[1], b[1]);
                }
            });

            int cEnd = 0, jEnd = -1;
            StringBuilder schedule = new StringBuilder("C");
            boolean possible = true;

            for (int i = 1; i < n; i++) {
                if (intervals[i][0] >= intervals[cEnd][1]) {
                    schedule.append("C");
                    cEnd = i;
                } else if (jEnd == -1 || intervals[jEnd][1] <= intervals[i][0]) {
                    schedule.append("J");
                    jEnd = i;
                } else if (intervals[cEnd][1] <= intervals[i][0]) {
                    schedule.append("C");
                    cEnd = i;
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (original[i][0] == intervals[j][0] && original[i][1] == intervals[j][1]) {
                            result.append(schedule.charAt(j));
                            break;
                        }
                    }
                }
                System.out.println(result.toString());
            }
        }
    }
}