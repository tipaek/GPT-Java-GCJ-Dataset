import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int taskCount = scanner.nextInt();
            int[] startTimes = new int[taskCount];
            int[] endTimes = new int[taskCount];

            for (int i = 0; i < taskCount; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            assignTasks(startTimes, endTimes, taskCount, testCase);
        }
    }

    public static void assignTasks(int[] startTimes, int[] endTimes, int taskCount, int testCase) {
        StringBuilder result = new StringBuilder("C");
        String currentParent = "C";

        List<Integer> cStartTimes = new ArrayList<>();
        List<Integer> cEndTimes = new ArrayList<>();
        List<Integer> jStartTimes = new ArrayList<>();
        List<Integer> jEndTimes = new ArrayList<>();

        cStartTimes.add(startTimes[0]);
        cEndTimes.add(endTimes[0]);

        int possibleTasks = 1;
        int changeCount = 0;

        for (int i = 1; i < taskCount; i++) {
            if (currentParent.equals("C")) {
                boolean overlap = false;
                for (int j = 0; j < cStartTimes.size(); j++) {
                    if ((startTimes[i] < cEndTimes.get(j) && startTimes[i] >= cStartTimes.get(j)) ||
                        (endTimes[i] > cStartTimes.get(j) && endTimes[i] <= cEndTimes.get(j)) ||
                        (startTimes[i] <= cStartTimes.get(j) && endTimes[i] >= cEndTimes.get(j))) {
                        changeCount++;
                        currentParent = "J";
                        i--;
                        overlap = true;
                        break;
                    }
                }
                if (!overlap) {
                    result.append("C");
                    changeCount = 0;
                    cStartTimes.add(startTimes[i]);
                    cEndTimes.add(endTimes[i]);
                }
            } else {
                boolean overlap = false;
                for (int j = 0; j < jStartTimes.size(); j++) {
                    if ((startTimes[i] < jEndTimes.get(j) && startTimes[i] >= jStartTimes.get(j)) ||
                        (endTimes[i] > jStartTimes.get(j) && endTimes[i] <= jEndTimes.get(j)) ||
                        (startTimes[i] <= jStartTimes.get(j) && endTimes[i] >= jEndTimes.get(j))) {
                        changeCount++;
                        currentParent = "C";
                        i--;
                        overlap = true;
                        break;
                    }
                }
                if (!overlap) {
                    result.append("J");
                    changeCount = 0;
                    jStartTimes.add(startTimes[i]);
                    jEndTimes.add(endTimes[i]);
                }
            }

            if (changeCount >= 2) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                return;
            } else {
                possibleTasks++;
            }
        }

        System.out.println("Case #" + testCase + ": " + result);
    }
}