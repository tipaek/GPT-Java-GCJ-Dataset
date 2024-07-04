import java.util.Scanner;
import java.util.Arrays;

class Solution {

    private static String assignTasks(int[][] tasks) {
        char[] result = new char[tasks.length];
        boolean[] cOccupied = new boolean[24 * 60];
        boolean[] jOccupied = new boolean[24 * 60];

        for (int[] task : tasks) {
            boolean canAssignC = true;
            boolean canAssignJ = true;

            for (int time = task[0]; time < task[1]; time++) {
                if (cOccupied[time]) canAssignC = false;
                if (jOccupied[time]) canAssignJ = false;
            }

            if (canAssignC) {
                Arrays.fill(cOccupied, task[0], task[1], true);
                result[task[2]] = 'C';
            } else if (canAssignJ) {
                Arrays.fill(jOccupied, task[0], task[1], true);
                result[task[2]] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            int numberOfActivities = scanner.nextInt();
            int[][] activities = new int[numberOfActivities][3];

            for (int i = 0; i < numberOfActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }

            Arrays.sort(activities, (a, b) -> Integer.compare(a[0], b[0]));

            String result = assignTasks(activities);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}