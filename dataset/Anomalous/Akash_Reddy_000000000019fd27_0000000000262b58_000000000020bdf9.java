import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        int caseNumber = 1;

        while (T > 0) {
            int n = Integer.parseInt(reader.readLine());
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] originalStartTimes = new int[n];
            int[] originalEndTimes = new int[n];
            String[] input;
            StringBuilder order = new StringBuilder();
            boolean impossible = false;
            int endC = 0, endJ = 0, startC = 0, startJ = 0;

            for (int i = 0; i < n; i++) {
                input = reader.readLine().split(" ");
                startTimes[i] = Integer.parseInt(input[0]);
                endTimes[i] = Integer.parseInt(input[1]);
                originalStartTimes[i] = startTimes[i];
                originalEndTimes[i] = endTimes[i];
            }

            // Bubble sort based on end times
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (endTimes[j] > endTimes[j + 1]) {
                        int temp = endTimes[j];
                        endTimes[j] = endTimes[j + 1];
                        endTimes[j + 1] = temp;

                        temp = startTimes[j];
                        startTimes[j] = startTimes[j + 1];
                        startTimes[j + 1] = temp;
                    }
                }
            }

            // Check if assignments are possible
            for (int i = 0; i < n; i++) {
                if (!impossible) {
                    if (startTimes[i] >= endC) {
                        endC = endTimes[i];
                        continue;
                    }
                    if (startTimes[i] >= endJ) {
                        endJ = endTimes[i];
                        continue;
                    }
                    if (startTimes[i] < endC && startTimes[i] < endJ) {
                        impossible = true;
                        break;
                    }
                }
            }

            endC = 0;
            endJ = 0;
            if (!impossible) {
                for (int i = 0; i < n; i++) {
                    if (!impossible) {
                        if (originalStartTimes[i] >= endC || originalEndTimes[i] <= startC) {
                            startC = originalStartTimes[i];
                            endC = originalEndTimes[i];
                            order.append("C");
                            continue;
                        }
                        if (originalStartTimes[i] >= endJ || originalEndTimes[i] <= startJ) {
                            startJ = originalStartTimes[i];
                            endJ = originalEndTimes[i];
                            order.append("J");
                            continue;
                        }
                        if (originalStartTimes[i] < endC && originalStartTimes[i] < endJ) {
                            impossible = true;
                            break;
                        }
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + order.toString());
            }
            caseNumber++;
            T--;
        }
    }
}