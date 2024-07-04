import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    private static boolean isFree(int[] calendar, int start, int end) {
        for (int i = start; i < end; i++) {
            if (calendar[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int taskCount = Integer.parseInt(scanner.nextLine());
            int[][] tasks = new int[taskCount][3];

            for (int j = 0; j < taskCount; j++) {
                StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                tasks[j][0] = start;
                tasks[j][1] = end;
                tasks[j][2] = j + 1;
            }

            Arrays.sort(tasks, new Comparator<int[]>() {
                @Override
                public int compare(int[] task1, int[] task2) {
                    if (task1[0] == task2[0]) {
                        return Integer.compare(task2[1], task1[1]);
                    }
                    return Integer.compare(task1[0], task2[0]);
                }
            });

            int[] jamieCalendar = new int[24 * 60 + 1];
            int[] cameronCalendar = new int[24 * 60 + 1];
            char[] result = new char[taskCount];
            boolean impossible = false;

            for (int[] task : tasks) {
                int start = task[0];
                int end = task[1];
                int taskNumber = task[2];

                if (isFree(jamieCalendar, start, end)) {
                    Arrays.fill(jamieCalendar, start, end, taskNumber);
                    result[taskNumber - 1] = 'J';
                } else if (isFree(cameronCalendar, start, end)) {
                    Arrays.fill(cameronCalendar, start, end, taskNumber);
                    result[taskNumber - 1] = 'C';
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + testCase + ": ");
                System.out.println(new String(result));
            }
        }

        scanner.close();
    }
}