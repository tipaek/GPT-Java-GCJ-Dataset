import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int events = scanner.nextInt();
            int[][] cameronTasks = new int[events][2];
            int[][] jamieTasks = new int[events][2];
            boolean isImpossible = false;
            StringBuilder schedule = new StringBuilder();

            for (int event = 0; event < events; event++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (event == 0) {
                    cameronTasks[0][0] = start;
                    cameronTasks[0][1] = end;
                    schedule.append("C");
                } else {
                    boolean canCameronTake = true;
                    boolean canJamieTake = true;

                    for (int i = 0; i < event; i++) {
                        if (isOverlap(cameronTasks[i], start, end)) {
                            canCameronTake = false;
                        }
                        if (isOverlap(jamieTasks[i], start, end)) {
                            canJamieTake = false;
                        }
                    }

                    if (canCameronTake) {
                        cameronTasks[event][0] = start;
                        cameronTasks[event][1] = end;
                        schedule.append("C");
                    } else if (canJamieTake) {
                        jamieTasks[event][0] = start;
                        jamieTasks[event][1] = end;
                        schedule.append("J");
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }

            System.out.print("Case #" + testCase + ": ");
            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(schedule.toString());
            }
        }

        scanner.close();
    }

    private static boolean isOverlap(int[] task, int start, int end) {
        return (task[0] < start && start < task[1]) ||
               (task[0] < end && end < task[1]) ||
               (start <= task[0] && end >= task[1]) ||
               (start == task[0] || end == task[1]);
    }
}