import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases > 0) {
            int numTasks = scanner.nextInt();
            int[][] tasks = new int[numTasks][2];
            
            for (int i = 0; i < numTasks; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task[1]));

            StringBuilder schedule = new StringBuilder();
            int cameronEnd = -1, jamieEnd = -1;
            boolean impossible = false;

            for (int[] task : tasks) {
                if (task[0] >= cameronEnd) {
                    cameronEnd = task[1];
                    schedule.append('C');
                } else if (task[0] >= jamieEnd) {
                    jamieEnd = task[1];
                    schedule.append('J');
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + schedule);
            }

            caseNumber++;
            testCases--;
        }

        scanner.close();
    }
}