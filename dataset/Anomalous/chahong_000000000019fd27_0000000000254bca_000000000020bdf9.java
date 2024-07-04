import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int[][] schedule = new int[t][2];
            Map<Integer, Integer> startTimeToIndex = new HashMap<>();
            int maxEndTime = 0;

            for (int j = 0; j < t; j++) {
                schedule[j][0] = sc.nextInt();
                schedule[j][1] = sc.nextInt();
                startTimeToIndex.put(schedule[j][0], j);
                maxEndTime = Math.max(maxEndTime, schedule[j][1]);
            }

            Arrays.sort(schedule, Comparator.comparingInt(a -> a[0]));

            char[] assignments = new char[t];
            assignments[startTimeToIndex.get(schedule[0][0])] = 'C';
            int cEndTime = schedule[0][1];
            int jEndTime = 0;
            boolean cAvailable = false;
            boolean jAvailable = true;
            boolean isPossible = true;
            int currentIndex = 1;

            for (int currentTime = schedule[1][0]; currentTime < maxEndTime; currentTime++) {
                if (cEndTime == currentTime) {
                    cAvailable = true;
                }
                if (jEndTime == currentTime) {
                    jAvailable = true;
                }

                if (schedule[currentIndex][0] == currentTime) {
                    if (!cAvailable) {
                        if (!jAvailable) {
                            isPossible = false;
                            break;
                        } else {
                            jAvailable = false;
                            jEndTime = schedule[currentIndex][1];
                            assignments[startTimeToIndex.get(schedule[currentIndex][0])] = 'J';
                        }
                    } else {
                        cAvailable = false;
                        cEndTime = schedule[currentIndex][1];
                        assignments[startTimeToIndex.get(schedule[currentIndex][0])] = 'C';
                    }
                    currentIndex++;
                    if (currentIndex == t) {
                        break;
                    }
                }
            }

            String result = isPossible ? new String(assignments) : "IMPOSSIBLE";
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}