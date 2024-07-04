import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int testCase = 1; testCase <= testCases; testCase++) {
                int n = scanner.nextInt();

                int[] startTimes = new int[n];
                int[] endTimes = new int[n];

                for (int i = 0; i < n; i++) {
                    startTimes[i] = scanner.nextInt();
                    endTimes[i] = scanner.nextInt();
                }

                Arrays.sort(startTimes);
                Arrays.sort(endTimes);

                boolean impossible = false;
                for (int i = 0; i < endTimes.length - 2 && !impossible; i++) {
                    if (endTimes[i] > startTimes[i + 2]) {
                        impossible = true;
                    }
                    if ((startTimes[i] == startTimes[i + 1] && startTimes[i] == startTimes[i + 2])
                            || (endTimes[i] == endTimes[i + 1] && endTimes[i] == endTimes[i + 2])) {
                        impossible = true;
                    }
                }

                StringBuilder result = new StringBuilder();
                if (impossible) {
                    result.append("IMPOSSIBLE");
                } else {
                    result.append(String.join("", Collections.nCopies(n / 2, "CJ")));
                    if (n % 2 == 1) {
                        result.append("C");
                    }
                }

                System.out.printf("Case #%d: %s%n", testCase, result.toString());
            }
        }
    }
}