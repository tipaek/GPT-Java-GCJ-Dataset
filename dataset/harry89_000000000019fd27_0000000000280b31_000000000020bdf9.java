
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int noOfTestCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= noOfTestCases; ++testCase) {
            int noOfTasks = in.nextInt();
            int[] taskMap = new int[24*60 + 1];
            boolean impossible = false;
            StringBuffer schedule = new StringBuffer();
            for (int task = 0; task < noOfTasks; task++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                if (impossible) {
                    continue;
                }
                int currentParent = 0;
                boolean notAssigned = true;
                if (notAssigned && (taskMap[startTime] & 1) == 0 && (taskMap[endTime] & 1) == 0) {
                    currentParent = 1;
                    notAssigned = isNotAssigned(taskMap, startTime, endTime, currentParent);
                }
                if (notAssigned && (taskMap[startTime] & 2) == 0 && (taskMap[endTime] & 2) == 0) {
                    currentParent = 2;
                    notAssigned = isNotAssigned(taskMap, startTime, endTime, currentParent);
                }
                if (notAssigned) {
                    impossible = true;
                    continue;
                }
                schedule.append(currentParent == 1 ? 'C' : 'J');
            }
            String result = "IMPOSSIBLE";
            if (!impossible) {
                result = schedule.toString();
            }
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static boolean isNotAssigned(int[] taskMap, int startTime, int endTime, int currentParent) {
        boolean notAssigned;
        notAssigned = false;
        // check overlap
        for (int time = startTime; time < endTime; time++) {
            if (taskMap[time] > 2 || (taskMap[time] & currentParent) == currentParent) {
                notAssigned = true;
                break;
            } else {
                taskMap[time] += currentParent;
            }
        }
        return notAssigned;
    }
}
