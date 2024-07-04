import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             Scanner scanner = new Scanner(reader)) {

            scanner.useLocale(Locale.US);
            int testCases = scanner.nextInt();

            for (int t = 1; t <= testCases; t++) {
                int n = scanner.nextInt();
                int d = scanner.nextInt();

                long[] array = new long[n];
                for (int i = 0; i < n; i++) {
                    array[i] = scanner.nextLong();
                }

                Arrays.sort(array);

                int result = -1;
                int count = 0, maxCount = 0;
                long previous = -1;

                for (long value : array) {
                    if (value == previous) {
                        count++;
                    } else {
                        if (count > maxCount) {
                            maxCount = count;
                        }
                        count = 1; // Reset count to 1 for the new value
                    }
                    previous = value;
                }
                if (count > maxCount) {
                    maxCount = count;
                }

                if (d == 2) {
                    result = maxCount > 1 ? 0 : 1;
                } else if (d == 3) {
                    if (maxCount > 2) {
                        result = 0;
                    } else if (maxCount > 1) {
                        result = 1;
                    } else {
                        result = 2;
                        outerLoop:
                        for (int i = 0; i < n - 1; i++) {
                            for (int j = i + 1; j < n; j++) {
                                if (2 * array[i] == array[j]) {
                                    result = 1;
                                    break outerLoop;
                                }
                            }
                        }
                    }
                }

                System.out.printf("Case #%d: %d%n", t, result);
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}