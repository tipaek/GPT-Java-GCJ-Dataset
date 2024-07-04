import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int numActivities = scanner.nextInt();
            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];

            List<Integer> cameronStart = new ArrayList<>();
            List<Integer> cameronEnd = new ArrayList<>();
            List<Integer> jamieStart = new ArrayList<>();
            List<Integer> jamieEnd = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();

            for (int i = 0; i < numActivities; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            for (int i = 0; i < numActivities; i++) {
                boolean canAssignToCameron = true;
                boolean canAssignToJamie = true;

                for (int j = 0; j < cameronStart.size(); j++) {
                    if (!(startTimes[i] >= cameronEnd.get(j) || endTimes[i] <= cameronStart.get(j))) {
                        canAssignToCameron = false;
                        break;
                    }
                }

                for (int j = 0; j < jamieStart.size(); j++) {
                    if (!(startTimes[i] >= jamieEnd.get(j) || endTimes[i] <= jamieStart.get(j))) {
                        canAssignToJamie = false;
                        break;
                    }
                }

                if (canAssignToJamie) {
                    schedule.append("C");
                    jamieStart.add(startTimes[i]);
                    jamieEnd.add(endTimes[i]);
                } else if (canAssignToCameron) {
                    schedule.append("J");
                    cameronStart.add(startTimes[i]);
                    cameronEnd.add(endTimes[i]);
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNum + ": " + schedule);
        }
    }
}