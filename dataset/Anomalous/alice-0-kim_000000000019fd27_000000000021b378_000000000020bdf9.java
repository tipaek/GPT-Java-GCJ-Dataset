import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int numActivities = scanner.nextInt();
            int[] lastEndTime = new int[2]; // [CameronEndTime, JamieEndTime]
            String participants = "CJ";
            int currentParticipant = 0; // Start with Cameron
            StringBuilder schedule = new StringBuilder("C");
            int[][] activities = new int[numActivities][2];
            
            for (int i = 0; i < numActivities; i++) {
                activities[i][0] = scanner.nextInt(); // Start time
                activities[i][1] = scanner.nextInt(); // End time
            }

            Arrays.sort(activities, Comparator.comparingInt(activity -> activity[1]));
            lastEndTime[0] = activities[0][1]; // Cameron's first activity end time

            for (int i = 1; i < numActivities; i++) {
                if (activities[i - 1][1] <= activities[i][0]) {
                    schedule.append(participants.charAt(currentParticipant));
                } else {
                    currentParticipant = (currentParticipant + 1) % 2;
                    if (lastEndTime[currentParticipant] <= activities[i][0]) {
                        schedule.append(participants.charAt(currentParticipant));
                    }
                }
            }

            String result = schedule.length() == numActivities ? schedule.toString() : "IMPOSSIBLE";
            System.out.printf("Case #%d: %s\n", t, result);
        }
    }
}