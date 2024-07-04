import java.io.*;
import java.util.*;

public class ParentingReturn {

    private static class TimeSlot {
        private int startTime;
        private int endTime;

        TimeSlot(int start, int end) {
            this.startTime = start;
            this.endTime = end;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }

    private static class TimeSlotComparator implements Comparator<TimeSlot> {
        @Override
        public int compare(TimeSlot t1, TimeSlot t2) {
            return Integer.compare(t1.getStartTime(), t2.getStartTime());
        }
    }

    private static String assignTasks(List<Integer> times, int taskCount) {
        StringBuilder result = new StringBuilder();

        List<TimeSlot> slots = new ArrayList<>();
        for (int i = 0; i < times.size(); i += 2) {
            slots.add(new TimeSlot(times.get(i), times.get(i + 1)));
        }
        slots.sort(new TimeSlotComparator());

        int cameronEnd = 0;
        int jamieEnd = 0;

        for (TimeSlot slot : slots) {
            if (slot.getStartTime() >= cameronEnd) {
                cameronEnd = slot.getEndTime();
                result.append("C");
            } else if (slot.getStartTime() >= jamieEnd) {
                jamieEnd = slot.getEndTime();
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)))) {
            int testCases = scanner.nextInt();
            for (int testCase = 1; testCase <= testCases; testCase++) {
                int taskCount = scanner.nextInt();
                List<Integer> times = new ArrayList<>();
                for (int i = 0; i < taskCount; i++) {
                    times.add(scanner.nextInt());
                    times.add(scanner.nextInt());
                }
                String result = assignTasks(times, taskCount);
                System.out.println("Case #" + testCase + ": " + result);
            }
        }
    }
}