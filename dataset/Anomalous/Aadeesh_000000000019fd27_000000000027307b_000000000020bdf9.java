import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int N = scanner.nextInt();
            int[] startTimes = new int[N];
            int[] endTimes = new int[N];

            for (int i = 0; i < N; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            String result = assignTasks(N, startTimes, endTimes);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static String assignTasks(int N, int[] startTimes, int[] endTimes) {
        List<Integer> cameronStart = new ArrayList<>();
        List<Integer> cameronEnd = new ArrayList<>();
        List<Integer> jamieStart = new ArrayList<>();
        List<Integer> jamieEnd = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();

        for (int i = 0; i < N; i++) {
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

            if (canAssignToCameron) {
                schedule.append("C");
                cameronStart.add(startTimes[i]);
                cameronEnd.add(endTimes[i]);
            } else if (canAssignToJamie) {
                schedule.append("J");
                jamieStart.add(startTimes[i]);
                jamieEnd.add(endTimes[i]);
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }
}