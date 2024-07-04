import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class TimeSlot implements Comparable<TimeSlot> {
        int start;
        int end;
        String original;

        TimeSlot(int start, int end, String original) {
            this.start = start;
            this.end = end;
            this.original = original;
        }

        @Override
        public int compareTo(TimeSlot other) {
            return Integer.compare(this.end, other.end);
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfTests = Integer.parseInt(reader.readLine().trim());

            for (int testIndex = 1; testIndex <= numberOfTests; testIndex++) {
                int numberOfTimeSlots = Integer.parseInt(reader.readLine().trim());
                List<TimeSlot> timeSlots = new ArrayList<>();

                for (int i = 0; i < numberOfTimeSlots; i++) {
                    String time = reader.readLine().trim();
                    String[] parts = time.split(" ");
                    int start = Integer.parseInt(parts[0]);
                    int end = Integer.parseInt(parts[1]);
                    timeSlots.add(new TimeSlot(start, end, time));
                }

                assignSlots(testIndex, timeSlots);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void assignSlots(int testNumber, List<TimeSlot> timeSlots) {
        Map<String, String> assignmentMap = new LinkedHashMap<>();
        for (TimeSlot slot : timeSlots) {
            assignmentMap.put(slot.original, "");
        }

        Collections.sort(timeSlots);

        StringBuilder result = new StringBuilder();
        int endC = -1, endJ = -1;

        for (TimeSlot slot : timeSlots) {
            if (endJ <= slot.start) {
                endJ = slot.end;
                assignmentMap.put(slot.original, "J");
            } else if (endC <= slot.start) {
                endC = slot.end;
                assignmentMap.put(slot.original, "C");
            } else {
                System.out.println("Case #" + testNumber + ": IMPOSSIBLE");
                return;
            }
        }

        for (String value : assignmentMap.values()) {
            result.append(value);
        }

        System.out.println("Case #" + testNumber + ": " + result.toString());
    }
}