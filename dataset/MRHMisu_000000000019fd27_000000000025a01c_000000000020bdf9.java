import java.util.*;

public class Solution {

    private static class ScheduleTime implements Comparable<ScheduleTime> {
        String status;
        int time;

        public ScheduleTime(String status, int time) {
            this.status = status;
            this.time = time;
        }

        @Override
        public int compareTo(ScheduleTime st) {
            if (this.time > st.time)
                return 1;
            else if (this.time < st.time) {
                return -1;
            } else if (this.time == st.time) {
                return this.status.compareTo(st.status);
            }
            return 0;
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfTestCase = scan.nextInt();
        for (int test_no = 0; test_no < numberOfTestCase; test_no++) {
            int numberOfWork = scan.nextInt();
            List<ScheduleTime> works = new ArrayList<ScheduleTime>();
            for (int i = 0; i < numberOfWork; i++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                works.add(new ScheduleTime("START", start));
                works.add(new ScheduleTime("END", end));
            }
            Collections.sort(works);
            String result = getSchedule(works);
            System.out.println("Case #" + (test_no + 1) + ": " + result);
        }
    }


    private static String getSchedule(List<ScheduleTime> works) {
        Queue<String> workers = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        for (ScheduleTime work : works) {
            if (work.status.equals("START")) {
                if (workers.contains("C") && workers.contains("J")) {
                    return "IMPOSSIBLE";
                }
                if (!workers.contains("C")) {
                    workers.add("C");
                } else if (!workers.contains("J")) {
                    workers.add("J");
                }
            } else if (work.status.equals("END")) {
                if (!workers.isEmpty())
                    result.append(workers.poll());
            }
        }
        return result.toString();
    }
}