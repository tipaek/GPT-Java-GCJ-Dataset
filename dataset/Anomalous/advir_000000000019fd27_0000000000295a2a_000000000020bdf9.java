import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < t; i++) {
            int m = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            int[][] tasks = new int[m][3];

            for (int j = 0; j < m; j++) {
                String[] taskDetails = scanner.nextLine().split(" ");
                for (int k = 0; k < 2; k++) {
                    tasks[j][k] = Integer.parseInt(taskDetails[k]);
                }
                tasks[j][2] = j; // Store the original index
            }

            // Sort tasks by start time
            Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));

            int[] cameron = {-1, -1};
            int[] jamie = {-1, -1};
            String[] schedule = new String[m];
            boolean isPossible = true;

            for (int[] task : tasks) {
                int start = task[0];
                int end = task[1];
                int originalIndex = task[2];

                if (isOverlapping(cameron, start, end)) {
                    if (isOverlapping(jamie, start, end)) {
                        isPossible = false;
                        break;
                    } else {
                        jamie[0] = start;
                        jamie[1] = end;
                        schedule[originalIndex] = "J";
                    }
                } else {
                    cameron[0] = start;
                    cameron[1] = end;
                    schedule[originalIndex] = "C";
                }
            }

            System.out.print("Case #" + (i + 1) + ": ");
            if (isPossible) {
                for (String s : schedule) {
                    System.out.print(s);
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
        scanner.close();
    }

    private static boolean isOverlapping(int[] person, int start, int end) {
        return start < person[1] && end > person[0];
    }
}