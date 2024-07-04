import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int q = 0; q < testCases; q++) {
            int n = Integer.parseInt(reader.readLine());
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] originalStartTimes = new int[n];
            int[] originalEndTimes = new int[n];
            char[] assignments = new char[n];

            for (int i = 0; i < n; i++) {
                String[] times = reader.readLine().split("\\s+");
                startTimes[i] = Integer.parseInt(times[0]);
                endTimes[i] = Integer.parseInt(times[1]);
                originalStartTimes[i] = startTimes[i];
                originalEndTimes[i] = endTimes[i];
                assignments[i] = '\0';
            }

            int[][] sortedTimes = sort(startTimes, endTimes);
            startTimes = sortedTimes[0];
            endTimes = sortedTimes[1];

            int[] assigned = new int[n];
            String result = "";
            int cEnd = -1, jEnd = -1;
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                if (startTimes[i] >= cEnd) {
                    cEnd = endTimes[i];
                    for (int j = 0; j < n; j++) {
                        if (originalStartTimes[j] == startTimes[i] && originalEndTimes[j] == endTimes[i]) {
                            assigned[j] = 0;
                            break;
                        }
                    }
                } else if (startTimes[i] >= jEnd) {
                    jEnd = endTimes[i];
                    for (int j = 0; j < n; j++) {
                        if (originalStartTimes[j] == startTimes[i] && originalEndTimes[j] == endTimes[i]) {
                            assigned[j] = 1;
                            break;
                        }
                    }
                } else {
                    impossible = true;
                    break;
                }
            }

            for (int i = 0; i < n; i++) {
                result += assigned[i] == 0 ? "C" : "J";
            }

            if (impossible) {
                System.out.println("Case #" + (q + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (q + 1) + ": " + result);
            }
        }
    }

    public static int[][] sort(int[] arr, int[] t) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int tempT = t[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                    t[j] = t[j - gap];
                }
                arr[j] = temp;
                t[j] = tempT;
            }
        }
        return new int[][]{arr, t};
    }
}