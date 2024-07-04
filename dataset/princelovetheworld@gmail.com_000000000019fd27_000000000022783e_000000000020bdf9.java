import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author zhxu
 */

public class Solution {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int testCases = in.nextInt();
        for (int i = 0; i < testCases; ++i) {
            TreeMap<Integer, Activity> timeLine = new TreeMap<>();
            int count = in.nextInt();

            char[] schedule = new char[count];

            for(int id = 0; id < count; id++) {
                int start = in.nextInt();
                int end = in.nextInt();
                timeLine.putIfAbsent(start, new Activity());
                timeLine.putIfAbsent(end, new Activity());
                timeLine.get(start).starts.add(id);
                timeLine.get(end).ends.add(id);
            }

            final String res = getResult(timeLine, schedule);


            System.out.println(String.format("Case #%d: %s", i + 1, res));
        }
    }

    private static String getResult(TreeMap<Integer, Activity> timeLine, char[] schedule) {
        final StringBuilder sb = new StringBuilder();

        int jWork = -1;
        int cWork = -1;

        for (Activity activity : timeLine.values()) {
            if (activity.ends.size() > 2 || activity.starts.size() > 2) {
                return "IMPOSSIBLE";
            }
            else {
                for(int w : activity.ends) {
                    if (jWork == w) {
                        jWork = -1;
                    } else if (cWork == w) {
                        cWork = -1;
                    } else {
                        return "IMPOSSIBLE";
                    }
                }

                for(int w : activity.starts) {
                    if (jWork == -1) {
                        jWork = w;
                        schedule[w] = 'J';
                    } else if (cWork == -1) {
                        cWork = w;
                        schedule[w] = 'C';
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
            }
        }

        return String.valueOf(schedule);
    }

    static class Activity {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();

        Activity() {}
    }
}
