import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for(int i = 1; i <= testCases; i++) {
            System.out.print("Case #" + i + ": ");
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner) {
        int numItems = scanner.nextInt();
        int targetSlices = scanner.nextInt();
        long[] values = new long[numItems];
        Set<Long> possibleSizes = new HashSet<>();

        for(int i = 0; i < numItems; i++) {
            values[i] = scanner.nextLong() * targetSlices;
            possibleSizes.add(values[i]);
            possibleSizes.add(values[i] / targetSlices);
        }

        Arrays.sort(values);
        long minCuts = targetSlices - 1;

        for (long size : possibleSizes) {
            long slices = 0;
            long cuts = 0;
            List<Long> goodItems = new ArrayList<>();
            List<Long> badItems = new ArrayList<>();

            for (long value : values) {
                if (value >= size && value % size == 0) {
                    goodItems.add(value);
                } else {
                    badItems.add(value);
                }
            }

            boolean success = false;

            for (long goodItem : goodItems) {
                slices += goodItem / size;
                cuts += goodItem / size;
                if (slices == targetSlices || slices == targetSlices + 1) {
                    cuts--;
                    success = true;
                    break;
                }
                if (slices > targetSlices) {
                    cuts -= (slices - targetSlices);
                    success = true;
                    break;
                }
                cuts--;
            }

            if (!success) {
                for (long badItem : badItems) {
                    slices += badItem / size;
                    cuts += badItem / size;
                    if (slices >= targetSlices) {
                        cuts -= (slices - targetSlices);
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