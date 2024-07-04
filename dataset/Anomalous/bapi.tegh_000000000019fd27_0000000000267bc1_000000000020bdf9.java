import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            char[] assignments = new char[n];
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] jobIds = new int[n];
            boolean isImpossible = false;

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                startTimes[i] = Integer.parseInt(input[0]);
                endTimes[i] = Integer.parseInt(input[1]);
                jobIds[i] = i;
            }

            // Sort jobs by end time
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (endTimes[j] < endTimes[i]) {
                        swap(endTimes, i, j);
                        swap(startTimes, i, j);
                        swap(jobIds, i, j);
                    }
                }
            }

            int camEnd = 0, jamEnd = 0;
            for (int i = 0; i < n; i++) {
                if (camEnd <= startTimes[i]) {
                    assignments[jobIds[i]] = 'C';
                    camEnd = endTimes[i];
                } else if (jamEnd <= startTimes[i]) {
                    assignments[jobIds[i]] = 'J';
                    jamEnd = endTimes[i];
                } else {
                    isImpossible = true;
                    break;
                }
            }

            System.out.print("Case #" + t + ": ");
            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(new String(assignments));
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}