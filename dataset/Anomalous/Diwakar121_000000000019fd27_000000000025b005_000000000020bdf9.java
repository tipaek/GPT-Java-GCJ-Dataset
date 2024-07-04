import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] start = new int[1000];
        int[] end = new int[1000];

        for (int z = 0; z < t; z++) {
            int n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                start[i] = scanner.nextInt();
                end[i] = scanner.nextInt();
            }

            System.out.print("Case #" + (z + 1) + ": ");
            if (!scheduleActivities(start, end, n, "", 0)) {
                System.out.print("IMPOSSIBLE");
            }
            System.out.println();
        }
    }

    public static boolean scheduleActivities(int[] start, int[] end, int n, String schedule, int index) {
        if (index == n) {
            System.out.print(schedule);
            return true;
        }

        boolean canAssignC = isSafe('C', start, end, index, schedule);
        boolean canAssignJ = isSafe('J', start, end, index, schedule);

        if (!canAssignC && !canAssignJ) {
            return false;
        }

        if (canAssignC && scheduleActivities(start, end, n, schedule + "C", index + 1)) {
            return true;
        }

        if (canAssignJ && scheduleActivities(start, end, n, schedule + "J", index + 1)) {
            return true;
        }

        return false;
    }

    public static boolean isSafe(char person, int[] start, int[] end, int index, String schedule) {
        for (int k = 0; k < index; k++) {
            if (!(end[index] <= start[k] || start[index] >= end[k])) {
                if (schedule.charAt(k) == person) {
                    return false;
                }
            }
        }
        return true;
    }
}