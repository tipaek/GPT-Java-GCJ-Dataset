import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = scanner.nextInt();
            List<TimeSlot> originalList = new ArrayList<>();
            List<TimeSlot> sortedList = new ArrayList<>();
            List<String> sortedAssignments = new ArrayList<>();
            List<String> finalAssignments = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                TimeSlot slot = new TimeSlot(scanner.nextInt(), scanner.nextInt());
                originalList.add(slot);
                sortedList.add(slot);
            }
            
            Collections.sort(sortedList);
            int cEnd = 0, jEnd = 0;
            boolean isImpossible = false;
            
            for (TimeSlot slot : sortedList) {
                if (cEnd <= slot.start) {
                    cEnd = slot.end;
                    sortedAssignments.add("C");
                } else if (jEnd <= slot.start) {
                    jEnd = slot.end;
                    sortedAssignments.add("J");
                } else {
                    sortedAssignments.clear();
                    finalAssignments.add("IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }
            
            if (!isImpossible) {
                for (TimeSlot slot : originalList) {
                    finalAssignments.add(sortedAssignments.get(sortedList.indexOf(slot)));
                }
            }
            
            System.out.print("Case #" + testCase + ": ");
            for (String assignment : finalAssignments) {
                System.out.print(assignment);
            }
            System.out.println();
        }
    }

    public static class TimeSlot implements Comparable<TimeSlot> {
        int start;
        int end;

        public TimeSlot(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(TimeSlot other) {
            return Integer.compare(this.start, other.start);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            TimeSlot timeSlot = (TimeSlot) obj;
            return start == timeSlot.start && end == timeSlot.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
}