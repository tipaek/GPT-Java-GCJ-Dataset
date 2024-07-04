import java.util.Scanner;

class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int x = scanner.nextInt();
            processTestCase(x, t);
        }
    }

    private static void processTestCase(int row, int caseNumber) {
        int[][] intervals = new int[row][2];
        for (int i = 0; i < row; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }

        StringBuilder result = new StringBuilder();
        boolean jWorking = false, cWorking = false;
        int jEnd = 0, cEnd = 0;

        for (int i = 0; i < row; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (!jWorking && jEnd <= start) {
                jWorking = true;
                jEnd = end;
                result.append("J");
            } else if (!cWorking && cEnd <= start) {
                cWorking = true;
                cEnd = end;
                result.append("C");
            } else {
                result.setLength(0);
                result.append("IMPOSSIBLE");
                break;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }
}