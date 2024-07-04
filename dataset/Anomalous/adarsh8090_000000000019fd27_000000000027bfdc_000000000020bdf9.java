import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            int cameronEnd = 0, jamieEnd = 0;
            boolean isPossible = true;

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (start >= cameronEnd) {
                    cameronEnd = end;
                    schedule.append("C");
                } else if (start >= jamieEnd) {
                    jamieEnd = end;
                    schedule.append("J");
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + schedule.toString());
            }
        }

        scanner.close();
    }
}