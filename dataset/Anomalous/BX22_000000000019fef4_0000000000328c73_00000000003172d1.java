import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int slices = scanner.nextInt();
            int diners = scanner.nextInt();
            long[] sizes = new long[slices];

            for (int j = 0; j < slices; j++) {
                sizes[j] = Long.parseLong(scanner.next());
            }

            int result = findOptimalCuts(slices, diners, sizes);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static int findOptimalCuts(int slices, int diners, long[] sizes) {
        long gcdValue = computeGCD(sizes, slices);
        List<Long> divisibleSizes = new ArrayList<>();
        int remainingDiners = diners;

        for (long size : sizes) {
            if (gcdValue == size) {
                remainingDiners--;
            } else if (size % gcdValue == 0) {
                divisibleSizes.add(size / gcdValue);
            }
        }

        Collections.sort(divisibleSizes);
        int cuts = calculateCuts(divisibleSizes, remainingDiners);

        for (long size : sizes) {
            List<Long> tempDivisibleSizes = new ArrayList<>();
            remainingDiners = diners;
            int tempCuts = 0;

            for (long otherSize : sizes) {
                if (size == otherSize) {
                    remainingDiners--;
                } else if (otherSize % size == 0) {
                    tempDivisibleSizes.add(otherSize / size);
                }
            }

            Collections.sort(tempDivisibleSizes);
            tempCuts = calculateCuts(tempDivisibleSizes, remainingDiners);

            if (tempCuts < cuts) {
                cuts = tempCuts;
            }
        }

        return cuts;
    }

    private static int calculateCuts(List<Long> divisibleSizes, int remainingDiners) {
        int cuts = 0;
        int index = 0;

        while (index < divisibleSizes.size() && (remainingDiners - divisibleSizes.get(index) >= 0)) {
            remainingDiners -= divisibleSizes.get(index);
            cuts += divisibleSizes.get(index) - 1;
            index++;
        }

        cuts += remainingDiners;
        return cuts;
    }

    private static long computeGCD(long[] arr, int length) {
        long result = arr[0];

        for (int i = 1; i < length; i++) {
            result = gcd(arr[i], result);

            if (result == 1) {
                return 1;
            }
        }

        return result;
    }

    private static long gcd(long a, long b) {
        return (a == 0) ? b : gcd(b % a, a);
    }
}