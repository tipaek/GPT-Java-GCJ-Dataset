import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static String IMPOSSIBLE = "IMPOSSIBLE";

    public static class TimeSlot {
        public int start;
        public int end;
        public int duration;
        public TimeSlot(int start, int end) {
            this.start = start;
            this.end = end;
            this.duration = end - start;
        }

        public boolean isOverlapped(TimeSlot b) {
            if (end <= b.start) {
                return false;
            }
            if (start >= b.end) {
                return false;
            }

            return true;
        }
    }

    public static class TimeSlotByDuration implements Comparator<TimeSlot>
    {
        // Used for sorting in ascending order of
        // roll number
        public int compare(TimeSlot a, TimeSlot b)
        {
            if (a.duration > b.duration) {
                return 1;
            } else if (a.duration < b.duration) {
                return -1;
            }

            if (a.start > b.start) {
                return 1;
            } else if (a.start < b.start) {
                return -1;
            }

            return a.end - b.end;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int timeSlotCount = in.nextInt();

            List<TimeSlot> timeSlotList = new ArrayList<>(timeSlotCount);

            for (int row = 1; row <= timeSlotCount; row++) {
                int first = in.nextInt();
                int second = in.nextInt();
                TimeSlot slot= new TimeSlot(first, second);
                timeSlotList.add(slot);
            }

            //Collections.sort(timeSlotList, new TimeSlotByDuration());

            String output = partner(timeSlotList, "C");
            System.out.println("Case #" + i + ": " + output);
        }
    }

    public static String partner(final List<TimeSlot> timeSlotList, final String taken) {
        if (timeSlotList.size() == taken.length()) {
            return taken;
        } else if (timeSlotList.size() < taken.length()) {
            /// Error condition!
            return taken;
        }

        int assigned = taken.length();
        TimeSlot currentSlot = timeSlotList.get(assigned);

        /// Check "C"
        boolean isOverlapped = false;
        for (int i = 0; i<taken.length(); i++) {
            char pic = taken.charAt(i);
            if (pic == 'C') {
                if (currentSlot.isOverlapped(timeSlotList.get(i))) {
                    isOverlapped = true;
                    break;
                }
            }
        }

        if (!isOverlapped) {
            String result = partner(timeSlotList, taken + 'C');
            if (!IMPOSSIBLE.equals(result)) {
                return result;
            }
        }

        /// Check "J"
        isOverlapped = false;
        for (int i = 0; i<taken.length(); i++) {
            char pic = taken.charAt(i);
            if (pic == 'J') {
                if (currentSlot.isOverlapped(timeSlotList.get(i))) {
                    isOverlapped = true;
                    break;
                }
            }
        }

        if (!isOverlapped) {
            String result = partner(timeSlotList, taken + 'J');
            if (!IMPOSSIBLE.equals(result)) {
                return result;
            }
        }

        return IMPOSSIBLE;
    }

}
