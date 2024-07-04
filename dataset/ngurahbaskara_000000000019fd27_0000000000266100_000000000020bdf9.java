import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        Schedule[][] problems = new Schedule[T][];

        for (int i = 0; i < problems.length; i++) {
            problems[i] = getProblem(scanner);
        }

        for (int i = 0; i < T; i++) {
            System.out.print("Case #" + (i+1) + ": ");
            solve(problems[i]);
            System.out.println();
        }

    }

    private static void solve(Schedule[] schedules) {
        String pattern = getPattern(schedules);
        System.out.print(pattern);
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
            if ((checkSchedule.start < schedule.end && checkSchedule.start > schedule.start)
                    || (schedule.start < checkSchedule.end && schedule.start > checkSchedule.start)) {
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
    }
}
