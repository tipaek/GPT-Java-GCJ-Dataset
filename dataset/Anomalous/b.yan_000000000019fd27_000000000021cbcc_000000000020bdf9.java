import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int numShifts = scanner.nextInt();
            Shift[] shifts = new Shift[numShifts];
            int[] timeSlots = new int[24 * 60 + 1];

            for (int j = 0; j < numShifts; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                for (int k = start; k < end; k++) {
                    timeSlots[k]++;
                }
                shifts[j] = new Shift(start, end);
            }

            boolean impossible = false;
            for (int j = 0; j < 24 * 60; j++) {
                if (timeSlots[j] > 2) {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                Arrays.sort(shifts, Comparator.comparingInt(shift -> shift.start));
                StringBuilder result = new StringBuilder();
                int lastEndJ = -1, lastEndC = -1;

                for (Shift shift : shifts) {
                    if (shift.start >= lastEndJ) {
                        result.append('J');
                        lastEndJ = shift.end;
                    } else if (shift.start >= lastEndC) {
                        result.append('C');
                        lastEndC = shift.end;
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
                System.out.println("Case #" + (t + 1) + ": " + result);
            }
        }
    }

    static class Shift {
        int start, end;

        Shift(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}