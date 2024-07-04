import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.print("Case #" + i + ": ");
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner) {
        int numElements = scanner.nextInt();
        int desiredSlices = scanner.nextInt();
        long[] values = new long[numElements];
        Set<Long> possibleSizes = new HashSet<>();

        for (int i = 0; i < numElements; i++) {
            values[i] = scanner.nextLong() * desiredSlices;
            possibleSizes.add(values[i]);
            possibleSizes.add(values[i] / desiredSlices);
        }

        Arrays.sort(values);
        long minCuts = desiredSlices - 1;

        for (long size : possibleSizes) {
            long slices = 0;
            long cuts = 0;
            List<Long> validValues = new ArrayList<>();
            List<Long> invalidValues = new ArrayList<>();

            for (long value : values) {
                if (value >= size && value % size == 0) {
                    validValues.add(value);
                } else {
                    invalidValues.add(value);
                }
            }

            boolean success = false;
            for (long value : validValues) {
                slices += value / size;
                cuts += value / size;
                if (slices == desiredSlices + 1 || slices == desiredSlices) {
                    cuts--;
                    success = true;
                    break;
                }
                if (slices > desiredSlices) {
                    cuts -= (slices - desiredSlices);
                    cuts++;
                    success = true;
                    break;
                }
                cuts--;
            }

            if (!success) {
                for (long value : invalidValues) {
                    slices += value / size;
                    cuts += value / size;
                    if (slices >= desiredSlices) {
                        cuts -= (slices - desiredSlices);
                        success = true;
                        break;
                    }
                }
            }

            if (success) {
                minCuts = Math.min(minCuts, cuts);
            }
        }

        System.out.println(minCuts);
    }
}