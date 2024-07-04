import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScheduleManager {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            int numJobs = Integer.parseInt(br.readLine());
            char[] assignments = new char[numJobs];
            int[] startTimes = new int[numJobs];
            int[] endTimes = new int[numJobs];
            int[] jobIds = new int[numJobs];
            boolean isImpossible = false;

            // Reading job schedules
            for (int job = 0; job < numJobs; job++) {
                String[] input = br.readLine().split(" ");
                startTimes[job] = Integer.parseInt(input[0]);
                endTimes[job] = Integer.parseInt(input[1]);
                jobIds[job] = job;
            }

            // Sorting jobs by their end times
            for (int i = 0; i < numJobs - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < numJobs; j++) {
                    if (endTimes[j] < endTimes[minIndex]) {
                        minIndex = j;
                    }
                }
                swap(startTimes, i, minIndex);
                swap(endTimes, i, minIndex);
                swap(jobIds, i, minIndex);
            }

            int cameronEndTime = 0, jamieEndTime = 0;
            for (int i = 0; i < numJobs; i++) {
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