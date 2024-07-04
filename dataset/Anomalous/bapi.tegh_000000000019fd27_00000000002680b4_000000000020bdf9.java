import java.io.*;
import java.util.*;

public class Shem {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int minutesInDay = 24 * 60 + 1;
            int jobCount = scanner.nextInt();
            char[] assignments = new char[jobCount];
            int[] startTimes = new int[jobCount];
            int[] endTimes = new int[jobCount];
            int[] jobIds = new int[jobCount];
            boolean isImpossible = false;

            // Reading job details
            for (int job = 0; job < jobCount; job++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                startTimes[job] = start;
                endTimes[job] = end;
                jobIds[job] = job;
            }

            // Sorting jobs by their end times
            for (int i = 0; i < jobCount - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < jobCount; j++) {
                    if (endTimes[j] < endTimes[minIndex]) {
                        minIndex = j;
                    }
                }

                // Swapping end times
                int tempEnd = endTimes[i];
                endTimes[i] = endTimes[minIndex];
                endTimes[minIndex] = tempEnd;

                // Swapping start times
                int tempStart = startTimes[i];
                startTimes[i] = startTimes[minIndex];
                startTimes[minIndex] = tempStart;

                // Swapping job IDs
                int tempId = jobIds[i];
                jobIds[i] = jobIds[minIndex];
                jobIds[minIndex] = tempId;
            }

            int cameronEndTime = 0;
            int jamieEndTime = 0;
            for (int i = 0; i < jobCount; i++) {
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
}