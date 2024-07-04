
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int noOfTestCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= noOfTestCases; ++testCase) {
            int noOfTasks = in.nextInt();
            int[][] activities = new int[noOfTasks][4];
            for (int task = 0; task < noOfTasks; task++) {
                activities[task][0] = in.nextInt();
                activities[task][1] = in.nextInt();
                activities[task][2] = task; //order of the task
                activities[task][3] = 0;
            }
            // sort by time
            Arrays.sort(activities, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0], o2[0]);
                }
            });
            int[] taskMap = new int[24*60 + 1];
            boolean impossible = false;
            StringBuffer schedule = new StringBuffer();
            for (int task = 0; task < noOfTasks; task++) {
                int startTime = activities[task][0];
                int endTime = activities[task][1];
                if (impossible) {
                    continue;
                }
                int currentParent = 0;
                if (isCurrentParentAvailable(taskMap, startTime, endTime, 1)) {
                    currentParent = 1;
                    activities[task][3] = 1;
                    assignCurrentParent(taskMap, startTime, endTime, 1);
                } else if (isCurrentParentAvailable(taskMap, startTime, endTime, 2)) {
                    currentParent = 2;
                    activities[task][3] = 2;
                    assignCurrentParent(taskMap, startTime, endTime, 2);
                } else  {
                    impossible = true;
                    continue;
                }
            }
            String result = "";
            if (impossible) {
                result = "IMPOSSIBLE";
            } else {
                // sort by order
                Arrays.sort(activities, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return Integer.compare(o1[2], o2[2]);
                    }
                });
                for (int task = 0; task < noOfTasks; task++) {
                    if (activities[task][3] == 1) {
                        result += "C";
                    } else if (activities[task][3] == 2) {
                        result += "J";
                    }
                }
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
