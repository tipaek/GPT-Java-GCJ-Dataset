import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int i = 0; i < testCaseCount; i++) {
            int taskCount = scanner.nextInt();
            int[][] tasks = new int[taskCount][4];

            for (int j = 0; j < taskCount; j++) {
                tasks[j][0] = scanner.nextInt();
                tasks[j][1] = scanner.nextInt();
                tasks[j][2] = j;
            }

            Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));

            List<Integer> cameronSchedule = new ArrayList<>();
            List<Integer> jamieSchedule = new ArrayList<>();
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();

            for (int[] task : tasks) {
                int start = task[0];
                int end = task[1];

                if (isTimeSlotBusy(start, end, cameronSchedule) && isTimeSlotBusy(start, end, jamieSchedule)) {
                    isImpossible = true;
                    break;
                } else if (!isTimeSlotBusy(start, end, cameronSchedule)) {
                    fillSchedule(start, end, cameronSchedule);
                    task[3] = 1; // Cameron
                } else {
                    fillSchedule(start, end, jamieSchedule);
                    task[3] = 2; // Jamie
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                Arrays.sort(tasks, Comparator.comparingInt(a -> a[2]));
                for (int[] task : tasks) {
                    result.append(task[3] == 1 ? "C" : "J");
                }
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }

        scanner.close();
    }

    private static void fillSchedule(int start, int end, List<Integer> schedule) {
        for (int i = start; i <= end; i++) {
            schedule.add(i);
        }
    }

    private static boolean isTimeSlotBusy(int start, int end, List<Integer> schedule) {
        for (int i = start; i <= end; i++) {
            if (schedule.contains(i)) {
                return true;
            }
        }
        return false;
    }
}