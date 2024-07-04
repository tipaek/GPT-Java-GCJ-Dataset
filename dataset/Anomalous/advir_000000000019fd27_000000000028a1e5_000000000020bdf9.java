import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < t; i++) {
            int m = scanner.nextInt();
            scanner.nextLine();
            int[][] intervals = new int[m][2];
            for (int j = 0; j < m; j++) {
                String[] interval = scanner.nextLine().split(" ");
                intervals[j][0] = Integer.parseInt(interval[0]);
                intervals[j][1] = Integer.parseInt(interval[1]);
            }

            if (assignTasks(m, intervals)) {
                System.out.print("Case #" + (i + 1) + ": ");
                for (int j = 0; j < m; j++) {
                    System.out.print(schedule[j]);
                }
                System.out.println();
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }

    private static char[] schedule;
    private static boolean[] jamieSchedule;
    private static boolean[] cameronSchedule;

    private static boolean assignTasks(int m, int[][] intervals) {
        schedule = new char[m];
        jamieSchedule = new boolean[1440];
        cameronSchedule = new boolean[1440];

        for (int j = 0; j < m; j++) {
            int start = intervals[j][0];
            int stop = intervals[j][1];

            if (isFree(jamieSchedule, start, stop)) {
                fillSchedule(jamieSchedule, start, stop);
                schedule[j] = 'J';
            } else if (isFree(cameronSchedule, start, stop)) {
                fillSchedule(cameronSchedule, start, stop);
                schedule[j] = 'C';
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean isFree(boolean[] schedule, int start, int stop) {
        for (int k = start; k < stop; k++) {
            if (schedule[k]) {
                return false;
            }
        }
        return true;
    }

    private static void fillSchedule(boolean[] schedule, int start, int stop) {
        for (int k = start; k < stop; k++) {
            schedule[k] = true;
        }
    }
}