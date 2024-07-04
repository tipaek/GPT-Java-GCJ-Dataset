import java.util.*;
import java.io.*;

public class Solution {
    private static class Schedule {
        int start;
        int end;

        Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static Schedule[] cameronSchedules = new Schedule[1001];
    private static Schedule[] jamieSchedules = new Schedule[1001];
    private static String result;
    private static int cameronCount, jamieCount;

    private static void initialize() {
        result = "";
        cameronCount = 0;
        jamieCount = 0;
        for (int i = 0; i <= 1000; i++) {
            cameronSchedules[i] = new Schedule(0, 0);
            jamieSchedules[i] = new Schedule(0, 0);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));    

        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numActivities = scanner.nextInt();

            initialize();
            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (canAssignToCameron(start, end)) {
                    result += "C";
                    cameronSchedules[cameronCount++] = new Schedule(start, end);
                } else if (canAssignToJamie(start, end)) {
                    result += "J";
                    jamieSchedules[jamieCount++] = new Schedule(start, end);
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }

    private static boolean canAssignToCameron(int start, int end) {
        for (int i = 0; i < cameronCount; i++) {
            if (start < cameronSchedules[i].end && end > cameronSchedules[i].start) {
                return false;
            }
        }
        return true;
    }

    private static boolean canAssignToJamie(int start, int end) {
        for (int i = 0; i < jamieCount; i++) {
            if (start < jamieSchedules[i].end && end > jamieSchedules[i].start) {
                return false;
            }
        }
        return true;
    }
}