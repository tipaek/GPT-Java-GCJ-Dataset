import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            long[] slices = new long[n];

            for (int i = 0; i < n; i++) {
                slices[i] = scanner.nextLong();
            }

            Arrays.sort(slices);

            long currentSlice = slices[0];
            long mostFrequentSlice = slices[0];
            int maxFrequency = 1;
            int currentFrequency = 1;

            for (int i = 1; i < n; i++) {
                if (slices[i] == currentSlice) {
                    currentFrequency++;
                } else {
                    if (currentFrequency > maxFrequency) {
                        mostFrequentSlice = slices[i - 1];
                        maxFrequency = currentFrequency;
                    }
                    currentSlice = slices[i];
                    currentFrequency = 1;
                }
            }

            if (maxFrequency == d) {
                System.out.println("Case #" + testCase + ": " + 0);
            } else {
                if (n == 1) {
                    System.out.println("Case #" + testCase + ": " + 2);
                } else {
                    System.out.println("Case #" + testCase + ": " + 1);
                }
            }
        }
    }
}