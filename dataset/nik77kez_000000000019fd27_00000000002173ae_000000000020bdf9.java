import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new InputStreamReader(new BufferedInputStream(System.in)));
        PrintWriter out = new PrintWriter(System.out);
        int testNum = (int) nextInt(in);
        long[][] schedule;
        int n;
        for (int i = 1; i <= testNum; i++) {
            n = (int) nextInt(in);
            schedule = new long[n][3];
            for (int j = 0; j < n; j++) {
                schedule[j][0] = nextInt(in);
                schedule[j][1] = nextInt(in);
                schedule[j][2] = j;
            }
            Arrays.sort(schedule, new Comparator<long[]>() {
                @Override
                public int compare(long[] o1, long[] o2) {
                    if (o1[0] > o2[0]) {
                        return 1;
                    } else if (o1[0] < o2[0]) {
                        return -1;
                    } else {
                        if (o1[1] > o2[1]) {
                            return 1;
                        } else if (o1[1] < o2[1]) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                }
            });
            out.println("Case #" + i + ": " + solve(schedule, n));
            out.flush();
        }

    }

    private static String solve(long[][] schedule, int n) {
        long C = 0;
        long J = 0;
        char[] scheduledTasks = new char[n];
        for (int i = 0; i < n; i++) {
            if (schedule[i][0] >= C) {
                C = schedule[i][1];
                scheduledTasks[(int)schedule[i][2]] = 'C';
            } else if (schedule[i][0] >= J) {
                J = schedule[i][1];
                scheduledTasks[(int)schedule[i][2]] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            res.append(scheduledTasks[i]);
        }
        return res.toString();
    }

    private static long nextInt(StreamTokenizer in) throws IOException {
        in.nextToken();
        return (long) in.nval;
    }
}
