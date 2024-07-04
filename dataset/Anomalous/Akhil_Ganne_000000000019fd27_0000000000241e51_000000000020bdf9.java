import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        int caseNumber = 1;

        while (testCaseCount-- > 0) {
            writer.write("Case #" + caseNumber + ": ");
            int activityCount = Integer.parseInt(reader.readLine());

            int[] cameronSchedule = new int[1441];
            int[] jamieSchedule = new int[1441];
            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            for (int i = 0; i < activityCount; i++) {
                String[] timeRange = reader.readLine().split(" ");
                int startTime = Integer.parseInt(timeRange[0]);
                int endTime = Integer.parseInt(timeRange[1]);
                boolean canAssignToCameron = true;

                if (isPossible) {
                    for (int j = startTime; j < endTime; j++) {
                        if (cameronSchedule[j] != 0) {
                            canAssignToCameron = false;
                            break;
                        }
                    }

                    if (canAssignToCameron) {
                        result.append("C");
                        for (int j = startTime; j < endTime; j++) {
                            cameronSchedule[j] = 1;
                        }
                    } else {
                        boolean canAssignToJamie = true;
                        for (int j = startTime; j < endTime; j++) {
                            if (jamieSchedule[j] != 0) {
                                canAssignToJamie = false;
                                break;
                            }
                        }

                        if (canAssignToJamie) {
                            result.append("J");
                            for (int j = startTime; j < endTime; j++) {
                                jamieSchedule[j] = 1;
                            }
                        } else {
                            isPossible = false;
                        }
                    }
                }
            }

            if (isPossible) {
                writer.write(result.toString() + "\n");
            } else {
                writer.write("IMPOSSIBLE\n");
            }

            caseNumber++;
        }

        writer.flush();
    }
}