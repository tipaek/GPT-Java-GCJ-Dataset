
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
                if (isCurrentParentAvailable(taskMap, startTime, endTime, 1)) {
                    currentParent = 1;
                    assignCurrentParent(taskMap, startTime, endTime, 1);
                } else if (isCurrentParentAvailable(taskMap, startTime, endTime, 2)) {
                    currentParent = 2;
                    assignCurrentParent(taskMap, startTime, endTime, 2);
                } else  {
                    impossible = true;
                    continue;
                }
                schedule.append(currentParent == 1 ? 'C' : 'J');
                if (currentParent == 0) {
                    impossible = true;
                }
            }
            String result = "IMPOSSIBLE";
            if (!impossible) {
                result = schedule.toString();
            }
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static boolean isCurrentParentAvailable(int[] taskMap, int startTime, int endTime, int currentParent) {
        for (int time = startTime; time < endTime; time++) {
            if ((taskMap[time] & currentParent) == currentParent) {
                return false;
            }
        }
        return true;
    }

    private static void assignCurrentParent(int[] taskMap, int startTime, int endTime, int currentParent) {
        for (int time = startTime; time < endTime; time++) {
            taskMap[time] += currentParent;
        }
    }
}
