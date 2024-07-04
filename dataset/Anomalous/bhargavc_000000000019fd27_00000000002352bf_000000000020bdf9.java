import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine().trim());

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
            System.out.println(parentingPartnering.compute());
        }

        scanner.close();
    }
}

class ParentingPartnering {
    private final int[] startTimes;
    private final int[] endTimes;
    private final int testId;

    public ParentingPartnering(int testId, int[] startTimes, int[] endTimes) {
        this.testId = testId;
        this.startTimes = startTimes;
        this.endTimes = endTimes;
    }

    public String compute() {
        int[][] endHash = new int[1441][2];
        for (int i = 0; i < 1441; i++) {
            endHash[i][0] = -1;
            endHash[i][1] = -1;
        }

        char[] assignment = new char[endTimes.length];

        for (int i = 0; i < endTimes.length; i++) {
            if (endHash[endTimes[i]][0] == -1) {
                endHash[endTimes[i]][0] = i;
            } else if (endHash[endTimes[i]][1] == -1) {
                endHash[endTimes[i]][1] = i;
            } else {
                return formatOutput("IMPOSSIBLE");
            }
        }

        int cameronFreeFrom = 0;
        int jamieFreeFrom = 0;

        for (int i = 0; i < 1441; i++) {
            for (int j = 0; j < 2; j++) {
                if (endHash[i][j] != -1) {
                    int index = endHash[i][j];
                    if (jamieFreeFrom <= startTimes[index]) {
                        assignment[index] = 'J';
                        jamieFreeFrom = endTimes[index];
                    } else if (cameronFreeFrom <= startTimes[index]) {
                        assignment[index] = 'C';
                        cameronFreeFrom = endTimes[index];
                    } else {
                        return formatOutput("IMPOSSIBLE");
                    }
                }
            }
        }

        return formatOutput(new String(assignment));
    }

    private String formatOutput(String schedule) {
        return "Case #" + (testId + 1) + ": " + schedule;
    }
}