import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            int[] cameron = new int[]{0, 0};
            int[] jamie = new int[]{0, 0};
            StringBuilder workerOrder = new StringBuilder();
            boolean isImpossible = false;

            for (int n = 1; n <= N; n++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();

                if (startTime >= cameron[1] || endTime <= cameron[0]) {
                    workerOrder.append('C');
                    cameron[0] = startTime;
                    cameron[1] = endTime;
                }
                else if (startTime >= jamie[1] || endTime <= jamie[0]) {
                    workerOrder.append('J');
                    jamie[0] = startTime;
                    jamie[1] = endTime;
                }
                else {
                    isImpossible = true;
                    break;
                }
            }

            String line = "Case #" + test_case + ": " + (isImpossible ? "IMPOSSIBLE" : workerOrder.toString());
            System.out.println(line);
        }
    }
}
