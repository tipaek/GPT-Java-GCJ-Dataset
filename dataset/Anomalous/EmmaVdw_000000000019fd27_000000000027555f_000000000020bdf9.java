import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            scanner.nextLine();

            boolean impossible = false;
            StringBuilder result = new StringBuilder();
            if (n > 0) {
                int[] startTimes = new int[n];
                int[] endTimes = new int[n];
                int[] indices = new int[n];
                for (int j = 0; j < n; ++j) {
                    indices[j] = j;
                    startTimes[j] = scanner.nextInt();
                    endTimes[j] = scanner.nextInt();
                }

                // Sort intervals by start time
                for (int j = 0; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (startTimes[j] > startTimes[k]) {
                            swap(startTimes, j, k);
                            swap(endTimes, j, k);
                            swap(indices, j, k);
                        }
                    }
                }

                int freeC = 0;
                int freeJ = 0;
                for (int j = 0; j < n; ++j) {
                    if (startTimes[j] < freeC && startTimes[j] < freeJ) {
                        impossible = true;
                        break;
                    }
                    if (startTimes[j] >= freeC) {
                        result.append('C');
                        freeC = endTimes[j];
                    } else {
                        result.append('J');
                        freeJ = endTimes[j];
                    }
                }

                if (!impossible) {
                    char[] finalResult = new char[n];
                    for (int j = 0; j < n; ++j) {
                        finalResult[indices[j]] = result.charAt(j);
                    }
                    System.out.println("Case #" + i + ": " + new String(finalResult));
                } else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}