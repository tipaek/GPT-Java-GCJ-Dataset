import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {

            int activityCount = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            int jStart = 0, jEnd = 1;
            int cStart = 0, cEnd = 1;

            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (start >= jEnd) {
                    result.append("J");
                    jStart = start;
                    jEnd = end;
                } else if (start >= cEnd) {
                    result.append("C");
                    cStart = start;
                    cEnd = end;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}