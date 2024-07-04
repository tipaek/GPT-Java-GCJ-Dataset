import java.io.ByteArrayInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static String PROBLEM = "4\n" +
            "3\n" +
            "360 480\n" +
            "420 540\n" +
            "600 660\n" +
            "3\n" +
            "0 1440\n" +
            "1 3\n" +
            "2 4\n" +
            "5\n" +
            "99 150\n" +
            "1 100\n" +
            "100 301\n" +
            "2 5\n" +
            "150 250\n" +
            "2\n" +
            "0 720\n" +
            "720 1440";

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(new ByteArrayInputStream(PROBLEM.getBytes()));
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        Schedule[][] problems = new Schedule[T][];

        for (int i = 0; i < problems.length; i++) {
            problems[i] = getProblem(scanner);
        }

        for (int i = 0; i < T; i++) {
            System.out.print("Case #" + (i+1) + ": ");
            System.out.println(getPattern(problems[i]));
        }

    }

    private static String getPattern(Schedule[] schedules) {
        List<Schedule> listC = new LinkedList<>();
        List<Schedule> listJ = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        for (Schedule s : schedules) {
            if (insertWhenAvailable(listC, s)) {
                sb.append("C");
            } else if (insertWhenAvailable(listJ, s)) {
                sb.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return sb.toString();
    }

    private static boolean insertWhenAvailable(List<Schedule> list, Schedule checkSchedule) {
        for (Schedule schedule : list) {
            if (schedule.isOverlap(checkSchedule)){
                return false;
            }
        }
        list.add(checkSchedule);
        return true;
    }



    private static Schedule[] getProblem(Scanner scanner) {
        int N = scanner.nextInt();
        scanner.nextLine();
        Schedule[] schedules = new Schedule[N];
        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split(" ");
            Integer start = Integer.valueOf(input[0]);
            Integer end = Integer.valueOf(input[1]);
            schedules[i] = new Schedule(start, end);
        }
        return schedules;
    }

    private static class Schedule {
        private int start;

        private int end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public boolean isWithin(int time) {
            return start < time && time < end;
        }

        public boolean isOverlap(Schedule check) {
            return this.isWithin(check.start) || check.isWithin(this.start);
        }
    }
}
