import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numTasks = scanner.nextInt();
            int[][] tasks = new int[numTasks][2];

            for (int i = 0; i < numTasks; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task[0]));

            StringBuilder schedule = new StringBuilder();
            int cameronEnd = -1;
            int jamieEnd = -1;

            for (int[] task : tasks) {
                int start = task[0];
                int end = task[1];

                if (start >= cameronEnd) {
                    cameronEnd = end;
                    schedule.append("C");
                } else if (start >= jamieEnd) {
                    jamieEnd = end;
                    schedule.append("J");
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNum + ": " + schedule);
        }
    }
}