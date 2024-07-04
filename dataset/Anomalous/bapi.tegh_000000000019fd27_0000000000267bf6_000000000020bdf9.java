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

            for (int job = 0; job < n; job++) {
                String[] input = br.readLine().split(" ");
                startTimes[job] = Integer.parseInt(input[0]);
                endTimes[job] = Integer.parseInt(input[1]);
                jobIds[job] = job;
            }

            // Sorting jobs by their end times
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (endTimes[j] < endTimes[i]) {
                        swap(endTimes, i, j);
                        swap(startTimes, i, j);
                        swap(jobIds, i, j);
                    }
                }
            }

            int cameronEndTime = 0;
            int jamieEndTime = 0;

            for (int i = 0; i < n; i++) {
                if (cameronEndTime <= startTimes[i]) {
                    assignments[jobIds[i]] = 'C';
                    cameronEndTime = endTimes[i];
                } else if (jamieEndTime <= startTimes[i]) {
                    assignments[jobIds[i]] = 'J';
                    jamieEndTime = endTimes[i];
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