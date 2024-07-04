import java.util.Scanner;

class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    private static boolean isJWorking = false;
    private static int jStart = 0;
    private static int jEnd = 0;
    private static boolean isCWorking = false;
    private static int caseCount = 1;
    private static int cStart = 0;
    private static int cEnd = 0;
    private static String output = "";

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int rows = scanner.nextInt();
            processTask(rows);
        }
    }

    private static void processTask(int rows) {
        int[][] intervals = new int[rows][2];

        for (int i = 0; i < rows; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }

        for (int i = 0; i < rows; i++) {
            if (cEnd <= intervals[i][0]) {
                isCWorking = true;
                cStart = intervals[i][0];
                cEnd = intervals[i][1];
                output += "C";
            } else if (jEnd <= intervals[i][0]) {
                isJWorking = true;
                jStart = intervals[i][0];
                jEnd = intervals[i][1];
                output += "J";
            } else {
                output = "IMPOSSIBLE";
                break;
            }
        }

        System.out.println("Case #" + caseCount + ": " + output);
        caseCount++;
        resetState();
    }

    private static void resetState() {
        isJWorking = false;
        jStart = 0;
        jEnd = 0;
        isCWorking = false;
        cStart = 0;
        cEnd = 0;
        output = "";
    }
}