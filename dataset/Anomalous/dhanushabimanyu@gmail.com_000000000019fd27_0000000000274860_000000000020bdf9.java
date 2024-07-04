import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int activitiesCount = scanner.nextInt();
            int[] startC = new int[2];
            int[] endC = new int[2];
            int[] startJ = new int[2];
            int[] endJ = new int[2];
            String[] results = {"", ""};

            boolean isPossible = true;

            for (int j = 0; j < activitiesCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isPossibleToAssign(start, end, startC[0], endC[0])) {
                    results[0] += "C";
                    startC[0] = start;
                    endC[0] = end;
                } else if (isPossibleToAssign(start, end, startJ[0], endJ[0])) {
                    results[0] += "J";
                    startJ[0] = start;
                    endJ[0] = end;
                } else {
                    results[0] = "IMPOSSIBLE";
                }

                if (isPossibleToAssign(start, end, startJ[1], endJ[1])) {
                    results[1] += "J";
                    startJ[1] = start;
                    endJ[1] = end;
                } else if (isPossibleToAssign(start, end, startC[1], endC[1])) {
                    results[1] += "C";
                    startC[1] = start;
                    endC[1] = end;
                } else {
                    results[1] = "IMPOSSIBLE";
                }

                if (results[0].equals("IMPOSSIBLE") && results[1].equals("IMPOSSIBLE")) {
                    isPossible = false;
                    break;
                }
            }

            String finalResult = isPossible ? (results[0].equals("IMPOSSIBLE") ? results[1] : results[0]) : "IMPOSSIBLE";
            System.out.println("Case #" + (i + 1) + ": " + finalResult);
        }
    }

    private static boolean isPossibleToAssign(int start, int end, int currentStart, int currentEnd) {
        return start >= currentEnd || end <= currentStart;
    }
}