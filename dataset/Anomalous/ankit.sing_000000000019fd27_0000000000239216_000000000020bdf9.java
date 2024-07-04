import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        for (int test = 1; test <= numberOfTests; test++) {
            int numberOfSchedules = scanner.nextInt();
            int cameronEnd = 0, cameronStart = Integer.MAX_VALUE;
            int jamieEnd = 0, jamieStart = Integer.MAX_VALUE;
            StringBuilder result = new StringBuilder();

            for (int schedule = 1; schedule <= numberOfSchedules; schedule++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (startTime >= cameronEnd || endTime <= cameronStart) {
                    result.append("C");
                    cameronStart = startTime;
                    cameronEnd = endTime;
                } else if (startTime >= jamieEnd || endTime <= jamieStart) {
                    result.append("J");
                    jamieStart = startTime;
                    jamieEnd = endTime;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            if (numberOfSchedules == 1) {
                result = new StringBuilder("J");
            }

            System.out.println("Case #" + test + ": " + result);
        }

        scanner.close();
    }
}