import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < testCases; ++i) {
            int numActivities = scanner.nextInt();
            int startJ = 3700, endJ = -1;
            int startC = 3700, endC = -1;
            StringBuilder schedule = new StringBuilder();

            for (int j = 0; j < numActivities; ++j) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (end <= startJ || endJ <= start) {
                    schedule.append("J");
                    startJ = Math.min(startJ, start);
                    endJ = Math.max(endJ, end);
                } else if (end <= startC || endC <= start) {
                    schedule.append("C");
                    startC = Math.min(startC, start);
                    endC = Math.max(endC, end);
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            result.append("Case #").append(i + 1).append(": ").append(schedule).append("\n");
        }

        System.out.print(result);
    }
}