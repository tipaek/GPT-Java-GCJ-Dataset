import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int N = scanner.nextInt();
            int[] startTimes = new int[N];
            int[] endTimes = new int[N];

            for (int i = 0; i < N; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            String result = allocateTasks(N, startTimes, endTimes);
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    private static String allocateTasks(int N, int[] startTimes, int[] endTimes) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        int cIndex = -1;
        int jIndex = -1;

        for (int currentTime = 0; currentTime <= 1440; currentTime++) {
            for (int i = 0; i < N; i++) {
                if (endTimes[i] == currentTime) {
                    if (cIndex == i) {
                        cIndex = -1;
                        count--;
                    } else if (jIndex == i) {
                        jIndex = -1;
                        count--;
                    }
                }

                if (startTimes[i] == currentTime) {
                    if (count < 2) {
                        if (cIndex == -1) {
                            cIndex = i;
                            count++;
                            result.append("C");
                        } else if (jIndex == -1) {
                            jIndex = i;
                            count++;
                            result.append("J");
                        }
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
            }
        }

        return result.toString();
    }
}