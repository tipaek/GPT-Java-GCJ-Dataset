import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine().trim());
        StringBuilder result = new StringBuilder();

        for (int id = 0; id < testCases; id++) {
            int tasks = Integer.parseInt(scanner.nextLine().trim());
            int[] startTimes = new int[tasks];
            int[] endTimes = new int[tasks];

            for (int n = 0; n < tasks; n++) {
                String[] times = scanner.nextLine().trim().split(" ");
                startTimes[n] = Integer.parseInt(times[0]);
                endTimes[n] = Integer.parseInt(times[1]);
            }

            ParentingPartnering parentingPartnering = new ParentingPartnering(id, startTimes, endTimes);
            result.append(parentingPartnering.compute()).append("\n");
        }

        System.out.print(result.toString());
        scanner.close();
    }
}

class ParentingPartnering {
    private int[] startTimes;
    private int[] endTimes;
    private int testId;

    public ParentingPartnering(int testId, int[] startTimes, int[] endTimes) {
        this.testId = testId;
        this.startTimes = startTimes;
        this.endTimes = endTimes;
    }

    public String compute() {
        int[][] schedule = new int[1441][2];
        for (int i = 0; i < 1441; i++) {
            schedule[i][0] = -1;
            schedule[i][1] = -1;
        }

        char[] assignments = new char[startTimes.length];

        for (int i = 0; i < startTimes.length; i++) {
            if (schedule[startTimes[i]][0] == -1) {
                schedule[startTimes[i]][0] = i;
            } else if (schedule[startTimes[i]][1] == -1) {
                schedule[startTimes[i]][1] = i;
            } else {
                return formatOutput("IMPOSSIBLE");
            }
        }

        int cameronAvailableFrom = 0;
        int jamieAvailableFrom = 0;

        for (int i = 0; i < 1441; i++) {
            for (int j = 0; j < 2; j++) {
                if (schedule[i][j] != -1) {
                    int index = schedule[i][j];
                    if (cameronAvailableFrom <= startTimes[index]) {
                        assignments[index] = 'C';
                        cameronAvailableFrom = endTimes[index];
                    } else if (jamieAvailableFrom <= startTimes[index]) {
                        assignments[index] = 'J';
                        jamieAvailableFrom = endTimes[index];
                    } else {
                        return formatOutput("IMPOSSIBLE");
                    }
                }
            }
        }

        return formatOutput(new String(assignments));
    }

    private String formatOutput(String schedule) {
        return "Case #" + (testId + 1) + ": " + schedule;
    }
}