import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int numberOfActivities = scanner.nextInt();
            int[] lastEndTime = new int[2];
            String participants = "CJ";
            int currentParticipant = 0; // Start with Cameron
            int allocatedActivities = 0;
            char[] schedule = new char[numberOfActivities];
            int[][] activities = new int[numberOfActivities][3];
            
            for (int i = 0; i < numberOfActivities; i++) {
                activities[i] = new int[]{scanner.nextInt(), scanner.nextInt(), i};
            }
            
            Arrays.sort(activities, Comparator.comparingInt(a -> a[1]));
            
            schedule[activities[0][2]] = 'C';
            allocatedActivities++;
            lastEndTime[0] = activities[0][1];
            
            for (int i = 1; i < numberOfActivities; i++) {
                if (activities[i - 1][1] <= activities[i][0]) {
                    schedule[activities[i][2]] = participants.charAt(currentParticipant);
                    allocatedActivities++;
                } else {
                    currentParticipant = (currentParticipant + 1) % 2;
                    if (lastEndTime[currentParticipant] <= activities[i][0]) {
                        schedule[activities[i][2]] = participants.charAt(currentParticipant);
                        allocatedActivities++;
                    }
                }
            }
            
            String result = allocatedActivities == numberOfActivities ? new String(schedule) : "IMPOSSIBLE";
            System.out.printf("Case #%d: %s\n", t, result);
        }
    }
}