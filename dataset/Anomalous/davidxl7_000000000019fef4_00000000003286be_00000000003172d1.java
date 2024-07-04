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

    private static void solve(Scanner scanner) {
        int N = scanner.nextInt();
        int D = scanner.nextInt();
        long[] values = new long[N];
        Set<Long> possibleSizes = new HashSet<>();

        for (int i = 0; i < N; i++) {
            values[i] = scanner.nextLong();
            possibleSizes.add(values[i]);
            values[i] *= D;
            possibleSizes.add(values[i]);
        }

        Arrays.sort(values);
        long minCuts = D - 1;

        for (long size : possibleSizes) {
            long slices = 0;
            long cuts = 0;
            List<Long> goodValues = new ArrayList<>();
            List<Long> badValues = new ArrayList<>();

            for (long value : values) {
                if (value >= size && value % size == 0) {
                    goodValues.add(value);
                } else {
                    badValues.add(value);
                }
            }

            boolean success = false;

            for (long good : goodValues) {
                slices += (good / size);
                cuts += (good / size);
                if (slices == D || slices == D + 1) {
                    cuts--;
                    success = true;
                    break;
                } else if (slices > D) {
                    cuts -= (slices - D);
                    success = true;
                    break;
                }
                cuts--;
            }

            if (!success) {
                for (long bad : badValues) {
                    slices += (bad / size);
                    cuts += (bad / size);
                    if (slices >= D) {
                        cuts -= (slices - D);
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