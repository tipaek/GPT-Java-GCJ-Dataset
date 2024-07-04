import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int numTasks = scanner.nextInt();
            int[] startTimes = new int[numTasks];
            int[] endTimes = new int[numTasks];

            for (int j = 0; j < numTasks; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }

            StringBuilder result = new StringBuilder("C");
            int cStart = startTimes[0];
            int cEnd = endTimes[0];
            int jStart = 0;
            int jEnd = 0;
            String finalResult = "";

            for (int j = 1; j < numTasks; j++) {
                if (startTimes[j] >= cEnd || endTimes[j] <= cStart) {
                    result.append("C");
                    cEnd = endTimes[j];
                    cStart = startTimes[j];
                } else if (startTimes[j] >= jEnd || endTimes[j] <= jStart) {
                    result.append("J");
                    jEnd = endTimes[j];
                    jStart = startTimes[j];
                } else {
                    finalResult = "IMPOSSIBLE";
                    break;
                }
            }

            if (finalResult.isEmpty()) {
                finalResult = result.toString();
            }

            System.out.println("Case #" + i + ": " + finalResult);
        }
    }
}