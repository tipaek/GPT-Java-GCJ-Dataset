import java.util.*;

public class Solution {

    static boolean isAvailable(int[] calendar, int start, int end) {
        for (int i = start; i < end; i++) {
            if (calendar[i] == 1) {
                return false;
            }
        }
        return true;
    }

    static void markCalendar(int[] calendar, int start, int end) {
        for (int i = start; i < end; i++) {
            calendar[i] = 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int[] cameronCalendar = new int[1440];
            int[] jamieCalendar = new int[1440];
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;
            int eventsCount = scanner.nextInt();
            Map<Integer, int[]> events = new HashMap<>();
            Map<Integer, String> assignments = new LinkedHashMap<>();

            for (int i = 0; i < eventsCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events.put(i, new int[]{start, end});
                assignments.put(i, "X");
            }

            List<Map.Entry<Integer, int[]>> sortedEvents = new ArrayList<>(events.entrySet());
            sortedEvents.sort((e1, e2) -> {
                int[] times1 = e1.getValue();
                int[] times2 = e2.getValue();
                if (times1[0] == times2[0]) {
                    return Integer.compare(times1[1], times2[1]);
                }
                return Integer.compare(times1[0], times2[0]);
            });

            for (Map.Entry<Integer, int[]> entry : sortedEvents) {
                int eventID = entry.getKey();
                int[] times = entry.getValue();
                int start = times[0];
                int end = times[1];

                if (isAvailable(cameronCalendar, start, end)) {
                    markCalendar(cameronCalendar, start, end);
                    assignments.put(eventID, "C");
                } else if (isAvailable(jamieCalendar, start, end)) {
                    markCalendar(jamieCalendar, start, end);
                    assignments.put(eventID, "J");
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                schedule.append("IMPOSSIBLE");
            } else {
                for (String assignment : assignments.values()) {
                    schedule.append(assignment);
                }
            }

            System.out.printf("Case #%d: %s\n", t + 1, schedule.toString());
        }

        scanner.close();
    }
}