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
                
                Shift shift = new Shift(start, end);
                shifts[j] = shift;
                originalShifts[j] = shift;
            }

            boolean isImpossible = false;
            for (int j = 0; j < 24 * 60; j++) {
                if (timeSlots[j] > 2) {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                Arrays.sort(shifts, Comparator.comparingInt(s -> s.start));
                int lastEnd = -1;
                char currentChar = 'J';
                StringBuilder result = new StringBuilder();

                for (int j = 0; j < numShifts; j++) {
                    if (shifts[j].end < lastEnd) {
                        currentChar = currentChar == 'J' ? 'C' : 'J';
                        result.append(currentChar);
                    } else {
                        result.append(currentChar);
                        currentChar = currentChar == 'J' ? 'C' : 'J';
                    }
                    lastEnd = Math.max(lastEnd, shifts[j].end);
                }

                StringBuilder finalResult = new StringBuilder();
                for (int j = 0; j < numShifts; j++) {
                    for (int k = 0; k < numShifts; k++) {
                        if (originalShifts[j].start == shifts[k].start && originalShifts[j].end == shifts[k].end) {
                            finalResult.append(result.charAt(k));
                            break;
                        }
                    }
                }

                System.out.println("Case #" + (t + 1) + ": " + finalResult);
            }
        }
    }

    static class Shift {
        int start;
        int end;

        Shift(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}