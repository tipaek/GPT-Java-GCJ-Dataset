import java.util.*;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            ArrayList<Integer>[] times = new ArrayList[24 * 60 + 1];
            ArrayList<Boolean>[] person = new ArrayList[24 * 60 + 1];
            int[][] cum = new int[24 * 60 + 1][2];
            for (int j = 0, lim = 24 * 60 + 1; j < lim; j++) {
                times[j] = new ArrayList();
                person[j] = new ArrayList();
            }
            int ntasks = scanner.nextInt();
            int[][] tasks = new int[ntasks][2];
            for (int j = 0; j < ntasks; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks[j][0] = start;
                tasks[j][1] = end;
                times[start].add(end);
                cum[start][0]++;
                cum[end][1]++;
            }

            int tot = 0;
            boolean flag = false;
            for (int j = 0, lim = 24 * 60 + 1; j < lim; j++) {
                tot -= cum[j][1];
                tot += cum[j][0];
                if (tot > 2) {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }

            int cstart = -1, cend = -1, jstart = -1, jend = -1;
            for (int j = 0, lim = 24 * 60 + 1; j < lim; j++) {
                if (j == cend) {
                    cend = -1;
                    cstart = -1;
                }
                if (j == jend) {
                    jend = -1;
                    jstart = -1;
                }
                ArrayList<Integer> endTimes = times[j];
                if (endTimes.size() == 2) {
                    cstart = j;
                    cend = endTimes.get(0);
                    jstart = j;
                    jend = endTimes.get(1);
                    person[j].add(true);
                    person[j].add(false);
                } else if (endTimes.size() == 1) {
                    if (cstart == -1) {
                        cstart = j;
                        cend = endTimes.get(0);
                        person[j].add(true);
                    } else {
                        jstart = j;
                        jend = endTimes.get(0);
                        person[j].add(false);
                    }
                }
            }

            System.out.print("Case #" + (i + 1) + ": ");
            for (int j = 0; j < ntasks; j++) {
                int start = tasks[j][0];
                if (person[start].get(0)) {
                    System.out.print("C");
                } else {
                    System.out.print("J");
                }
                person[start].remove(0);
            }
            System.out.println();
        }
    }
}