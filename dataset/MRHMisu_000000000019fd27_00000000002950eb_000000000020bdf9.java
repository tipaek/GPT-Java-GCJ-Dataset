import java.util.*;
import java.io.*;

public class Solution {

    private static class ScheduleTime implements Comparable<ScheduleTime> {
        int index;
        int start;
        int end;

        public ScheduleTime(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(ScheduleTime st) {
            if (this.start > st.start)
                return 1;
            else if (this.start < st.start) {
                return -1;
            } else if (this.start == st.start) {
                if (this.end > st.end) {
                    return 1;
                } else if (this.end < st.end) {
                    return -1;
                }
                return 0;
            }
            return 0;
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCase = scan.nextInt();
        for (int test_no = 0; test_no < numberOfTestCase; test_no++) {
            int numberOfWork = scan.nextInt();
            PriorityQueue<ScheduleTime> tasks = new PriorityQueue<>();
            for (int i = 0; i < numberOfWork; i++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                tasks.add(new ScheduleTime(i, start, end));
            }
            String result = getSchedule(numberOfWork, tasks);
            System.out.println("Case #" + (test_no + 1) + ": " + result);
        }
    }

    private static String getSchedule(int N, PriorityQueue<ScheduleTime> tasks) {
        String[] work = new String[N];
        Map<String, Integer> temp = new HashMap<>();
        while (!tasks.isEmpty()) {
            ScheduleTime pair = tasks.poll();
            int start = pair.start;
            if (temp.containsKey("C")) {
                int end = temp.get("C");
                if (start >= end) {
                    temp.put("C", pair.end);
                    work[pair.index] = "C";
                    continue;
                } else if (temp.containsKey("J") && start < temp.get("J")) {
                    return "IMPOSSIBLE";
                }
            } else {
                temp.put("C", pair.end);
                work[pair.index] = "C";
                continue;
            }
            if (temp.containsKey("J")) {
                int end = temp.get("J");
                if (start >= end) {
                    temp.put("J", pair.end);
                    work[pair.index] = "J";
                    continue;
                } else if (temp.containsKey("C") && start < temp.get("C")) {
                    return "IMPOSSIBLE";
                }
            } else {
                temp.put("J", pair.end);
                work[pair.index] = "J";
                continue;
            }

        }
        String result = String.join("", work);
        return result;
    }

}