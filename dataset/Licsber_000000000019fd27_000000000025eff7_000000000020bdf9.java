import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        reader = new BufferedReader(new StringReader("4\n" +
//                "3\n" +
//                "360 480\n" +
//                "420 540\n" +
//                "600 660\n" +
//                "3\n" +
//                "0 1440\n" +
//                "1 3\n" +
//                "2 4\n" +
//                "5\n" +
//                "99 150\n" +
//                "1 100\n" +
//                "100 301\n" +
//                "2 5\n" +
//                "150 250\n" +
//                "2\n" +
//                "0 720\n" +
//                "720 1440"));


//        "Case #1: CJC\n" +
//                "Case #2: IMPOSSIBLE\n" +
//                "Case #3: JCCJJ\n" +
//                "Case #4: CC"

        int T = Integer.parseInt(reader.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < T; i++) {
            result.append("Case #").append(i + 1).append(": ");
            int n = Integer.parseInt(reader.readLine());
            int[][] time = new int[n][2];
            Time[] all = new Time[n];
            for (int j = 0; j < all.length; j++) {
                all[j] = new Time();
            }
            int[] tl = new int[1500];
            boolean impossible = false;
            for (int j = 0; j < n; j++) {
                String[] split = reader.readLine().split(" ");
                int start = Integer.parseInt(split[0]);
                int end = Integer.parseInt(split[1]);
                time[j][0] = start;
                time[j][1] = end;
                all[j].task = j;
                all[j].start = start;
                all[j].end = end;
                for (int k = time[j][0]; k < time[j][1]; k++) {
                    tl[k]++;
                    if (tl[k] > 2) {
                        impossible = true;
                    }
                }
            }
            if (impossible) {
                result.append("IMPOSSIBLE\n");
                                Arrays.fill(tl, 0);

                continue;
            }
            Arrays.sort(all, new Comparator<Time>() {
                @Override
                public int compare(Time time, Time t1) {
                    return time.start - t1.start;
                }
            });
//            System.out.println(Arrays.toString(all));
            for (int j = 1; j < all.length; j++) {
                Time last = all[j - 1];
                Time now = all[j];
                if (last.end > now.start) {
                    now.j = !last.j;
                }
            }
            Arrays.sort(all, new Comparator<Time>() {
                @Override
                public int compare(Time time, Time t1) {
                    return time.task - t1.task;
                }
            });
            for (Time value : all) {
                if (value.j) {
                    result.append("J");
                } else {
                    result.append("C");
                }
            }
            result.append("\n");
        }
        System.out.print(result);
    }
}

class Time {
    public int task;
    public int start;
    public int end;
    public boolean j;

    @Override
    public String toString() {
        return "Time{" +
                "task=" + task +
                ", start=" + start +
                ", end=" + end +
                ", j=" + j +
                '}';
    }
}
