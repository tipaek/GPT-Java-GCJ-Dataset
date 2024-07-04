import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner = new Scanner(reader)
        ) {
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
                int currentCount = 0, maxCount = 0;

                for (int i = 0; i < n; i++) {
                    if (i == n - 1 || array[i] != array[i + 1]) {
                        if (currentCount > maxCount) maxCount = currentCount;
                        currentCount = 0;
                    } else {
                        currentCount++;
                    }
                }

                if (d == 2) {
                    result = (maxCount > 0) ? 0 : 1;
                } else if (d == 3) {
                    if (maxCount > 1) {
                        result = 0;
                    } else if (maxCount > 0) {
                        result = 1;
                    } else {
                        result = 2;
                        for (int i = 0; i < n - 1; i++) {
                            for (int j = i + 1; j < n; j++) {
                                if (2 * array[i] == array[j]) {
                                    result = 1;
                                    i = n; // Break outer loop
                                    break; // Break inner loop
                                }
                            }
                        }
                    }
                }

                System.out.printf("Case #%d: %d%n", t, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}