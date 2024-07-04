import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            long[] slices = new long[n];

            for (int j = 0; j < n; j++) {
                slices[j] = scanner.nextLong();
            }

            Arrays.sort(slices);
            long currentSlice = slices[0];
            long bestSlice = slices[0];
            int maxCount = 1;
            int currentCount = 1;

            for (int k = 1; k < n; k++) {
                if (slices[k] == currentSlice) {
                    currentCount++;
                } else {
                    if (currentCount > maxCount) {
                        bestSlice = currentSlice;
                        maxCount = currentCount;
                    }
                    currentSlice = slices[k];
                    currentCount = 1;
                }
            }

            if (maxCount == d) {
                System.out.println("Case #" + i + ": " + 0);
            } else if (d == 2) {
                System.out.println("Case #" + i + ": " + 1);
            } else {
                if (maxCount == 2) {
                    System.out.println("Case #" + i + ": " + 1);
                } else {
                    boolean found = false;
                    for (int k = n - 1; k >= 0; k--) {
                        if (slices[k] % 2 == 0) {
                            double halfSlice = slices[k] / 2;
                            for (int l = 0; l < k; l++) {
                                if (halfSlice == slices[l]) {
                                    System.out.println("Case #" + i + ": " + 1);
                                    found = true;
                                    break;
                                }
                            }
                        }
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Case #" + i + ": " + 2);
                    }
                }
            }
        }
    }
}