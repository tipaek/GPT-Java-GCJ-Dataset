
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
                List<TimeSlot> noSort = new ArrayList<>(timeSlotList);
                Collections.sort(timeSlotList, new TimeSlotByDuration());

                StringBuilder buffer = new StringBuilder(timeSlotCount);
                for (int j = 0; j < timeSlotCount; j++) {
                    buffer.append('X');
                }
                buffer.setCharAt(timeSlotList.get(0).sequence, 'C');
                int takenCount = 1;
                boolean impossible = false;
                boolean modeJ = false;
                while(timeSlotCount > takenCount) {
                    TimeSlot currentSlot = timeSlotList.get(takenCount);

                    /// Check "C"
                    if (!modeJ) {
                        boolean isOverlapped = false;
                        for (int k = 0; k < buffer.length(); k++) {
                            char pic = buffer.charAt(k);
                            if (pic == 'C') {
                                if (currentSlot.isOverlapped(noSort.get(k))) {
                                    isOverlapped = true;
                                    break;
                                }
                            }
                        }

                        if (!isOverlapped) {
                            buffer.setCharAt(currentSlot.sequence, 'C');
                            takenCount++;
                            continue;
                        }
                    }


                    /// Check "J"
                    boolean isOverlapped = false;
                    for (int k = 0; k<buffer.length(); k++) {
                        char pic = buffer.charAt(k);
                        if (pic == 'J') {
                            if (currentSlot.isOverlapped(noSort.get(k))) {
                                isOverlapped = true;
                                break;
                            }
                        }
                    }

                    if (!isOverlapped) {
                        buffer.setCharAt(currentSlot.sequence, 'J');
                        takenCount++;
                        continue;
                    }
                    
                    impossible = true;
                    break;
                }

                if (impossible) {
                    output = IMPOSSIBLE;
                } else {
                    output = buffer.toString();
                }
            } else {
                output = IMPOSSIBLE;
            }
            System.out.println("Case #" + i + ": " + output);
        }
    }

    public static String partner(final List<TimeSlot> timeSlotList, final List<TimeSlot> noSortList, final StringBuilder taken, int takenCount) {
        if (timeSlotList.size() == takenCount) {
            return taken.toString();
        } else if (timeSlotList.size() < takenCount) {
            /// Error condition!
            return taken.toString();
        }

        TimeSlot currentSlot = timeSlotList.get(takenCount);

        /// Check "C"
        boolean isOverlapped = false;
        for (int i = 0; i<taken.length(); i++) {
            char pic = taken.charAt(i);
            if (pic == 'C') {
                if (currentSlot.isOverlapped(noSortList.get(i))) {
                    isOverlapped = true;
                    break;
                }
            }
        }

        if (!isOverlapped) {
            taken.setCharAt(currentSlot.sequence, 'C');
            String result = partner(timeSlotList, noSortList, taken, takenCount + 1);
            if (!IMPOSSIBLE.equals(result)) {
                return result;
            }
        }

        /// Reset
        for (int i=0; i<takenCount; i++) {
            int position = timeSlotList.get(i).sequence;
            char prevAssigned = taken.charAt(position);
            switch (prevAssigned) {
                case 'C' : taken.setCharAt(position,'c'); break;
                case 'J' : taken.setCharAt(position,'j'); break;
                default:
            }
        }

        for (int i=0; i< taken.length(); i++) {
            char prevAssigned = taken.charAt(i);
            switch (prevAssigned) {
                case 'c' : taken.setCharAt(i,'C'); break;
                case 'j' : taken.setCharAt(i,'J'); break;
                default: taken.setCharAt(i, 'X');
            }
        }

        /// Check "J"
        isOverlapped = false;
        for (int i = 0; i<taken.length(); i++) {
            char pic = taken.charAt(i);
            if (pic == 'J') {
                if (currentSlot.isOverlapped(noSortList.get(i))) {
                    isOverlapped = true;
                    break;
                }
            }
        }

        if (!isOverlapped) {
            taken.setCharAt(currentSlot.sequence, 'J');
            String result = partner(timeSlotList, noSortList, taken, takenCount + 1);
            if (!IMPOSSIBLE.equals(result)) {
                return result;
            }
        }

        return IMPOSSIBLE;
    }

}