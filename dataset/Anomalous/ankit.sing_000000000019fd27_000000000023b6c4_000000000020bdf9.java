import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int scheduleCount = scanner.nextInt();
            int endC = 0, startC = Integer.MAX_VALUE;
            int endJ = 0, startJ = Integer.MAX_VALUE;
            StringBuilder result = new StringBuilder();

            for (int schedule = 1; schedule <= scheduleCount; schedule++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (startTime >= endC || endTime <= startC) {
                    result.append("C");
                    startC = startTime;
                    endC = endTime;
                } else if (startTime >= endJ || endTime <= startJ) {
                    result.append("J");
                    startJ = startTime;
                    endJ = endTime;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }
}