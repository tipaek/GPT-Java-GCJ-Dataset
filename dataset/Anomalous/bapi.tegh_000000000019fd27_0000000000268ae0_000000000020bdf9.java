import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int n = in.nextInt();
            char[] assignments = new char[n];
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] jobIds = new int[n];
            boolean impossible = false;
            
            // Reading jobs
            for (int i = 0; i < n; i++) {
                startTimes[i] = in.nextInt();
                endTimes[i] = in.nextInt();
                jobIds[i] = i;
            }
            
            // Sorting jobs by end time
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (endTimes[j] < endTimes[minIndex]) {
                        minIndex = j;
                    }
                }
                // Swap end times
                int temp = endTimes[i];
                endTimes[i] = endTimes[minIndex];
                endTimes[minIndex] = temp;
                
                // Swap start times
                temp = startTimes[i];
                startTimes[i] = startTimes[minIndex];
                startTimes[minIndex] = temp;
                
                // Swap job IDs
                temp = jobIds[i];
                jobIds[i] = jobIds[minIndex];
                jobIds[minIndex] = temp;
            }
            
            int camEndTime = 0, jamEndTime = 0;
            for (int i = 0; i < n; i++) {
                if (camEndTime <= startTimes[i]) {
                    assignments[jobIds[i]] = 'C';
                    camEndTime = endTimes[i];
                } else if (jamEndTime <= startTimes[i]) {
                    assignments[jobIds[i]] = 'J';
                    jamEndTime = endTimes[i];
                } else {
                    impossible = true;
                    break;
                }
            }
            
            System.out.print("Case #" + t + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(new String(assignments));
            }
        }
    }
}