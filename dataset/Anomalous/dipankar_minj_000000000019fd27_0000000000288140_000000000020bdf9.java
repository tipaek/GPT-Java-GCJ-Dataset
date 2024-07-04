import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] indices = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
                indices[i] = i;
            }

            // Bubble sort based on start times
            for (int i = 0; i < n - 1; i++) {
                boolean swapped = false;
                for (int j = 0; j < n - i - 1; j++) {
                    if (startTimes[j] > startTimes[j + 1]) {
                        swapped = true;
                        swap(startTimes, j, j + 1);
                        swap(endTimes, j, j + 1);
                        swap(indices, j, j + 1);
                    }
                }
                if (!swapped) break;
            }

            char[] schedule = new char[n];
            boolean possible = true;
            int cameronEnd = 0;
            int jamieEnd = 0;

            for (int i = 0; i < n; i++) {
                if (startTimes[i] >= cameronEnd) {
                    schedule[indices[i]] = 'C';
                    cameronEnd = endTimes[i];
                } else if (startTimes[i] >= jamieEnd) {
                    schedule[indices[i]] = 'J';
                    jamieEnd = endTimes[i];
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.print("Case #" + caseNum + ": ");
                for (char c : schedule) System.out.print(c);
                System.out.println();
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}