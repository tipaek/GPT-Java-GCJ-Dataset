import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine().trim());

        for (int testCase = 0; testCase < testCases; testCase++) {
            int tasks = Integer.parseInt(scanner.nextLine().trim());
            int[] startTimes = new int[tasks];
            int[] endTimes = new int[tasks];

            for (int task = 0; task < tasks; task++) {
                String[] timeEntry = scanner.nextLine().trim().split(" ");
                startTimes[task] = Integer.parseInt(timeEntry[0]);
                endTimes[task] = Integer.parseInt(timeEntry[1]);
            }

            ParentingPartnering partner = new ParentingPartnering(testCase, startTimes, endTimes);
            String result = partner.compute();
            System.out.println(result);
        }

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
        int[][] endHash = new int[1441][20];
        for (int i = 0; i < 1441; i++) {
            for (int j = 0; j < 20; j++) {
                endHash[i][j] = -1;
            }
        }

        char[] assignment = new char[endTimes.length];
        for (int i = 0; i < endTimes.length; i++) {
            int j = 0;
            while (j < 20 && endHash[endTimes[i]][j] != -1) {
                j++;
            }
            if (j < 20) {
                endHash[endTimes[i]][j] = i;
            } else {
                return formatOutput("IMPOSSIBLE");
            }
        }

        int cameronFreeFrom = 0;
        int jamieFreeFrom = 0;

        for (int i = 0; i < 1441; i++) {
            for (int j = 0; j < 20; j++) {
                if (endHash[i][j] != -1) {
                    int index = endHash[i][j];
                    if (cameronFreeFrom <= startTimes[index]) {
                        assignment[index] = 'C';
                        cameronFreeFrom = endTimes[index];
                    } else if (jamieFreeFrom <= startTimes[index]) {
                        assignment[index] = 'J';
                        jamieFreeFrom = endTimes[index];
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