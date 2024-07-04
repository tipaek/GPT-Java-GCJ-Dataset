import java.util.Scanner;

class Solution {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = sc.nextInt();
        for (int t = 1; t < testCases + 1; t++) {
            int nActivities = sc.nextInt();
            boolean impossible = false;
            boolean[] Cschedule = new boolean[1441];
            boolean[] Jschedule = new boolean[1441];
            String solution = "";
            for (int i = 0; i < nActivities; i++) {
                int start = sc.nextInt();
                int stop = sc.nextInt();
                if (freeFromTo(start, stop, Cschedule)) {
                    addTask(start, stop, Cschedule);
                    solution += "C";
                } else if (freeFromTo(start, stop, Jschedule)) {
                    addTask(start, stop, Jschedule);
                    solution += "J";
                } else {
                    impossible = true;
                }
            }
            if (impossible) {
                solution = "IMPOSSIBLE";
            }

            System.out.println("Case #" + t + ": " + solution);
        }
    }

    public static boolean freeFromTo(int timeStart, int timeStop, boolean[] schedule) {
        for (int i = timeStart; i < timeStop; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        if (timeStart == timeStop) {
            return ! schedule[timeStart];
        }
        return true;
    }

    public static void addTask(int timeStart, int timeStop, boolean[] schedule) {
        for (int i = timeStart; i < timeStop; i++) {
            schedule[i] = true;
        }
        if (timeStart == timeStop) {
            schedule[timeStart] = true;
        }
    }
}