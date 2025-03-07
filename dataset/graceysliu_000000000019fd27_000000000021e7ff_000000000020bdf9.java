import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int numTests = in.nextInt();
        in.nextLine();

        for (int n = 0; n < numTests; n++) {
            int numEvents = in.nextInt();
            Map<TimeSlot, Character> timeMap = new TreeMap<TimeSlot, Character>();
            int[] times = new int[1441]; // scheduled overlaps
            boolean valid = true; // if not impossible
            TimeSlot[] order = new TimeSlot[numEvents]; // final order

            for (int e = 0; e < numEvents; e++) {
                int start = in.nextInt();
                int end = in.nextInt();
                TimeSlot current = new TimeSlot(start, end, e);

                // for final order
                order[e] = current;

                // for string building, temp 0
                timeMap.put(current, '0');

                // marking start and end
                times[start]++;
                times[end]--;
            }

            // adding up all values
            for (int i = 1; i < times.length; i++) {
                times[i] += times[i - 1];
                if (times[i] > 2) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                // updating values
                boolean cameron = true; // default is cameron
                int prevFreq = 1;
                TimeSlot prev = new TimeSlot(0, 0, 0);

                for (TimeSlot t : timeMap.keySet()) {
                    int currFreq = times[t.start];
                    if (currFreq == 2) {
                        // conflict!
                        if (prevFreq == 1 || t.start < prev.end) {
                            cameron = !cameron;
                        }
                    }

                    if (cameron) {
                        timeMap.put(t, 'C');
                    }
                    else {
                        timeMap.put(t, 'J');
                    }

                    prev = t;
                    prevFreq = currFreq;
                }

                // rearranging
                StringBuilder result = new StringBuilder();
                for (TimeSlot i : order) {
                    result.append(timeMap.get(i));
                }

                System.out.println("Case #" + (n + 1) + ": " + result);
            }
            else {
                System.out.println("Case #" + (n + 1) + ": IMPOSSIBLE");
            }
        }
    }

    static class TimeSlot implements Comparable {
        private int start;
        private int end;
        private int offset; // so we can have two times of the same interval!

        public TimeSlot(int s, int e, int o) {
            this.start = s;
            this.end = e;
            this.offset = o;
        }

        @Override
        public int compareTo(Object o) {
            // TODO Auto-generated method stub
            TimeSlot other = (TimeSlot) o;
            int oStart = other.start;
            if (this.start == oStart) {
                return this.end - other.end;
            }
            else {
                return this.start - oStart;
            }
        }

        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }
}