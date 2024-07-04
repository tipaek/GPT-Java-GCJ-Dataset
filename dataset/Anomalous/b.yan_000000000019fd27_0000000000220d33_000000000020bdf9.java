import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int numShifts = scanner.nextInt();
            Shift[] shifts = new Shift[numShifts];
            Shift[] originalShifts = new Shift[numShifts];
            int[] timeSlots = new int[24 * 60 + 1];
            
            for (int j = 0; j < numShifts; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                for (int k = start; k < end; k++) {
                    timeSlots[k]++;
                }
                
                Shift shift = new Shift(start, end, j);
                shifts[j] = shift;
                originalShifts[j] = shift;
            }
            
            boolean impossible = false;
            for (int j = 0; j <= 24 * 60; j++) {
                if (timeSlots[j] > 2) {
                    impossible = true;
                    break;
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                Arrays.sort(shifts, Comparator.comparingInt(s -> s.start));
                int lastEnd = -1;
                char currentChar = 'J';
                StringBuilder schedule = new StringBuilder();
                
                for (Shift shift : shifts) {
                    if (shift.end <= lastEnd) {
                        currentChar = (currentChar == 'J') ? 'C' : 'J';
                    }
                    schedule.append(currentChar);
                    lastEnd = Math.max(lastEnd, shift.end);
                }
                
                StringBuilder result = new StringBuilder();
                for (Shift originalShift : originalShifts) {
                    for (int k = 0; k < numShifts; k++) {
                        if (originalShift.equals(shifts[k])) {
                            result.append(schedule.charAt(k));
                            break;
                        }
                    }
                }
                
                System.out.println("Case #" + (t + 1) + ": " + result.toString());
            }
        }
    }

    static class Shift {
        int start;
        int end;
        int number;

        Shift(int start, int end, int number) {
            this.start = start;
            this.end = end;
            this.number = number;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Shift shift = (Shift) obj;
            return start == shift.start && end == shift.end && number == shift.number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end, number);
        }
    }
}