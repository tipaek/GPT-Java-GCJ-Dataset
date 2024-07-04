import java.io.ByteArrayInputStream;
import java.util.*;
import java.util.stream.Collectors;

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

        List<Schedule> sortedSchedules = Arrays.stream(schedules)
                .sorted(Comparator.comparingInt(s -> s.start)).collect(Collectors.toList());

        for (Schedule s : sortedSchedules) {
            if (ok2Insert(listC, s)) {
                listC.add(s);
            } else if (ok2Insert(listJ, s)) {
                listJ.add(s);
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < schedules.length; i++) {
            if (listC.contains(schedules[i])) {
                sb.append("C");
            } else {
                sb.append("J");
            }
        }

        return sb.toString();
    }

    private static boolean ok2Insert(List<Schedule> list, Schedule checkSchedule) {
        for (Schedule schedule : list) {
            if (schedule.isOverlap(checkSchedule)){
                return false;
            }
        }
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
