import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rs = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(rs.readLine());
        int caseNumber = 1;

        while (T > 0) {
            int n = Integer.parseInt(rs.readLine());
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] originalStartTimes = new int[n];
            int[] originalEndTimes = new int[n];

            for (int i = 0; i < n; i++) {
                String[] input = rs.readLine().split(" ");
                startTimes[i] = Integer.parseInt(input[0]);
                endTimes[i] = Integer.parseInt(input[1]);
                originalStartTimes[i] = startTimes[i];
                originalEndTimes[i] = endTimes[i];
            }

            // Sort the activities by end time
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

            StringBuilder order = new StringBuilder();
            boolean isImpossible = false;
            int endC = 0, endJ = 0;

            for (int i = 0; i < n; i++) {
                if (startTimes[i] >= endC) {
                    endC = endTimes[i];
                    order.append("C");
                } else if (startTimes[i] >= endJ) {
                    endJ = endTimes[i];
                    order.append("J");
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + order.toString());
            }

            caseNumber++;
            T--;
        }
    }
}