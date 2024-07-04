
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static String IMPOSSIBLE = "IMPOSSIBLE";

    public static class TimeSlot {
        public int sequence;
        public int start;
        public int end;
        public int duration;
        public TimeSlot(int sequence, int start, int end) {
            this.sequence = sequence;
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

    public static class TimeSlotByStart implements Comparator<TimeSlot>
    {
        // Used for sorting in ascending order of
        // roll number
        public int compare(TimeSlot a, TimeSlot b)
        {
            if (a.start > b.start) {
                return 1;
            } else if (a.start < b.start) {
                return -1;
            }

            if (a.duration > b.duration) {
                return 1;
            } else if (a.duration < b.duration) {
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

            boolean isFirst = true;
            int start = 0;
            int end = 0;
            int totalDuration = 0;
            for (int row = 1; row <= timeSlotCount; row++) {
                int first = in.nextInt();
                int second = in.nextInt();
                TimeSlot slot= new TimeSlot(row-1, first, second);
                timeSlotList.add(slot);

                if (isFirst) {
                    start = first;
                    end = second;
                    totalDuration = slot.duration;
                } else {
                    if (first < start) {
                        start = first;
                    }
                    if (end > second) {
                        end = second;
                    }
                    totalDuration += slot.duration;
                }
            }

            final String output;
            if (totalDuration <= (end - start) * 2) {
                Collections.sort(timeSlotList, new TimeSlotByStart());

                StringBuilder sb = new StringBuilder(timeSlotCount);

                sb.append('C');
                TimeSlot lastSlotC = timeSlotList.get(0);
                TimeSlot lastSlotJ = null;

                boolean impossible = false;
                for (int taken=1; taken<timeSlotCount; taken++) {
                    TimeSlot currentSlot = timeSlotList.get(taken);

                    if (!lastSlotC.isOverlapped(currentSlot)) {
                        sb.append('C');
                        lastSlotC = currentSlot;
                    } else if (null == lastSlotJ) {
                        sb.append('J');
                        lastSlotJ = currentSlot;
                    } else if (!lastSlotJ.isOverlapped(currentSlot)) {
                        sb.append('J');
                        lastSlotJ = currentSlot;
                    } else {
                        impossible = true;
                        break;
                    }
                }

                if (impossible) {
                    output = IMPOSSIBLE;
                } else {
                    StringBuilder reOrder = new StringBuilder(sb.toString());
                    for (int c = 0; c<timeSlotCount; c++) {
                        char val = sb.charAt(c);
                        reOrder.setCharAt(timeSlotList.get(c).sequence, val);
                    }
                    output = reOrder.toString();
                }
            } else {
                output = IMPOSSIBLE;
            }
            System.out.println("Case #" + i + ": " + output);
        }
    }
}
